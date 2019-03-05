/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import modelo.UbigeoM;

/**
 *
 * @author Usuario Alumno
 */
public interface UbigeoI {
    
    
    void guardarUbigeo(UbigeoM ubigeo) throws Exception;

    //Este método sirve para modificar registros de la tabla CLIENTE de la base de datos FactElect
    void modificarUbigeo(UbigeoM ubigeo) throws Exception;

    //Este método sirve para eliminar un cliente de la tabla CLIENTE de la base de datos FactElect
    void eliminarUbigeo(UbigeoM ubigeo) throws Exception;

    //Este método sirve para listar los registros de la tabla cliente de la base de datos FactElect
    List<UbigeoM> listarUbigeo() throws Exception;

    
}
