/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class ArchivoJson {

   private static String readUrl(String urlString) throws Exception {
    BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
 
            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
  }
 
  public static void main(String[] args) throws Exception {
    try {
        JSONObject json = new JSONObject(readUrl("../Json/document.json"));
        String name = (String) json.get("name");
        System.out.println("Name: " + name);
    } catch (JSONException e) {
        e.printStackTrace();
    }
  }

}
