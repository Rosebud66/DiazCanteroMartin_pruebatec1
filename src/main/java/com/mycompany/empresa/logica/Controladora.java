package com.mycompany.empresa.logica;

import com.mycompany.empresa.persistencia.ControladoraPersistencia;
import java.util.List;

// MartínDCantero

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    // CREAR empleado
    public void crearEmpleado(Empleado empleado) {
       controlPersis.crearEmpleado(empleado);
    }

    // LISTAR empleados
    public List<Empleado> traerEmpleados() {
      return controlPersis.traerEmpleados();  
    }

    // ELIMINAR empleado
    public void eliminarEmpleado(int idEliminar) {
       controlPersis.eliminarEmpleado(idEliminar); 
    }

    // BUSCAR empleado
    public Empleado buscarEmpleado(int idEditar) {
       return controlPersis.buscarEmpleado(idEditar);
    }

    // EDITAR empleado
    public void editarEmpleado(Empleado empEdit) {
        controlPersis.editarEmpleado(empEdit);
    }

    // BUSCAR empleado por cargo
    public List<Empleado> buscarPorCargo(String cargoBuscar) {
       return controlPersis.buscarPorCargo(cargoBuscar);
    }

   
}
