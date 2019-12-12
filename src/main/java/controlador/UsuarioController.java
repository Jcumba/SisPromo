
package controlador;

import dao.ImplUsuarioD;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import modelo.UsuarioM;
import servicio.SessionUtils;

@Data
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

  
    private UsuarioM selectedUsuario;
    private List<UsuarioM> lstUsuario;

    private UsuarioM usuario = new UsuarioM();
    private int Contador = 0;

    private String User;
    private String Pass;

    public void startSession() throws Exception {
        ImplUsuarioD dao;
        try {
            dao = new ImplUsuarioD();
            usuario = dao.startSession(User, Pass);
            if (usuario != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", usuario);
                switch (usuario.getNIVEL()) {
                    case "1":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/Vistas/Template/Template.xhtml");
                        break;
                    case "2":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/Vistas/Template/Template.xhtml");
                        break;
                    default:
                        break;
                }
            } else {
                Contador = Contador + 1;
                setPass(null);
                usuario = new UsuarioM();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contraseña/Usuario Incorrecto"));
                if (Contador == 3) {
//                    RequestContext.getCurrentInstance().execute("PF('BLOQUEO').show()");

                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void finishSession() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear(); //Cierra la Session
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SistPromo/"); // Mandamos al Login
    }

    public void securityLogin() throws IOException {
        UsuarioM us = SessionUtils.obtenerObjetoSesion();
        if (us != null) {
            switch (us.getNIVEL()) {
                case "1":
                    FacesContext.getCurrentInstance().getExternalContext().redirect("faces/Vistas/Template/Template.xhtml");
                    break;
                case "2":
                    FacesContext.getCurrentInstance().getExternalContext().redirect("faces/Vistas/Template/Template.xhtml");
                    break;
            }
        }
    }

    public void securitySession() throws IOException {
        if (SessionUtils.obtenerObjetoSesion() == null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SistPromo");
        }
    }

    public void obtenerDatos() {
        System.out.println(SessionUtils.ObtenerCodigoSesion());
        System.out.println(SessionUtils.ObtenerNombreSesion());
    }

    public void redireccionPrincipal() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SistPromo/faces/Vistas/alumno.xhtml");
        } catch (IOException ex) {
            System.err.println("Error en Redireccion Principal -> " + ex.getMessage());
        }
    }

    @PostConstruct
    public void init() {
        try {
            listarUsuario();
        } catch (Exception e) {
        }
    }

    private void listarUsuario() throws Exception {
        ImplUsuarioD dao;
        try {
            dao = new ImplUsuarioD();
            lstUsuario = dao.listarUsuario();
        } catch (Exception e) {
            throw e;
        }
    }

    public void guardarUsuario() throws Exception {
        ImplUsuarioD dao;
        try {
            dao = new ImplUsuarioD();
            dao.guardarUsuario(usuario);
            listarUsuario();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO", "Correctamente"));
            limpiarUsuario();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "No se pudo agregar"));
//            throw e;
        }
    }

    private void limpiarUsuario() {
        usuario = new UsuarioM();
    }
}
