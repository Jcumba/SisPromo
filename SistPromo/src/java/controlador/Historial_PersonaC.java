///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controlador;
//
//import dao.Historial_PersonaD;
//import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
//import java.io.Serializable;
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
//import modelo.Historial_PersonaM;
//
///**
// *
// * @author zecarlos
// */
//@Named(value = "historial_PersonaC")
//@SessionScoped
//public class Historial_PersonaC implements Serializable {
//
//    private Historial_PersonaM historialPersona = new Historial_PersonaM();
//    
//    
//    
//    public  void guardarHistorial_Persona () throws Exception{
//        Historial_PersonaD dao;
//        try {
//            dao =  new Historial_PersonaD();
//            dao.guardarHstorial_Persona(historialPersona);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado Correctamente", null));
//        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR EL AGREGAR", null));
//            throw e;
//        }
//    }
//
//    public Historial_PersonaM getHistorialPersona() {
//        return historialPersona;
//    }
//
//    public void setHistorialPersona(Historial_PersonaM historialPersona) {
//        this.historialPersona = historialPersona;
//    }
//    
//}
