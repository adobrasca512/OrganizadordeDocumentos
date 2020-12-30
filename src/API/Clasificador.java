package API;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

public class Clasificador {

	public static String file;

	// Metodo receptor de movimientos
	public static boolean activadorDescargas() throws IOException {

		// Obtenemos el directorio
		Path directoryToWatch = Paths.get("/Users/adilemdobras/Downloads");
		if (directoryToWatch == null) {
			throw new UnsupportedOperationException("Directory not found");
		}

		// Solicitamos el servicio WatchService
		WatchService watchService = directoryToWatch.getFileSystem().newWatchService();

		// Registramos los eventos que queremos monitorear
		directoryToWatch.register(watchService, new WatchEvent.Kind[] { ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY });
		boolean activado = false;

		try {

			// Esperamos que algo suceda con el directorio
			WatchKey key = watchService.take();

			// Algo ocurrio en el directorio para los eventos registrados

			for (WatchEvent event : key.pollEvents()) {
				String eventKind = event.kind().toString();
				file = event.context().toString();

			}

			// Volvemos a escuchar. Lo mantenemos en un loop para escuchar indefinidamente.
			// key.reset();
			// key = watchService.take();
			activado = true;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
			
		
		return activado;
	}

	public static boolean modificacionDescargaBasica(File nuevaCarpeta) {

		File archivoAntiguo = new File("/Users/adilemdobras/Downloads/" + file);
		File archivoNuevo = new File(nuevaCarpeta.getAbsolutePath() +"/"+ file);
		
		
System.out.println(archivoNuevo.getAbsolutePath());
		// Rename file (or directory)
		boolean success = archivoAntiguo.renameTo(archivoNuevo);
		
		
	DriveQuickstart.guardarenDrive(archivoNuevo.getAbsolutePath());
		
		return success;
	}
	//
}
