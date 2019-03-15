
package Interfaces;


import java.util.List;
import modelo.AlumnoM;

public interface AlumnoI {
   
    
    void guardarAlumno(AlumnoM alumno) throws Exception;
    void cantidadAlumnos(AlumnoM alumno) throws Exception;
   // void modificarAlumno(AlumnoM alumno) throws Exception;
   // void eliminarAlumno(AlumnoM alumno) throws Exception;
 List<AlumnoM> listarAlumno() throws Exception;
 List<AlumnoM> topColegios() throws Exception;
 List<AlumnoM> CantAlumXCar() throws Exception;

}
