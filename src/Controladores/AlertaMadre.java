package Controladores;

import java.io.File;

import API.Clasificador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class AlertaMadre {

	@FXML
	private BorderPane bp;

	@FXML
	private AnchorPane ap;

	@FXML
	void btnPersonal(ActionEvent event) {

		Clasificador.modificacionDescargaBasica(new File("/Users/adilemdobras/Documents/Personal"));
		
	}

	@FXML
	void btnUniversidad(ActionEvent event) {
		Clasificador.modificacionDescargaBasica(new File("/Users/adilemdobras/Documents/Universidad"));
	}

}