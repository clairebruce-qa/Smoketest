package basics;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import com.thoughtworks.selenium.DefaultSelenium;

/**
 * JUnit runner which runs all @AfterFailure methods in a test class.
 *
 */
public class RCRunner extends BlockJUnit4ClassRunner {
	

    /**
     * @param klass Test class
     * @throws InitializationError
     *             if the test class is malformed.
     */
    public RCRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }


    /*
     * Override withAfters() so we can append to the statement which will invoke the test
     * method. We don't override methodBlock() because we wont be able to reference 
     * the target object. 
     */
    @Override
    protected Statement withAfters(FrameworkMethod method, Object target, 
                                   Statement statement) {
        statement = super.withAfters(method, target, statement);
        return withAfterFailures(method, target, statement);
    }

    protected Statement withAfterFailures(FrameworkMethod method, Object target, 
                                          Statement statement) {
        List<FrameworkMethod> failures =
            getTestClass().getAnnotatedMethods(AfterFailure.class);
        return new RunAfterFailures(statement, failures, target);
    }    
    
    static String testName;   

    protected static void setName(final String name) {
    	testName = name;
    }

    protected static String getTestName() {
	    if (testName == null)
	    return null;
	
	    int last = testName.indexOf('(');
	    if (last < 0)
	    last = testName.length() + 1;
	    return testName.substring(0, last);
    }

    private static class NameListener extends RunListener {
    	/** Record start of tests, not suites */
	    public void testStarted(Description description) throws Exception {
		    //System.err.println(" STARTED: " + description.getDisplayName()+"\n");
		    setName(description.isTest() ? description.getDisplayName() : null);
	    }
	
	    public void testFinished(Description description) throws Exception {	
		    //System.err.println("FINISHED: " + description.getDisplayName()+"\n");
		    if (testName != null)
		    if (testName.equals(description.getDisplayName()))
		    setName(null);
		    else
		    throw new Exception("Test name mismatch");
	    }
    }
    
    public void run(final RunNotifier notifier) {
	    notifier.addListener(new NameListener());
	    super.run(notifier);
    } 
}
