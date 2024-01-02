package com.mycompany.empresa;

import com.mycompany.empresa.logica.Controladora;
import com.mycompany.empresa.logica.Empleado;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// MartínDCantero
// Clase principal con el método Main
public class Empresa {

    public static void main(String[] args) {
        Controladora control = new Controladora();
        Scanner scanner = new Scanner(System.in); // Scanner para leer entrada usuario
        boolean continuar = true; // Booleano para controlar salida del menú

        // Menú
        while (continuar) {
            System.out.println("----- MENÚ -----");
            System.out.println("1. Listar empleados");
            System.out.println("2. Crear un empleado");
            System.out.println("3. Editar un empleado");
            System.out.println("4. Borrar un empleado");
            System.out.println("5. Buscar empleados por cargo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();// Opción del usuario
            scanner.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        // MOSTRAR todos los registros de empleados
                        List<Empleado> listaEmpleados = control.traerEmpleados();
                        System.out.println("--------------------------------------------------------------------------------------------");
                        System.out.println("| ID  | Nombre          | Apellido        | Cargo                |    Salario |Fecha Inicio|");
                        System.out.println("--------------------------------------------------------------------------------------------");
                        for (Empleado emp : listaEmpleados) {
                            System.out.println(emp.toString());
                        }
                        break;
                    case 2:
                        // CREACIÓN de un nuevo empleado
                        int id = -1;
                        boolean idValido = false;

                        while (!idValido) {
                            System.out.println("Id del empleado:");
                            String entradaId = scanner.nextLine();

                            if (esNumeroEntero(entradaId)) {
                                id = Integer.parseInt(entradaId);

                                // Verificar si el ID ya está en uso
                                Empleado empleadoExistente = control.buscarEmpleado(id);
                                if (empleadoExistente == null) {
                                    idValido = true;
                                } else {
                                    System.out.println("Ya existe un empleado con este ID. Prueba con otro:");
                                }
                            } else {
                                System.out.println("El ID debe ser un número entero:");
                            }
                        }

                        // NOMBRE
                        System.out.println("Nombre del empleado:");
                        String nombre;
                        while (true) {
                            nombre = scanner.nextLine();
                            if (esCadenaTexto(nombre)) {
                                break;
                            } else {
                                System.out.println("Ingrese un nombre válido:");
                            }
                        }

                        // APELLIDO
                        System.out.println("Apellido del empleado:");
                        String apellido;
                        while (true) {
                            apellido = scanner.nextLine();
                            if (esCadenaTexto(apellido)) {
                                break;
                            } else {
                                System.out.println("Ingrese un apellido válido:");
                            }
                        }

                        // CARGO
                        System.out.println("Cargo del empleado:");
                        String cargo;
                        while (true) {
                            cargo = scanner.nextLine();
                            if (esCadenaTexto(cargo)) {
                                break;
                            } else {
                                System.out.println("Ingrese un cargo válido:");
                            }
                        }

                        // SALARIO
                        System.out.println("Salario del empleado:");
                        double salario;
                        while (true) {
                            try {
                                salario = Double.parseDouble(scanner.nextLine());
                                if (!esSalarioValido(salario)) {
                                    throw new InputMismatchException("Ingrese un salario válido (mayor que 0).");
                                }
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println(e.getMessage());
                            } catch (NumberFormatException e) {
                                System.out.println("Ingrese un valor numérico para el salario.");
                            }
                        }

                        // Fecha del día de la creación del registro
                        LocalDate fechaContratacion = LocalDate.now();

                        // Creación del nuevo empleado
                        Empleado nuevoEmpleado = new Empleado(id, nombre, apellido, cargo, salario, fechaContratacion);
                        control.crearEmpleado(nuevoEmpleado);
                        System.out.println("Empleado creado con éxito");
                        break;

                    case 3:
                        // EDITAR un empleado
                        System.out.println("ID del empleado a editar:");
                        int idEditar = scanner.nextInt();
                        scanner.nextLine();

                        Empleado empEdit = control.buscarEmpleado(idEditar);
                        if (empEdit != null) {
                            // NUEVO NOMBRE
                            System.out.println("Nuevo nombre del empleado:");
                            String nuevoNombre;
                            while (true) {
                                nuevoNombre = scanner.nextLine();
                                if (esCadenaTexto(nuevoNombre)) {
                                    break;
                                } else {
                                    System.out.println("Ingrese un nombre válido:");
                                }
                            }

                            // NUEVO APELLIDO
                            System.out.println("Nuevo apellido del empleado:");
                            String nuevoApellido;
                            while (true) {
                                nuevoApellido = scanner.nextLine();
                                if (esCadenaTexto(nuevoApellido)) {
                                    break;
                                } else {
                                    System.out.println("Ingrese un apellido válido:");
                                }
                            }

                            // NUEVO CARGO
                            System.out.println("Nuevo cargo del empleado:");
                            String nuevoCargo;
                            while (true) {
                                nuevoCargo = scanner.nextLine();
                                if (esCadenaTexto(nuevoCargo)) {
                                    break;
                                } else {
                                    System.out.println("Ingrese un cargo válido:");
                                }
                            }

                            // NUEVO SALARIO
                            double nuevoSalario;
                            while (true) {
                                try {
                                    System.out.println("Nuevo salario del empleado:");
                                    nuevoSalario = Double.parseDouble(scanner.nextLine());
                                    if (!esSalarioValido(nuevoSalario)) {
                                        throw new InputMismatchException("Ingrese un salario válido (mayor que 0).");
                                    }
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println(e.getMessage());
                                } catch (NumberFormatException e) {
                                    System.out.println("Ingrese un valor numérico para el salario.");
                                }
                            }

                            // Actualización de los campos del empleado
                            empEdit.setNombre(nuevoNombre);
                            empEdit.setApellido(nuevoApellido);
                            empEdit.setCargo(nuevoCargo);
                            empEdit.setSalario(nuevoSalario);

                            try {
                                control.editarEmpleado(empEdit);
                                System.out.println("Empleado editado con éxito");
                            } catch (Exception e) {
                                System.out.println("Error al editar el empleado: " + e.getMessage());
                            }
                        } else {
                            System.out.println("No se ha podido encontrar al empleado");
                        }
                        break;
                    case 4:
                        // BORRAR un empleado
                        int idEliminar = -1;
                        boolean idValidoEliminar = false;

                        while (!idValidoEliminar) {
                            try {
                                System.out.println("ID del empleado a borrar:");
                                String entradaIdEliminar = scanner.nextLine();

                                if (esNumeroEntero(entradaIdEliminar)) {
                                    idEliminar = Integer.parseInt(entradaIdEliminar);

                                    Empleado empleadoExistente = control.buscarEmpleado(idEliminar);
                                    if (empleadoExistente != null) {
                                        control.eliminarEmpleado(idEliminar);
                                        System.out.println("Empleado con ID " + empleadoExistente.getId() + " eliminado con éxito");
                                        idValidoEliminar = true;
                                    } else {
                                        System.out.println("No existe ningún empleado con ese ID");
                                    }
                                } else {
                                    System.out.println("El ID debe ser un número entero:");
                                }
                            } catch (Exception e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                        break;
                    case 5:
                        // BUSCAR empleados por cargo
                        String cargoBuscar;
                        while (true) {
                            System.out.println("Cargo a buscar:");
                            cargoBuscar = scanner.nextLine();
                            if (esCadenaTexto(cargoBuscar)) {
                                break;
                            } else {
                                System.out.println("Ingrese un cargo válido:");
                            }
                        }

                        List<Empleado> empleadosPorCargo = control.buscarPorCargo(cargoBuscar);
                        if (empleadosPorCargo.isEmpty()) {
                            System.out.println("No se encontraron empleados con ese cargo.");
                        } else {
                            System.out.println("Empleados con el cargo '" + cargoBuscar + "':");
                            for (Empleado emp : empleadosPorCargo) {
                                System.out.println(emp.toString());
                            }
                        }
                        break;
                    case 6:
                        System.out.println("Cerrando el programa.");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Elija una opción del 1 al 6.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    public static boolean esNumeroEntero(String entrada) {
        try {
            Integer.parseInt(entrada);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean esCadenaTexto(String entrada) {
        return entrada.matches("[a-zA-Z]+");
    }

    public static boolean esSalarioValido(double salario) {
        return salario > 0;
    }

}
