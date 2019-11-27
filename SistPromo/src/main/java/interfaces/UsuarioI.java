/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.UsuarioM;
/**
 *
 * @author PC31
 */
public interface UsuarioI {
    
    void guardarUsuario(UsuarioM usuario) throws Exception;

    void modificarUsuario(UsuarioM usuario) throws Exception;

    void eliminarUsuario(UsuarioM usuario) throws Exception;

    List<UsuarioM> listarUsuario() throws Exception;
}
