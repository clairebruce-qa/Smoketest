package claireandbruce.com.test.navigation;

import static org.junit.Assert.assertTrue;
import lib.Claireandbruce;
import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

/**
 * Caso automatizado el 18/04/2012
 * Caso de prueba encargado de verificar la correcta navegabilidad a través de los ítems de las categorías 
 * ROPA (VESTIDOS, BLUSAS, CAMISETAS, SUDADERAS, PUNTO, CHAQUETAS, FALDAS, PANTALONES, SHORTS, MONOS) y 
 * ZAPATOS (ZAPATOS TACON, ZAPATOS PLANOS, SANDALIAS PLANAS, SANDALIAS TACON, BOTAS, CUÑAS, SNEAKERS), 
 * encontrados en la sección central (Categories-outstanding) de la página "Home page".  
 * El éxito del proceso se evaluará al encontrarse la subcategoría seleccionada subrayada en el menú de filtros 
 * de subcategorías, y mostrarse en la sección de "migas de pan"
 * @author María Fernanda Rodríguez Vargas
 *
 */
public class CBT49_Test_NavigationCategoriesOutstanding_RopaZapatos_Homepage extends ClaireandbruceTestCase {
	
	@Test
	public void test_NavigationCategoriesOutstanding_RopaZapatos_Homepage() throws Exception{
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		Helper.log("AMBIENTE DE PRUEBA: "+selenium.getLocation()+"\n");
		
		if(selenium.isTextPresent("Salir")){
			Claireandbruce.logout(selenium);
		}
		
		int columna=1, literal;
		
		if(selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div[1]/h3/cufon/canvas")){
			
			//Se recorre la columna de ropa y zapatos.
			while(selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div["+columna+"]/h3/cufon/canvas") && columna<=2){
				literal=1;
				
				//Se recorre los links
				while(selenium.isElementPresent("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div["+columna+"]/ul/li["+literal+"]/a")){
					String textoLink = selenium.getText("xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div["+columna+"]/ul/li["+literal+"]/a");
					Helper.clickAndVerify(selenium, "xpath=html/body/div/div[2]/div/div/div[1]/div[5]/div["+columna+"]/ul/li["+literal+"]/a", 
							textoLink, "class=breadcrumbs-present");
					Helper.log("\nBread crumbs '"+textoLink+"'. OK.");
					if(selenium.isElementPresent("xpath=html/body/div/div[3]/div[2]/div[2]/div[1]/a["+literal+"]/div/div/strong")){
						Helper.log("Link - submenu underlined");
					} else {
						Helper.log("Link - submenu is not present");
					}
					Helper.log("Link '"+textoLink+"' underlined");
					///Se regresa a HomePage
					selenium.click("xpath=//img[@alt='Claire and Bruce']");
					selenium.waitForPageToLoad("25000");
					
					literal++;
				}
				columna++;
			}
			
		}else {
			Helper.log("Link 'ROPA' not found in Outstanding");
		}	
	}
}
