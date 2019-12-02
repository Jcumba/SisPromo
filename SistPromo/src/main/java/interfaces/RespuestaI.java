/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.RespuestaM;

/**
 *
 * @author PC31
 */
public interface RespuestaI {

    void agregarRespuesta(RespuestaM respuesta) throws Exception;

    void modificarRespuesta(RespuestaM respuesta) throws Exception;

    void eliminarRespuesta(RespuestaM respuesta) throws Exception;

    List<RespuestaM> listarRespuesta() throws Exception;

}
