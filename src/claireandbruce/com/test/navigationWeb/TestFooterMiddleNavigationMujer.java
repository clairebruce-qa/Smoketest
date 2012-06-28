package claireandbruce.com.test.navigationWeb;

import static org.junit.Assert.*;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * 
 * @author NEWSHORE
 * CBT94
 */
public class TestFooterMiddleNavigationMujer extends ClaireandbruceTestCase{
	
	@Test
	public void CBT94() throws Exception{
		
		
		selenium.open("");
		int columna=1;
		
		//Verificación de la presencia de los enlaces en la página de bienvenida
		while(columna<=4){
		
			//Obtiene el texto de cada link para verificarlo en la ventana de despliegue
			String texto= selenium.getText("xpath=html/body/div/div[4]/div/div[3]/div["+columna+"]/div[1]/a");
			
			//Se Carga y verifica las interfaces de cada link 
			Helper.clickAndVerify(selenium, "xpath=html/body/div/div[4]/div/div[3]/div["+columna+"]/div[1]/a", texto, "class=breadcrumbs-present");
			//Se Retorna a la página Principal de Bienvenida
			Helper.clickAndVerify(selenium, "xpath=//img", "Tu cuenta", "link=Tu cuenta");
			int div=2;
			if(columna==1){
				texto=selenium.getText("xpath=//div[3]/div/div[2]/ul/li/a");
				Helper.clickAndVerify(selenium, "xpath=//div[3]/div/div[2]/ul/li/a", texto, "class=breadcrumbs-present");
				texto=selenium.getText("xpath=//div[3]/div/div[2]/ul/li[2]/a");
				Helper.clickAndVerify(selenium, "xpath=//div[3]/div/div[2]/ul/li[2]/a", texto, "class=breadcrumbs-present");
				int literal=4;
				while(literal<=13){
					texto=selenium.getText("xpath=//li["+4+"]/a");
					if(literal!=8){
						Helper.clickAndVerify(selenium, "xpath=//li["+4+"]/a", texto, "class=breadcrumbs-present");
					} else {
						Helper.clickAndVerify(selenium, "xpath=//div[2]/ul/li[8]/a", texto, "class=breadcrumbs-present");
					}
					literal++;
					Helper.clickAndVerify(selenium, "xpath=//img", "Tu cuenta", "link=Tu cuenta");
				}
			
			} else {
				texto=selenium.getText("xpath=//div["+div+"]/div[2]/ul/li/a");
				Helper.clickAndVerify(selenium, "xpath=//div["+div+"]/div[2]/ul/li/a", texto, "class=breadcrumbs-present");
				texto=selenium.getText("xpath=//div[3]/div/div[2]/ul/li[2]/a");
				Helper.clickAndVerify(selenium, "xpath=//div[3]/div/div[2]/ul/li[2]/a", texto, "class=breadcrumbs-present");			
			}
			
			//Se Retorna a la página Principal de Bienvenida
			Helper.clickAndVerify(selenium, "xpath=//img", "Tu cuenta", "link=Tu cuenta");
			columna++;
			
		}
	}
}