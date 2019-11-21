package interfaces;

import java.util.List;
import modelo.AlumnoM;

public interface AlumnoI {
    void agregarAlumnoHistorial(AlumnoM alumno) throws Exception;
    
    void agregarAlumno(AlumnoM alumno) throws Exception;

    void modificarAlumno(AlumnoM alumno) throws Exception;

    void eliminarAlumno(AlumnoM alumno) throws Exception;

    List<AlumnoM> listarAlumno() throws Exception;

    // COMPLEMENTOS
    
//    List<AlumnoM> topColegios() throws Exception;
//
//    List<AlumnoM> CantAlumXCar() throws Exception;
//
//    void cantidadAlumnos(AlumnoM alumno) throws Exception;

}
