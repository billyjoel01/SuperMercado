package bjo.supermercado.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import org.apache.commons.io.IOUtils;

public class Utils {
    
    public static final String ARCHIVO_PRODUCTOS = "productos.json";
    public static final String ARCHIVO_FACTURAS = "facturas.json";
    
    public static Utils myUtils = null;
    
    private Utils(){}
    
    public static Utils getInstance(){
        if(myUtils == null){
            myUtils = new Utils();
        }
        return myUtils;
    }

    /**
     * Lee un archivo y devuelve el contenido como un String
     * @param fileName
     * @return 
     */
    public String cargarArchivo(String fileName){
        String jsonContent;
        // Cargar el archivo JSON como un InputStream utilizando el ClassLoader
        try (InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new IOException("No se pudo encontrar el archivo " + fileName);
            }
            
            // Leer el contenido del archivo como una cadena JSON utilizando Apache Commons IOUtils
            jsonContent = IOUtils.toString(inputStream, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace(System.out);
            jsonContent = null;
        }
        return jsonContent;
    }
    
    /**
     * Actualiza el contenido de un archivo
     * @param content 
     */
    public void actualizarArchivo(String fileName, String content){
        try{
            // Escribir el contenido actualizado de vuelta al archivo
            OutputStream outputStream = new FileOutputStream("src/main/resources/" + fileName);
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                writer.write(content);
            }
        }catch(IOException ex){
            ex.printStackTrace(System.out);
        }
    }
}
