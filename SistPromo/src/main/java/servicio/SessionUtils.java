/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import javax.faces.context.FacesContext;
import modelo.UsuarioM;
/**
 *
 * @author PC31
 */
public class SessionUtils {
    
       public static UsuarioM obtenerObjetoSesion() {
        return (UsuarioM) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
    }

    public static String ObtenerNombreSesion() {
        UsuarioM us = (UsuarioM) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        if (us != null) {
            return us.getNOMPER();
        } else {
            return null;
        }
    }

    public static String ObtenerCodigoSesion() {
        UsuarioM us = (UsuarioM) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        if (us != null) {
            return us.getCODUS();
        } else {
            return null;
        }
    }
}
