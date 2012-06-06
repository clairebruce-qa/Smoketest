package claireandbruce.com.test.navigationWeb;


import junit.framework.Assert;

import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;

/**
 * Verificar la correcta validación del sistema para 
 * el filtro de marcas en el catalogo de mujer.
 * @author NEWSHORE
 * CBT40
 */

public class TestCatalogWomenFilter extends ClaireandbruceTestCase {
	


	@SuppressWarnings("unused")
	@Test
	public void CBT40() throws Exception{
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		if(!selenium.isElementPresent("xpath=//div[5]/div/a")){
			selenium.click("xpath=//img");
			selenium.waitForPageToLoad("15000");
		}
		int j = (int) (Math.random()*(3-2+1))+2;
		//Se verifica que el filtro de marcas existe
		selenium.click("xpath=.//*[@id='nav']/li["+j+"]/h2/a/span/cufon/canvas");
		selenium.waitForPageToLoad("30000");
		
		if(!selenium.isElementPresent("xpath=//dd[@id='filter-2']/ol/li[8]"))
		{
			Assert.fail("El filtro de Marcas no esta disponible");
			
		}
		
		int i = (int) (Math.random()*(10-4+1))+4;
		
		// Selecciona una Marca aleatoria
		if(selenium.isElementPresent("xpath=.//*[@id='filter-2']/ol[1]/li["+i+"]/a")){
			
				
				String check= selenium.getText("xpath=.//*[@id='filter-2']/ol[1]/li["+i+"]/a");
								
				Helper.log(check);
				// Se verifica que un producto efectivamente pertenece a esa Marca
				
				selenium.click("xpath=.//*[@id='filter-2']/ol[1]/li["+i+"]/a");
				selenium.waitForPageToLoad("3000");
				
				if(!(check).equals(selenium.getText("//li/div[2]"))){
					Assert.fail("No se efectuó el filtro");
				}
				selenium.click("xpath=.//*[@id='filter-2']/ol[1]/li["+i+"]/a");
				selenium.waitForPageToLoad("3000");
			
		}
		
		
		// Selecciona una Color aleatoria
		if(selenium.isElementPresent("//dd[2]/div/a["+i+"]/div")){
			
				
				String check= "color "+selenium.getText("//dd[2]/div/a["+i+"]/div");
								
				Helper.log(check);
				// Se verifica que un producto efectivamente pertenece a ese color
				
				selenium.click("//dd[2]/div/a["+i+"]/div");
				selenium.waitForPageToLoad("4000");
				
				if(!selenium.isElementPresent("//ol/li/a")){
					Assert.fail("No se efectuó el filtro por Color");
				}
				selenium.click("//ol/li/a");
				selenium.waitForPageToLoad("3000");
			
		}
		
		
		// Se verifica el filtro de precio \\
		
		int n = (int) (Math.random()*(4-1+1))+1; // Selecciona las categorias de Ropa, Bolsos, Zapatos.
		selenium.click("xpath=.//*[@id='dt-filter-5']");
		if(selenium.isElementPresent("//div["+n+"]/a/div[2]/div")){
			int precio =0;
			
			String check= selenium.getText("//div["+n+"]/a/div[2]/div");
			selenium.click("//div["+n+"]/a/div[2]/div");
			selenium.waitForPageToLoad("3000");
			String precioN=selenium.getText("//span/span");
			Helper.log(precioN);
			int cant=0;
			String nuevoP="";
			while(cant<=(precioN.length()-2)){
				nuevoP=""+precioN.charAt(cant);
				cant++;
				
			}
			
			// Se especifica que filtro fue seleccionado
			if((check).equals("Entre 0 y 100 €")){
				if((precio>100)){
					Assert.fail("Error el filtro no se aplico");
				}
			}
			if((check).equals("Entre 100 y 200 €")){
				
				if((precio>200)){
					Assert.fail("Error el filtro no se aplico");
				}
				
			}	
			if((check).equals("Entre 200 y 300 €")){
				
				if((precio>300)){
					Assert.fail("Error el filtro no se aplico");
				}
				
			}	
				
			if((check).equals("Entre 300 y 400 €")){
				
				if((precio>400)){
					Assert.fail("Error el filtro no se aplico");
				}
			}
			if((check).equals("Entre 400 y 500 €")){
	
				if((precio>500)){
					Assert.fail("Error el filtro no se aplico");
				}
			}
			Helper.log(check);
			// Se verifica que un producto efectivamente pertenece a ese precio
			
			selenium.click("//div["+n+"]/a/div[2]/div");
			selenium.waitForPageToLoad("3000");
		}
		
	}

}
