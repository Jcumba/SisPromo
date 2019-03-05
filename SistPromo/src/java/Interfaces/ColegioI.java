/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import modelo.ColegioM;

/**
 *
 * @author Usuario Alumno
 */
public interface ColegioI {

    void guardarColegio(ColegioM colegio) throws Exception;

    //Este método sirve para modificar registros de la tabla CLIENTE de la base de datos FactElect
    void modificarColegio(ColegioM colegio) throws Exception;

    //Este método sirve para eliminar un cliente de la tabla CLIENTE de la base de datos FactElect
    void eliminarColegio(ColegioM colegio) throws Exception;

    //Este método sirve para listar los registros de la tabla cliente de la base de datos FactElect
    List<ColegioM> listarColegio() throws Exception;

}
