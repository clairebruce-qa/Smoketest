package claireandbruce.com.test.navigationWeb;

import lib.Helper;
import org.junit.Test;
import basics.ClaireandbruceTestCase;
/** 
 * @author NEWSHORE
 * Testlink: Local CBT90  - Privalia CBT70
 */
public class TestNavigationByCategoryHeader extends ClaireandbruceTestCase {
		
	@Test
	public void cbt70() throws Exception{
		selenium.open("");
		selenium.waitForPageToLoad("35000");
		Helper.log("Ambiente de prueba: "+selenium.getLocation());
		
		int menu=1, literal=1;
		String textoMenu="";
		
		//Se ingresa al primer link del menú, el cual corresponde a Rebajas
		Helper.log("Ingresando a Rebajas");
		
		if(selenium.isElementPresent("xpath=//ul[@id='nav']/li/h2/a/span/cufon/canvas")){
			Helper.log("Se ingresa al primer menú: Rebajas");
			selenium.click("xpath=//ul[@id='nav']/li/h2/a/span/cufon/canvas");
			selenium.waitForPageToLoad("25000");
			Helper.log("Se ha ingresado a la interfaz: "+selenium.getTitle());
		} else {
			Helper.log("No se ha encontrado el primer link del menú en: xpath=//ul[@id='nav']/li/h2/a/span/cufon/canvas");
		}
		//Se ingresa a las subcategorías de Rebajas
		Helper.log("Ingresando a Rebajas - Ropa");
		textoMenu = selenium.getText("xpath=//h3/a");
		Helper.clickAndVerify(selenium, "xpath=//h3/a", textoMenu, "css=span.breadcrumbs-present");
		Helper.log("Se ha ingresado a la interfaz: "+selenium.getTitle());
		
		
		literal=2;
		
		while(selenium.isElementPresent("xpath=//li["+literal+"]/h3/a/span") && literal<=5) {
			textoMenu = selenium.getText("xpath=//li["+literal+"]/h3/a/span");
			Helper.clickAndVerify(selenium, "xpath=//li["+literal+"]/h3/a/span", textoMenu, "css=span.breadcrumbs-present");
			Helper.log("Se ha ingresado a la interfaz: "+selenium.getTitle());
			literal++;
		}
		
		menu=2;
		//Se ingresan a las categorías del menú superior (Ropa, Zapatos, Bolsos, Accesorios)
		Helper.log("Ingresando a las categorías del menú superior (Ropa, Zapatos, Bolsos, Accesorios)");
		do {
			selenium.click("xpath=//ul[@id='nav']/li["+menu+"]/h2/a/span/cufon/canvas");
			selenium.waitForPageToLoad("20000");
			Helper.log("Se ha ingresado a la interfaz: "+selenium.getTitle());
			menu++;
		}while(selenium.isElementPresent("xpath=//ul[@id='nav']/li["+menu+"]/h2/a/span/cufon/canvas"));
		
		Helper.log("Se ingresa a la sección Nuevo de Ropa");
		textoMenu = selenium.getText("xpath=//li[2]/ul/li/h3/a/span");
		Helper.clickAndVerify(selenium, "xpath=//li[2]/ul/li/h3/a/span", textoMenu, "css=span.breadcrumbs-present");
		Helper.log("Se ha ingresado a la interfaz: "+selenium.getTitle());
		
		Helper.log("Se ingresa a las secciones Ofertas de Ropa");
		textoMenu = selenium.getText("xpath=//li[2]/ul/li[2]/h3/a");
		Helper.clickAndVerify(selenium, "xpath=//li[2]/ul/li[2]/h3/a", textoMenu, "css=span.breadcrumbs-present");
		Helper.log("Se ha ingresado a la interfaz: "+selenium.getTitle());
		
		Helper.log("Se ingresa a la sección Vestidos, Blusas");
		literal=3;
		menu=2;
		while(selenium.isElementPresent("xpath=//li["+menu+"]/ul/li["+literal+"]/h3/a/span") && literal<=4){
			textoMenu = selenium.getText("xpath=//li["+menu+"]/ul/li["+literal+"]/h3/a/span");
			Helper.clickAndVerify(selenium, "xpath=//li["+menu+"]/ul/li["+literal+"]/h3/a/span", textoMenu, "css=span.breadcrumbs-present");
			Helper.log("Se ha ingresado a la interfaz1: "+selenium.getTitle());
			literal++;
		}
		
		//Se ingresa a las secciones (Camisetas, Sudaderas, Punto, Chaquetas, Faldas, Pantalones, Shorts, Monos, Jeans)
		Helper.log("Se ingresa a las secciones (Camisetas, Sudaderas, Punto, Chaquetas, Faldas, Pantalones, Shorts, Monos, Jeans)");
		literal=5;
		while(selenium.isElementPresent("xpath=//li["+literal+"]/h3/a/span") && literal<=13){
			textoMenu = selenium.getText("xpath=//li["+literal+"]/h3/a/span");
			Helper.clickAndVerify(selenium, "xpath=//li["+literal+"]/h3/a/span", textoMenu, "css=span.breadcrumbs-present");
			Helper.log("Se ha ingresado a la interfaz2: "+selenium.getTitle());
			literal++;
		}
		
		menu=3; //Zapatos
		//Se ingresa a Zapatos - Nuevo
		textoMenu = selenium.getText("xpath=//li["+menu+"]/ul/li/h3/a/span");
		Helper.clickAndVerify(selenium, "xpath=//li["+menu+"]/ul/li/h3/a/span", textoMenu, "css=span.breadcrumbs-present");
		Helper.log("Se ha ingresado a la interfaz: "+selenium.getTitle());
		
		//Se ingresa a la sección (Ofertas, Zapatos Tacón, Zapatos planos, Sandalias planas, Sandalias Tacón, Botas, Cuñas)
		Helper.log("Se ingresa a las secciones (Ofertas, Zapatos Tacón, Zapatos planos, Sandalias planas, Sandalias Tacón, Botas, Cuñas)");
		literal=2;
		while(selenium.isElementPresent("xpath=//li["+menu+"]/ul/li["+literal+"]/h3/a/span")){
			textoMenu = selenium.getText("xpath=//li["+menu+"]/ul/li["+literal+"]/h3/a/span");
			Helper.clickAndVerify(selenium, "xpath=//li["+menu+"]/ul/li["+literal+"]/h3/a/span", textoMenu, "css=span.breadcrumbs-present");
			Helper.log("Se ha ingresado a la interfaz: "+selenium.getTitle());
			literal++;
		}
		
		//Se ingresa a Sneakers
		Helper.log("Se ingresa a Sneakers");
		literal=9;
		textoMenu = selenium.getText("xpath=//li["+menu+"]/ul/li["+literal+"]/h3/a/span");
		Helper.clickAndVerify(selenium, "xpath=//li["+menu+"]/ul/li["+literal+"]/h3/a", textoMenu, "css=span.breadcrumbs-present");
		Helper.log("Se ha ingresado a la interfaz: "+selenium.getTitle());
		
		//Se ingresa a las subcategorías de Bolsos
		menu=4;
		Helper.log("Se ingresa a las subcategorías de Bolsos");
		textoMenu = selenium.getText("xpath=//li["+menu+"]/ul/li/h3/a/span");
		Helper.clickAndVerify(selenium, "xpath=//li["+menu+"]/ul/li/h3/a/span", textoMenu, "css=span.breadcrumbs-present");
		Helper.log("Se ha ingresado a la interfaz: "+selenium.getTitle());
		
		//Se ingresa a Ofertas, Clutches y Shoulder Bags
		Helper.log("Se ingreaa a Ofertas, Clutches y Shoulder Bags");
		literal=2;
		while(selenium.isElementPresent("xpath=//li["+menu+"]/ul/li["+literal+"]/h3/a/span")){
			textoMenu = selenium.getText("xpath=//li["+menu+"]/ul/li["+literal+"]/h3/a/span");
			Helper.clickAndVerify(selenium, "xpath=//li["+menu+"]/ul/li["+literal+"]/h3/a/span", textoMenu, "css=span.breadcrumbs-present");
			Helper.log("Se ha ingresado a la interfaz: "+selenium.getTitle());
			literal++;
			if(literal==4){
				literal++;
			}
		}
		
		//Se ingresa a Totes
		Helper.log("Se ingresa a Totes");
		literal=3;
		textoMenu = selenium.getText("xpath=//li["+menu+"]/ul/li["+literal+"]/h3/a");
		Helper.clickAndVerify(selenium, "xpath=//li["+menu+"]/ul/li["+literal+"]/h3/a", textoMenu, "css=span.breadcrumbs-present");
		Helper.log("Se ha ingresado a la interfaz: "+selenium.getTitle());
		
		//Se ingresa a las subcategorías de Accesorios
		Helper.log("Se ingresa a las subcategorías de Accesorios");
		menu=5;
		textoMenu = selenium.getText("xpath=//li["+menu+"]/ul/li/h3/a");
		Helper.clickAndVerify(selenium, "xpath=//li["+menu+"]/ul/li/h3/a", textoMenu, "css=span.breadcrumbs-present");
		Helper.log("Se ha ingresado a la interfaz: "+selenium.getTitle());
		
		literal=2;
		while(selenium.isElementPresent("xpath=//li["+menu+"]/ul/li["+literal+"]/h3/a/span")){
			textoMenu = selenium.getText("xpath=//li["+menu+"]/ul/li["+literal+"]/h3/a/span");
			Helper.clickAndVerify(selenium, "xpath=//li["+menu+"]/ul/li["+literal+"]/h3/a/span", textoMenu, "css=span.breadcrumbs-present");
			Helper.log("Se ha ingresado a la interfaz: "+selenium.getTitle());
			literal++;
		}
		
	}
}
