package Controladores;

import java.net.URL;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class ControladorVistas {

	public static Stage primaryStage;
	public static String resourcePath;

	private static Object mostrarVentana(String fxmlFile, Object controlador) {
		try {
			
			primaryStage.close();
			URL url = new URL(resourcePath + "Vistas/" + fxmlFile);
			FXMLLoader loader = new FXMLLoader(url);

			loader.setController(controlador);
			Parent root = loader.load();

			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return controlador;
	}

	public static Object mostrarIncio() {
		return mostrarVentana("VistaMadre.fxml", new AlertaMadre());
	}
}
