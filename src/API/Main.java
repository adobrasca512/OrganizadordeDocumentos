package API;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import Controladores.ControladorVistas;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		try {
			if (Clasificador.activadorDescargas()) {

				try {

					ControladorVistas.primaryStage = primaryStage;
					ControladorVistas.resourcePath = this.getClass().getProtectionDomain().getCodeSource().getLocation()
							.toString();
					ControladorVistas.mostrarIncio();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void ejecutarCMD(String cmd){
	    Process p;
	    try {
	      p = Runtime.getRuntime().exec(cmd);
	      p.waitFor();
	      BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
	      String line ;
	      while ((line = reader.readLine())!= null) {
	    	  System.out.println("gat");
	        System.out.println("gay"+line);
	      }
	      reader.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}
	public static void main(String[] args) {
	
		
		
	//ejecutarCMD(cmd2);
	launch(args);

	}

}