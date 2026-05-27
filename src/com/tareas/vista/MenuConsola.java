package com.edgar.tareas.vista;
import com.edgar.tareas.dao.TareaDAO;
import com.edgar.tareas.modelo.Tarea;
import java.util.Scanner;
import java.util.List;

public class MenuConsola {
    private TareaDAO dao;
    private Scanner scanner;

    public MenuConsola() {
        this.dao = new TareaDAO();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("📋 GESTOR DE TAREAS");
            System.out.println("=".repeat(40));
            System.out.println("1. Crear tarea");
            System.out.println("2. Ver todas las tareas");
            System.out.println("3. Marcar como completada");
            System.out.println("4. Actualizar tarea");
            System.out.println("5. Eliminar tarea");
            System.out.println("6. Salir");
            System.out.print("Elige opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    crearTarea();
                    break;
                case 2:
                    verTareas();
                    break;
                case 3:
                    marcarCompletada();
                    break;
                case 4:
                    actualizarTarea();
                    break;
                case 5:
                    eliminarTarea();
                    break;
                case 6:
                    salir = true;
                    System.out.println("👋 ¡Hasta luego!");
                    break;
                default:
                    System.out.println("❌ Opción no válida");
            }
        }
    }

    private void crearTarea() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        Tarea tarea = new Tarea(titulo, descripcion);
        dao.crear(tarea);
    }

    private void verTareas() {
        List<Tarea> tareas = dao.obtenerTodas();
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas");
        } else {
            tareas.forEach(System.out::println);
        }
    }

    private void marcarCompletada() {
        System.out.print("ID de la tarea: ");
        int id = scanner.nextInt();

        Tarea tarea = dao.obtenerPorId(id);
        if (tarea != null) {
            tarea.setCompletada(true);
            dao.actualizar(tarea);
        } else {
            System.out.println("❌ Tarea no encontrada");
        }
    }

    private void actualizarTarea() {
        System.out.print("ID de la tarea: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Tarea tarea = dao.obtenerPorId(id);
        if (tarea != null) {
            System.out.print("Nuevo título: ");
            tarea.setTitulo(scanner.nextLine());
            System.out.print("Nueva descripción: ");
            tarea.setDescripcion(scanner.nextLine());
            dao.actualizar(tarea);
        } else {
            System.out.println("❌ Tarea no encontrada");
        }
    }

    private void eliminarTarea() {
        System.out.print("ID de la tarea: ");
        int id = scanner.nextInt();
        dao.eliminar(id);
    }
}