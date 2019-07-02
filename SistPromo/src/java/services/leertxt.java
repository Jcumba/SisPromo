package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class leertxt {

    public static void main(String[] args) throws IOException {
        String contenido;
        FileReader archivo = new FileReader("C:/Users/zecarlos/Documents/ARCHIVOS TEXTOS/txt de Evaluaciones.txt");
        BufferedReader buffer = new BufferedReader(archivo);
        while ((contenido = buffer.readLine()) != null) {
            System.out.println(contenido);
//            JOptionPane.showMessageDialog(null, contenido);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(contenido, null));
        }
        buffer.close();
    }
}
