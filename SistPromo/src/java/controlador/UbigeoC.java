/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ImplUbigeoD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import modelo.UbigeoM;

/**
 *
 * @author Usuario Alumno
 */
@Named(value = "ubigeoC")
@SessionScoped
public class UbigeoC implements Serializable {

    UbigeoM ubigeo = new UbigeoM();
    private UbigeoM selectedUbigeo;
    private List<UbigeoM> lstUbigeo;
    
        @PostConstruct
    public void init() {

        try {
            listarUbigeo();
        } catch (Exception e) {
        }

    }

    private void listarUbigeo() throws Exception {
        ImplUbigeoD dao;
        try {
            dao = new ImplUbigeoD();
            lstUbigeo = dao.listarUbigeo();
        } catch (Exception e) {
            throw e;
        }
    }

    
    

    public UbigeoM getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(UbigeoM ubigeo) {
        this.ubigeo = ubigeo;
    }

    public UbigeoM getSelectedUbigeo() {
        return selectedUbigeo;
    }

    public void setSelectedUbigeo(UbigeoM selectedUbigeo) {
        this.selectedUbigeo = selectedUbigeo;
    }

    public List<UbigeoM> getLstUbigeo() {
        return lstUbigeo;
    }

    public void setLstUbigeo(List<UbigeoM> lstUbigeo) {
        this.lstUbigeo = lstUbigeo;
    }
    
      public List<String> completeTextUbic (String query) throws SQLException, Exception{
        ImplUbigeoD dao = new ImplUbigeoD();
        return dao.queryAutoCompleteUbic(query);
    }
    
    
}
