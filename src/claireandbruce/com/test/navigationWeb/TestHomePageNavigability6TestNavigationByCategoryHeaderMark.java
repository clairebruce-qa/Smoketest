package claireandbruce.com.test.navigationWeb;

import junit.framework.Assert;
import lib.Helper;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

/**
 * 
 * @author NEWSHORE
 * Testlink: Local CBT39  - Privalia CBT8
 */
public class TestHomePageNavigability6TestNavigationByCategoryHeaderMark extends ClaireandbruceTestCase{
	@Test
	public void cbt8() throws Exception{
		Helper.log("Prueba de navegación por Marcas en el header");
		Helper.log("Se carga la página "+ClaireandbruceUrl);
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		if(selenium.isElementPresent("link=Salir")) {
			Helper.log("Se encuentra activa una sesión de usuario");
			selenium.click("link=Salir");
			selenium.waitForPageToLoad("15000");
		}
		
		
		//Clic en el link MARCAS 
		//if(selenium.isElementPresent("xpath=.//*[@id='nav']/li[5]/a/span/cufon/canvas")){
		Helper.log("Se ingresa al link Marcas");
			if(selenium.isElementPresent("xpath=//li[6]/h2/a/span/cufon/canvas")){
			selenium.click("xpath=//li[6]/h2/a/span/cufon/canvas");
			Helper.log("Se espera carga de la interfaz");
			selenium.waitForPageToLoad("30000");
			int cont=1; //Se tomaran como maximo de 4 marcas mostradas en el carrusel
			//Se da click en el link hasta que vuelva a estar visible la primera imagen de marca presente (French Connection)
			Helper.log("Se navega por el carrusel de marcas");
			while(cont<=5){
				selenium.click("xpath=//a[@id='next']/img");
				cont++;
			}
			cont=1;
			Helper.log("Se navega por los links 'Descubrir la colección' y 'Ver las novedades'");
			while(cont<=5){
				//Click en Descubrir la coleccion
				//Helper.log("Checking link 'Descubrir la coleccion' of "+selenium.getText("xpath=.//*[@id='carousel']/ul/li["+cont+"]/div/p[1]"));
				String checkColeccion= selenium.getText("xpath=.//*[@id='carousel']/ul/li["+cont+"]/div/p[1]");
				if(selenium.isTextPresent(checkColeccion)) {	
					selenium.click("//a[contains(text(),'Marcas')]");
					selenium.waitForPageToLoad("20000");					
				} else {					
					//Volver a Marcas
					//Helper.log("Link "+texto+" no found");
					selenium.click("//a[contains(text(),'Marcas')]");
					selenium.waitForPageToLoad("20000");					
				}
				selenium.click("xpath=.//*[@id='carousel']/ul/li["+cont+"]/div/p[3]/a");
				
				selenium.waitForPageToLoad("25000");
				//Volver a Marcas
				selenium.click("//a[contains(text(),'Marcas')]");
				selenium.waitForPageToLoad("25000");
				
				Helper.log("Checking link 'Ver las novedades' of "+selenium.getText("xpath=.//*[@id='carousel']/ul/li["+cont+"]/div/p[1]"));
				//Click en Ver las novedades
				selenium.click("xpath=.//*[@id='carousel']/ul/li["+cont+"]/div/p[4]/a");
				selenium.waitForPageToLoad("25000");
				//Volver a Marcas
				selenium.click("//a[contains(text(),'Marcas')]");
				selenium.waitForPageToLoad("25000");
				cont++;
			}
			
			//Se verifican los enlaces a las diferentes marcas que se encuentran en la interfaz Marcas
			int columna=1, lista=2, literal=2;
			
			//Se recorre las columnas
			while(columna<=4){
				//Se recorren las listas .//*[@id='listBrands']/div[1]/ul[2]/li[1]
				while(selenium.isElementPresent("xpath=.//*[@id='listBrands']/div["+columna+"]/ul["+lista+"]/li[1]")){
					//Se recorren los literales
					while(selenium.isElementPresent("xpath=.//*[@id='listBrands']/div["+columna+"]/ul["+lista+"]/li["+literal+"]/a") ||
							selenium.isElementPresent("xpath=.//*[@id='listBrands']/div["+columna+"]/ul["+lista+"]/li["+literal+"]")){
						//Se obtiene el texto para determinar si el enlace se encuentra activo
						
						if(selenium.isElementPresent("xpath=.//*[@id='listBrands']/div["+columna+"]/ul["+lista+"]/li["+literal+"]/a")){
							String texto = selenium.getText("xpath=.//*[@id='listBrands']/div["+columna+"]/ul["+lista+"]/li["+literal+"]/a");
							//Si el enlace se encuentra ingresar en el
							Helper.log("Se ingresa a la marca "+texto);
							selenium.click("xpath=.//*[@id='listBrands']/div["+columna+"]/ul["+lista+"]/li["+literal+"]/a");
							
							selenium.waitForPageToLoad("30000");
							if(selenium.getTitle().equals(texto.toUpperCase())) {
								Helper.log("Link "+texto+" está activo");
								selenium.click("//a[contains(text(),'Marcas')]");
								selenium.waitForPageToLoad("20000");								
							} else {								
								//Volver a Marcas
								//Helper.log("Link "+texto+" no found");
								selenium.click("//a[contains(text(),'Marcas')]");
								selenium.waitForPageToLoad("20000");							
							}							
							
						}else if(selenium.isElementPresent("xpath=.//*[@id='listBrands']/div["+columna+"]/ul["+lista+"]/li["+literal+"]")){
							String texto = selenium.getText("xpath=.//*[@id='listBrands']/div["+columna+"]/ul["+lista+"]/li["+literal+"]");
							Helper.log("Link "+texto+" no se encuentra activo");							
						}						
						literal++;
					}
					lista++;
					literal=2;
				}				
				columna++;
				lista=1;
				literal=2;
			}			
		} else {
			Helper.log("Link 'MARCAS' no se encuentra presente");
			Assert.fail("link not found: Marcas");
		}
	}
}
