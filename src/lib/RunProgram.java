package lib;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.io.OutputStream;
/**
 *
 * @author Felipe Rodriguez
 */
public class RunProgram {

    /**
     * @param args the command line arguments
     */
    public static void Exec(String filename) {
        // TODO code application logic here
        String line;

        //OutputStream stdin = null;
        InputStream stderr = null;
        InputStream stdout = null;
        Process process=null;

        try {
          //process = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tree.com /A");
          File file=new File(filename);

          // Este es el comando que funciona bien en local y el que se deberia usar normalmente
          //process = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + file.getAbsolutePath());

          //segunda alternativa de ejecucion como en el caso anterior
          //process = Runtime.getRuntime().exec("cmd /c E:\\testABIL\\psexec.exe -i \\\\127.0.0.1 c:\\windows\\system32\\notepad.exe");

          //alternativa llamando a psexec que finalmente usamos aqui, ya que desde Tb.java
          //llamamos a exec (aqui) pasandole los parametros para que finalmenet arme una ejecucion como la
          //siguiente
          //process = Runtime.getRuntime().exec("E:\\testABIL\\psexec.exe -i \\\\127.0.0.1 E:\\testABIL\\upload.bat E:\\testABIL\\chris_46knots.wmv");
          
          process = Runtime.getRuntime().exec(filename);
          
          System.out.println(file.getAbsolutePath());
          
          //stdin = process.getOutputStream ();
          stderr = process.getErrorStream ();
          stdout = process.getInputStream ();

          //line = "param" + "\n";
          //stdin.write(line.getBytes());
          //stdin.flush();

          //stdin.close();

          // clean up if any output in stdout
          BufferedReader brCleanUp =
            new BufferedReader (new InputStreamReader (stdout));

          while ((line = brCleanUp.readLine ()) != null) {
            System.out.println ("[Stdout] " + line);
          }
        brCleanUp.close();

        // clean up if any output in stderr
        brCleanUp =
          new BufferedReader (new InputStreamReader (stderr));

        while ((line = brCleanUp.readLine ()) != null) {
          System.out.println ("[Stderr] " + line);
        }

        brCleanUp.close();
      }
      catch (IOException ex) {}
  }

}
