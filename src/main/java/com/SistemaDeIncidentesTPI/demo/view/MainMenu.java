package com.SistemaDeIncidentesTPI.demo.view;

import com.SistemaDeIncidentesTPI.demo.controllers.*;

import java.util.Scanner;
/*
public class MainMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ServiceController servicio = new ServiceController();
        //ProblemTypeController problema = new ProblemaControlador();
        TechnicianController tecnico = new TechnicianController();
        //CustomerController cliente = new ClienteControlador();
        //SpecialityController especialidad = new EspecialidadControlador();
        //IncidentController incidente = new IncidenteControlador();


        int opcion;


        do {
            System.out.println("------------------------------");
            System.out.println("6.Crear Técnico");
            System.out.println("7.Ver Técnico");
            System.out.println("8.Ver todos los Técnicos");
            System.out.println("9.Actualizar Técnico");
            System.out.println("10.Eliminar Técnico");
            System.out.println("------------------------------");
            System.out.println("16.Crear Cliente");
            System.out.println("17.Ver Cliente");
            System.out.println("18.Ver todos los Clientes");
            System.out.println("19.Actualizar Client");
            System.out.println("20.Eliminar Client");
            System.out.println("------------------------------");
            System.out.println("21.Crear Especialidad");
            System.out.println("22.Ver Especialidad");
            System.out.println("23.Ver todas las Especialidades");
            System.out.println("24.Actualizar Especialidad");
            System.out.println("25.Eliminar Especialidad");
            System.out.println("------------------------------");
            System.out.println("26.Crear Problema");
            System.out.println("27.Ver Problema");
            System.out.println("28.Ver todos los Problemas");
            System.out.println("29.Actualizar Problema");
            System.out.println("30.Eliminar Problema");
            System.out.println("------------------------------");
            System.out.println("31.Crear Servicio");
            System.out.println("32.Ver Servicio");
            System.out.println("33.Ver todos los Servicios");
            System.out.println("34.Actualizar Servicio");
            System.out.println("35.Eliminar Servicio");
            System.out.println("------------------------------");
            System.out.println("36.Crear Incidente");
            System.out.println("37.Ver Incidente");
            System.out.println("38.Ver todos los Incidentes");
            System.out.println("39.Actualizar Incidente");
            System.out.println("40.Eliminar Incidente");
            System.out.println("------------------------------");
            System.out.println("41. Salir");
            System.out.println("------------------------------");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
/*
            switch (opcion) {
                case 6:
                    tecnico.CrearTecnico();
                    break;
                case 7:
                    tecnico.VerTécnico(2);
                    break;
                case 8:
                    tecnico.MostrarTodosLosTecnicos();
                    break;
                case 9:
                    tecnico.ActualizarTecnico(1, "Mauricio", "Martinez",  "elmauri@hotmail.com", "+5454643424");
                    break;
                case 10:
                    tecnico.EliminarTecnico(2);
                    break;
                /*case 16:
                    cliente.CrearCliente("Bunge", "5-657412-9", "bunge@outlook.com", "+5466686978");
                    break;
                case 17:
                    cliente.VerCliente(1);
                    break;
                case 18:
                    cliente.MostrarTodosLosClientes();
                    break;
                case 19:
                    cliente.ActualizarServicio(1, "Intel", "6-52035214-7", "intel@gmail.com", "+545555555");
                    break;
                case 20:
                    cliente.EliminarCliente(2);
                    break;
                case 21:
                    especialidad.CrearEspecialidad("Microservicios", 2);
                    break;
                case 22:
                    especialidad.VerEspecialidad(1);
                    break;
                case 23:
                    especialidad.MostrarEspecialidades();
                    break;
                case 24:
                    especialidad.ActualizarEspecialidad(1, "Reparación de PC",1);
                    break;
                case 25:
                    especialidad.EliminarEspecialidad(2);
                    break;
                case 26:
                    problema.CrearProblema("No anda el mause", "20min");
                    break;
                case 27:
                    problema.VerProblema(1);
                    break;
                case 28:
                    problema.MostrarProblemas();
                    break;
                case 29:
                    problema.ActualizarProblema(2, "No prende el monitor", "10min");
                    break;
                case 30:
                    problema.EliminarProblema(1);
                    break;
                case 31:
                    servicio.CrearServicio("Ubuntu");
                    break;
                case 32:
                    servicio.VerServicio(3);
                    break;
                case 33:
                    servicio.MostrarServicios();
                    break;
                case 34:
                    servicio.ActualizarServicio(1, "Windows 11");
                    break;
                case 35:
                    servicio.EliminarServicio(2);
                    break;
                case 36:
                    incidente.CrearIncidente(LocalDateTime.of(2020, 10, 15, 10, 53, 02), LocalDateTime.now(), 1, 2, 3, 3, "Sin observaciones", EstadoIncidente.Finalizado);
                    break;
                case 37:
                    incidente.VerIncidente(1);
                    break;
                case 38:
                    incidente.MostrarTodosLosIncidentes();
                    break;
                case 39:
                    incidente.ActualizarIncidente(1,LocalDateTime.of(2022, 10, 11, 10, 53, 22), LocalDateTime.now(), 1, 1, 1, 3, "Sin observaciones", EstadoIncidente.EnCurso);
                    break;
                case 40:
                    incidente.EliminarIncidente(2);
                    break;
                case 41:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 41);

        scanner.close();
    }


    }
}

*/

