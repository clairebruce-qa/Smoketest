package claireandbruce.com.test.navigationWeb;

import junit.framework.Assert;
import lib.Helper;
import org.junit.Test;
import basics.ClaireandbruceTestCase;

/**
 * Verificar la correcta validación del sistema para 
 * el filtro de marcas en el catalogo de mujer.
 * @author NEWSHORE
 * Testlink: Local CBT40  - Privalia CBT51
 */

public class TestCatalogWomen1TestCatalogWomenFilter extends ClaireandbruceTestCase {
	
	@Test
	public void cbt51() throws Exception{
		Helper.log("Prueba de filtros del catalogo de mujer");
		Helper.log("Se carga la página "+ClaireandbruceUrl);
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		if(!selenium.isElementPresent("xpath=//div[5]/div/a")){
			Helper.log("Se ingresa a homepage");
			selenium.click("xpath=//img");
			selenium.waitForPageToLoad("15000");
		}
		int j = (int) (Math.random()*(3-2+1))+2;
		//Se verifica que el filtro de marcas existe
		Helper.log("Se verifica que el filtro de marcas existe");
		selenium.click("xpath=.//*[@id='nav']/li["+j+"]/h2/a/span/cufon/canvas");
		selenium.waitForPageToLoad("30000");
		
		if(!selenium.isElementPresent("xpath=//dd[@id='filter-2']/ol/li[8]"))
		{
			Assert.fail("El filtro de Marcas no esta disponible");
			
		}
		
		int i = (int) (Math.random()*(10-4+1))+4;
		
		// Selecciona una Marca aleatoria
		if(selenium.isElementPresent("xpath=.//*[@id='filter-2']/ol[1]/li["+i+"]/a")){
			Helper.log("Se ingreas a una marca aleatoria del filtro");
				
				String check= selenium.getText("xpath=.//*[@id='filter-2']/ol[1]/li["+i+"]/a");
								
				Helper.log("Marca seleccionada "+check);
				// Se verifica que un producto efectivamente pertenece a esa Marca
				Helper.log("Se verifica que se encuentre un producto de dicha marca");
				selenium.click("xpath=.//*[@id='filter-2']/ol[1]/li["+i+"]/a");
				selenium.waitForPageToLoad("30000");
				
				if(!(check).equals(selenium.getText("//li/div[2]"))){
					Assert.fail("No se efectuó el filtro");
				}
				selenium.click("xpath=.//*[@id='filter-2']/ol[1]/li["+i+"]/a");
				selenium.waitForPageToLoad("30000");
			
		}
		
		
		// Selecciona una Color aleatoria
		if(selenium.isElementPresent("//dd[2]/div/a["+i+"]/div")){
			
				Helper.log("Se selecciona un color aleatorio para el filtro");
				String check= "color "+selenium.getText("//dd[2]/div/a["+i+"]/div");
								
				Helper.log("Color seleccionado "+check);
				// Se verifica que un producto efectivamente pertenece a ese color
				Helper.log("Se verifica que un producto pertenezca a este color");
				selenium.click("//dd[2]/div/a["+i+"]/div");
				selenium.waitForPageToLoad("40000");
				
				if(!selenium.isElementPresent("//ol/li/a")){
					Assert.fail("No se efectuó el filtro por Color");
				}
				selenium.click("//ol/li/a");
				selenium.waitForPageToLoad("30000");
			
		}
		
		
		// Se verifica el filtro de precio \\
		
		int n = (int) (Math.random()*(4-1+1))+1; // Selecciona las categorias de Ropa, Bolsos, Zapatos.
		selenium.click("xpath=.//*[@id='dt-filter-5']");
		if(selenium.isElementPresent("//div["+n+"]/a/div[2]/div")){
			double precio =0;
			Helper.log("Se selecciona un filtro por precio de forma aleatoria");
			String check= selenium.getText("//div["+n+"]/a/div[2]/div");
			Helper.log("Se selecciona el filtro "+check);
			selenium.click("//div["+n+"]/a/div[2]/div");
			selenium.waitForPageToLoad("30000");
			String precioN=selenium.getText("//span/span");
			Helper.log(precioN);
			int cant=0;
			String nuevoP="";
			while(cant<(precioN.length()-2)){
				if(precioN.charAt(cant)!=',') {
					nuevoP+=""+precioN.charAt(cant);
				}
				else{
					nuevoP+=".";
				}
				
				cant++;
				
			}
			precio=Double.parseDouble(nuevoP);
			
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
			Helper.log("Se verifica que un producto posea este rango de precio");
			selenium.click("//div["+n+"]/a/div[2]/div");
			selenium.waitForPageToLoad("30000");
		}
		
	}

}
