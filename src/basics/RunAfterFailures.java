package basics;
import java.util.ArrayList;
import java.util.List;

import org.junit.internal.runners.model.MultipleFailureException;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class RunAfterFailures extends Statement {

    private final Statement fNext;
    private final Object fTarget;
    private final List<FrameworkMethod> fAfterFailures;
    
    public RunAfterFailures(Statement next, List<FrameworkMethod> afterFailures, Object target) {
        fNext= next;
        fAfterFailures= afterFailures;
        fTarget= target;
    }

    @Override
    public void evaluate() throws Throwable {
        List<Throwable> fErrors = new ArrayList<Throwable>();
        fErrors.clear();
        try {
            fNext.evaluate();
        } catch (Throwable e) {
            fErrors.add(e);
            for (FrameworkMethod each : fAfterFailures) {
                try {
                    each.invokeExplosively(fTarget, e);
                } catch (Throwable e2) {
                    fErrors.add(e2);
                }
            }
        }
        if (fErrors.isEmpty()) {
            System.out.println("no failures tc:"+ ClaireandbruceTestCase.tc);
            
            //TeraBoxTestCase.tlc.reportTestCaseResult(3722, 1346, 54, "automation", "p");
            
           //System.out.println( TeraBoxTestCase.tlc.about());
                    
            //TeraBoxTestCase.tlc.reportTestCaseResult(TeraBoxTestCase.projectName, TeraBoxTestCase.testPlanName, "at-1" , TeraBoxTestCase.build, "asdadasd", "p");
            
            return;
        }
        if (fErrors.size() == 1) {
        	System.out.println("failures tc: "+ ClaireandbruceTestCase.tc + " "+fErrors.get(0).toString()+"\n");
        	throw fErrors.get(0);
        }
        throw new MultipleFailureException(fErrors);
    }
}