/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import modelo.SolucionesM;

/**
 *
 * @author PC
 */
public interface SolucionarioI {
    
     void guardarSolucionario(SolucionesM solucion) throws Exception;

    //Este método sirve para modificar registros de la tabla CLIENTE de la base de datos FactElect
    void modificarSolucionario(SolucionesM solucion) throws Exception;

    //Este método sirve para eliminar un cliente de la tabla CLIENTE de la base de datos FactElect
    void eliminarSolucionario(SolucionesM solucion) throws Exception;

    //Este método sirve para listar los registros de la tabla cliente de la base de datos FactElect
    List<SolucionesM> listarSolucionario() throws Exception;
    List<SolucionesM> listarFecExam() throws Exception;

}
