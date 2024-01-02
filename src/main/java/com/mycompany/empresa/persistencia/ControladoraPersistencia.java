package com.mycompany.empresa.persistencia;

import com.mycompany.empresa.logica.Empleado;
import com.mycompany.empresa.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// MartínDCantero

public class ControladoraPersistencia {
    
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();

    // CREAR empleado
    public void crearEmpleado(Empleado empleado) {
        empleadoJpa.create(empleado);
    }

    // LISTAR empleados
    public List<Empleado> traerEmpleados() {
        return empleadoJpa.findEmpleadoEntities();
    }

    // ELIMINAR empleado
    public void eliminarEmpleado(int idEliminar) {
        try {
            empleadoJpa.destroy(idEliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // BUSCAR empleado por ID
    public Empleado buscarEmpleado(int idEditar) {
       return empleadoJpa.findEmpleado(idEditar);
    }

    // EDITAR empleado
    public void editarEmpleado(Empleado empEdit) {
        try {
            empleadoJpa.edit(empEdit);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // BUSCAR empleados por cargo
    public List<Empleado> buscarPorCargo(String cargoBuscar) {
        
        // Lista para almacenar los empleados encontrados
        List<Empleado> empleadosPorCargo = new ArrayList<>();

        try {
            // Obtener todos los empleados
            List<Empleado> todosLosEmpleados = empleadoJpa.findEmpleadoEntities();

            // Iteramos hasta encontrar al empleado con el cargo que buscamos
            for (Empleado emp : todosLosEmpleados) {
                // Verificamos que el cargo que buscamos exista (sin hacer distinción entre mayúsculas y minúsculas)
                if (emp.getCargo().equalsIgnoreCase(cargoBuscar)) {
                    // Agregamos el empleado a la lista de empleadosPorCargo
                    empleadosPorCargo.add(emp);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Devolvemos la lista de empleados con el cargo que buscamos
        return empleadosPorCargo;
    }
    
}
