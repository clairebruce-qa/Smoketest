package claireandbruce.com.test.navigationWeb;


import junit.framework.Assert;

import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

/**
 *Verificar  la validacion del filtro de precio en el catalogo de mujer, en orden ascendente, descente
 *Verificar el correcto despliegue de las vistas de los articulos en el catalogo de mujer (look, producto)
 * @author NEWSHORE
 * Testlink: Local CBT41  - Privalia CBT62
 */

public class TestCatalogWomen2TestCatalogWomenFilterPriceViewsProductLook extends ClaireandbruceTestCase {

	@SuppressWarnings("unused")
	@Test
	public void cbt62() throws Exception{
		Helper.log("Prueba de filtro de ordenamiento del catalogo de mujer");
		Helper.log("Se ingresa a la página "+ClaireandbruceUrl);
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		if(!selenium.isElementPresent("xpath=//div[5]/div/a")){
			Helper.log("Se carga homepage");
			selenium.click("xpath=//img");
			selenium.waitForPageToLoad("15000");
		}
		int j = (int) (Math.random()*(3-2+1))+2;
	
		// Se selecciona una categoria
		Helper.log("Se ingresa a una categoría");
		selenium.click("xpath=.//*[@id='nav']/li[3]/h2/a/span/cufon/canvas");
		Helper.log("Se espera carga de la interfaz");
		selenium.waitForPageToLoad("30000");
		
		if(!selenium.isElementPresent("css=div.selreplace_selectbutton"))
		{
			Assert.fail("El filtro de Precio no esta disponible");
			
		}
		
		int i = (int) (Math.random()*(10-4+1))+4;
		
		// ---- **** ORDENAR DE MAYOR A MENOR **** ----\\
		if(selenium.isElementPresent("xpath=html/body/div[1]/div[3]/div[1]/div/div[1]/div[3]/div/div[2]/div/div/div[2]")){
			Helper.log("Ordenar de precio mayor a menor");
			
			selenium.click("xpath=html/body/div[1]/div[3]/div[1]/div/div[1]/div[3]/div/div[2]/div/div/div[2]");
			selenium.waitForPageToLoad("30000");
			double precio =0.00;
			int cant=0;
			String nuevoP="";
			
			// Se extrae el precio Mayor
			String texto ="";
			Helper.log("Se obtiene el precio mayor");
				texto = selenium.getText("//span/span");
			
			
			
			Helper.log("Precio obtenido "+texto);
			
			while(cant<(texto.length()-2)){
				if(texto.charAt(cant)!=',') {
					nuevoP+=texto.charAt(cant);
				}
				else{
					nuevoP+=".";
				}
				cant++;				
			}
			Helper.log("PRECIO MAYOR "+nuevoP);
			precio=Double.parseDouble(nuevoP);
			
			double precio2 =0.00;
			// Se extrae el precio Menor
			String texto2 ="";
			String nuevoP2="";			
			
			texto2 = selenium.getText("//li[3]/div[4]/div/span/span");
			
			Helper.log(texto2);
			int cant2=0;
			
			while(cant2<(texto2.length()-2)){
				
				if(texto2.charAt(cant2)!=',') {
					nuevoP2+=texto2.charAt(cant2);
				}
				else{
					nuevoP2+=".";
				}
				cant2++;				
			}
			precio2=Double.parseDouble(nuevoP2);
			Helper.log("// ---- **** ORDENAR DE MAYOR A MENOR **** ----\\");
			Helper.log("PRECIO MAYOR "+nuevoP);
			Helper.log("PRECIO MENOR "+nuevoP2);
			if(precio<precio2){
				Assert.fail("Los productos no estan ordenados");
			}
		}
		
		
		// ---- **** ORDENAR DE MENOR A MAYOR **** ----\\
		if(selenium.isElementPresent("xpath=html/body/div[1]/div[3]/div[1]/div/div[1]/div[3]/div/div[2]/div/div/div[1]")){
			
			selenium.click("xpath=html/body/div[1]/div[3]/div[1]/div/div[1]/div[3]/div/div[2]/div/div/div[1]");
			selenium.waitForPageToLoad("30000");
			double precio =0.00;
			int cant=0;
			String nuevoP="";
			
			// Se extrae el precio Mayor
			String texto ="";
			if(selenium.isElementPresent("class=special-price")) {
				texto = selenium.getText("class=special-price");
			} else {
				texto = selenium.getText("class=price");
			}
			
			Helper.log(texto);
			
			while(cant<(texto.length()-2)){
				if(texto.charAt(cant)!=',') {
					nuevoP+=texto.charAt(cant);
				}
				else{
					nuevoP+=".";
				}
				cant++;			
			}
			
			precio=Double.parseDouble(nuevoP);
			
			double precio2 =0.00;
			// Se extrae Menor 
			String texto2 ="";
			String nuevoP2="";
			
			
			if(selenium.isElementPresent("//ul[2]/li[2]/div[4]/div/p[3]/span")) {
				texto2 = selenium.getText("//ul[2]/li[2]/div[4]/div/p[3]/span");
			} else {
				texto2 = selenium.getText("//ul[2]/li[2]/div[4]/div/p/span");
			}
			
			Helper.log(texto2);
			int cant2=0;
			
			while(cant2<(texto2.length()-2)){
				
				if(texto2.charAt(cant2)!=',') {
					nuevoP2+=texto2.charAt(cant2);
				}
				else{
					nuevoP2+=".";
				}
				cant2++;			
			}
			precio2=Double.parseDouble(nuevoP2);
			Helper.log("// ---- **** ORDENAR DE MENOR A MAYOR **** ----\\");
			Helper.log("PRECIO MAYOR "+nuevoP2);
			Helper.log("PRECIO MENOR"+nuevoP);
			if(precio>precio2){
				Assert.fail("Los productos no estan ordenados");
			}
		}
		
		
		// ---*** Se Carga el catalogo de Ropa ***---\\
		selenium.click("xpath=.//*[@id='nav']/li[1]/h2/a/span/cufon/canvas");
		selenium.waitForPageToLoad("30000");
						
		
		// ---- **** VISTA POR LOOK **** ----\\
		
		
		if(!selenium.isElementPresent("xpath=.//*[@id='productMode']") || !selenium.isElementPresent("xpath=.//*[@id='totalLookMode']") )
		{
			Assert.fail("El link de vista por producto y look no estan disponible");			
		}
		
		
		// ---- **** VISTA POR NOVEDADES  **** ----\\		
		

		if(!selenium.isElementPresent("xpath=html/body/div[1]/div[3]/div[1]/div/div[1]/div[3]/div/div[2]/div/div/div[3]") )
		{
			Assert.fail("El link de vista por producto y look no estan disponible");
			
		}
		if(selenium.isElementPresent("xpath=html/body/div[1]/div[3]/div[1]/div/div[1]/div[3]/div/div[2]/div/div/div[3]")){
			
			selenium.click("xpath=html/body/div[1]/div[3]/div[1]/div/div[1]/div[3]/div/div[2]/div/div/div[3]");
			selenium.waitForPageToLoad("30000");
		}
		
		if(selenium.isTextPresent("NEW") || selenium.isTextPresent("Nueva Promoción"))
		{
			Helper.log("Se han encontrado productos con etiqueta de Nuevo o Nueva Promoción");
		} else {
			Helper.log("No se han encontrado productos con etiqueta de Nuevo o Nueva Promoción");
		}
	
	}

}
