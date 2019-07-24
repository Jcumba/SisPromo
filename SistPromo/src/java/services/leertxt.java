package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class leertxt {

    public static void main(String[] args) throws IOException {
        String contenido;
        FileReader archivo = new FileReader("C:/Users/zecarlos/Documents/ARCHIVOS TEXTOS/txt de Evaluaciones.txt");
        BufferedReader buffer = new BufferedReader(archivo);

        while ((contenido = buffer.readLine()) != null) {
            StringTokenizer tokens = new StringTokenizer(contenido, ";");
            while (tokens.hasMoreTokens()) {
//               System.out.println(tokens.nextToken());
//                String a = tokens.nextToken();
//                String b = tokens.nextToken();
//                String c = tokens.nextToken();
//                String d = tokens.nextToken();
//                System.out.println(a + "-" + b + "-" + c + "-" + d);
            }

        }
        buffer.close(); 
    }
}
