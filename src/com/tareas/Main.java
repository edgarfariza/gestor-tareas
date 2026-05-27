package com.edgar.tareas;

import com.edgar.tareas.dao.ConexionBD;
import com.edgar.tareas.vista.MenuConsola;

public class Main {
    public static void main(String[] args) {
        // Crear tabla si no existe
        ConexionBD.crearTabla();

        // Iniciar aplicación
        MenuConsola menu = new MenuConsola();
        menu.mostrarMenu();
    }
}