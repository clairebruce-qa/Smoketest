package claireandbruce.com.test.navigationWeb;

import lib.Helper;

import org.junit.Test;

import basics.ClaireandbruceTestCase;
/**
 * 
 * @author NEWSHORE
 *
 */
public class TestNavigationTopQuestions extends ClaireandbruceTestCase {
		
	@Test
	public void CBT92() throws Exception{
		selenium.open("");
		selenium.waitForPageToLoad("15000");
		
		//Ingreso a la página 'help' por medio de alguna de las opciones de la home
		//Opciones: Link Ayuda [Footer], link DE COMPRAS [Footer], link ESPERANDO [Footer], link EN CASA [Footer], link MI CUENTA [Footer]
		if(selenium.isElementPresent("xpath=html/body/div/div[4]/div/div[2]/div[4]/a/cufon/canvas")){
			selenium.click("xpath=html/body/div/div[4]/div/div[2]/div[4]/a/cufon/canvas");
			Helper.log("Entry is through the link 'AYUDA' in Footer-Top");
		} else if(selenium.isElementPresent("link=De compras")){
			selenium.click("link=De compras");
			Helper.log("Entry is through the link '"+selenium.getText("link=De compras")+"' in Footer-Middle");
		} else if(selenium.isElementPresent("link=Esperando")){
			selenium.click("link=Esperando");
			Helper.log("Entry is through the link '"+selenium.getText("link=Esperando")+"' in Footer-Middle");
		} else if(selenium.isElementPresent("link=En casa")){
			selenium.click("link=En casa");
			Helper.log("Entry is through the link '"+selenium.getText("link=En casa")+"' in Footer-Middle");
		} else if(selenium.isElementPresent("link=Mi cuenta")){
			selenium.click("link=Mi cuenta");
			Helper.log("Entry is through the link '"+selenium.getText("link=Mi cuenta")+"' in Footer-Middle");
		}
		selenium.waitForPageToLoad("15000");
		
		//Se ingresa y verifica los enlaces de la seccion de preguntas frecuentes
		//Enlace: ¿Tienes dudas sobre algún producto o marca? 
		Helper.clickAndVerify(selenium, "xpath=//div[2]/div/div/ul/li/a", selenium.getText("xpath=//div[2]/div/div/ul/li/a"), "xpath=//div[3]/div/div/div/div[2]/div/div[2]/div");
		selenium.click("link=Cerrar");
		selenium.waitForPageToLoad("15000");
		
		//Enlaces: ¿Quieres realizar modificaciones o cancelar tu pedido?, ¿Imprevistos con la entrega?
		//¿Ha surgido algún imprevisto con tu devolución?, ¿Cuándo recibirás tu reembolso?
		int literal=2;
		while(selenium.isElementPresent("xpath=//div[2]/div/div/ul/li["+literal+"]/a")){
			Helper.clickAndVerify(selenium, "xpath=//div[2]/div/div/ul/li["+literal+"]/a", selenium.getText("xpath=//div[2]/div/div/ul/li["+literal+"]/a"), "xpath=//div[3]/div/div/div/div[2]/div/div[2]/div");
			selenium.click("link=Cerrar");
			selenium.waitForPageToLoad("15000");			
			literal++;
		}
		
		//Se ingresa y verifican los enlaces de la seccion preguntas frecuentes:
		//¿Cómo comprar?, ¿Problemas con la web?, Envío, Pago, Productos y marcas
		//Modificaciones/Cancelaciones, Mis pedidos, Entrega
		//Devoluciones y Cambios, Recogida de producto, Reembolsos
		//Registro, Modificar datos, Has olvidado tu contraseña, Suscripciones, Desactivar cuenta
		
		literal=1;
		int columna=1;
		while(selenium.isElementPresent("xpath=.//*[@id='question-category-block']/div["+columna+"]/ul/li[1]/a")){
			
			literal=1;
			while(selenium.isElementPresent("xpath=.//*[@id='question-category-block']/div["+columna+"]/ul/li["+literal+"]/a")){
				
				String texto = selenium.getText("xpath=.//*[@id='question-category-block']/div["+columna+"]/ul/li["+literal+"]/a");
				if(texto.equals("¿Problemas con la web?")){
					texto="Problemas técnicos";
				} else if(texto.equals("Devoluciones y Cambios")){
					texto="Devoluciones";
				} else if(texto.equals("Modificaciones / Cancelaciones")) {
					texto= "Modificaciones / cancelaciones";
				}else if(texto.equals("Has olvidado tu contraseña")){
					texto="¿Has olvidado tu contraseña?";
				}
				Helper.clickAndVerify(selenium, "xpath=.//*[@id='question-category-block']/div["+columna+"]/ul/li["+literal+"]/a", 
						texto,"xpath=.//*[@id='content-block']/div[1]/span[1]");
				selenium.click("link=Cerrar");
				selenium.waitForPageToLoad("15000");
				literal++;
			}			
			columna++;
		}			
	}
}
