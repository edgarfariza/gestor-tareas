package com.edgar.tareas.dao;
import java.sql.*;


public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/gestor_tareas";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Cambia esto

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }

    public static void crearTabla() {
        String sql = """
            CREATE TABLE IF NOT EXISTS tareas (
                id INT AUTO_INCREMENT PRIMARY KEY,
                titulo VARCHAR(100) NOT NULL,
                descripcion TEXT,
                completada BOOLEAN DEFAULT FALSE,
                fecha_creacion DATE NOT NULL
            )
            """;

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla creada/verificada");
        } catch (SQLException e) {
            System.out.println("Error al crear tabla: " + e.getMessage());
        }
    }
}