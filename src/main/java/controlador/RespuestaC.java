/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.RespuestaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import modelo.RespuestaM;

/**
 *
 * @author PC31
 */
@Named(value = "respuestaC")
@SessionScoped
public class RespuestaC implements Serializable {

    private RespuestaM respuesta = new RespuestaM();
    private RespuestaM selectedRespuesta;
    private List<RespuestaM> lstRespuesta;

    @PostConstruct
    public void init() {
        try {
            listarRespuesta();
        } catch (Exception e) {
        }

    }

    private void listarRespuesta() throws Exception {
        RespuestaImpl dao;
        try {
            dao = new RespuestaImpl();
            lstRespuesta = dao.listarRespuesta();
        } catch (Exception e) {
            throw e;
        }
    }

    public RespuestaM getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaM respuesta) {
        this.respuesta = respuesta;
    }

    public RespuestaM getSelectedRespuesta() {
        return selectedRespuesta;
    }

    public void setSelectedRespuesta(RespuestaM selectedRespuesta) {
        this.selectedRespuesta = selectedRespuesta;
    }

    public List<RespuestaM> getLstRespuesta() {
        return lstRespuesta;
    }

    public void setLstRespuesta(List<RespuestaM> lstRespuesta) {
        this.lstRespuesta = lstRespuesta;
    }

}
