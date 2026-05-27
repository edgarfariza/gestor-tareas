package com.edgar.tareas.dao;

import com.edgar.tareas.modelo.Tarea;
import java.sql.*;
import java.util.*;


public class TareaDAO {

    // CREATE
    public void crear(Tarea tarea) {
        String sql = "INSERT INTO tareas (titulo, descripcion, fecha_creacion) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tarea.getTitulo());
            pstmt.setString(2, tarea.getDescripcion());
            pstmt.setDate(3, java.sql.Date.valueOf(tarea.getFechaCreacion()));

            pstmt.executeUpdate();
            System.out.println("Tarea creada exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al crear: " + e.getMessage());
        }
    }

    // READ ALL
    public List<Tarea> obtenerTodas() {
        List<Tarea> tareas = new ArrayList<>();
        String sql = "SELECT * FROM tareas";

        try (Connection conn = ConexionBD.conectar();
     PreparedStatement pstmt = conn.prepareStatement(sql);
     ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Tarea tarea = new Tarea(
                        rs.getString("titulo"),
                        rs.getString("descripcion")
                );
                tarea.setId(rs.getInt("id"));
                tarea.setCompletada(rs.getBoolean("completada"));
                tarea.setFechaCreacion(rs.getDate("fecha_creacion").toLocalDate());
                tareas.add(tarea);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar tareas: " + e.getMessage());
        }
        return tareas;
    }

    // READ BY ID
    public Tarea obtenerPorId(int id) {
        String sql = "SELECT * FROM tareas WHERE id = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Tarea tarea = new Tarea(
                            rs.getString("titulo"),
                            rs.getString("descripcion")
                    );
                    tarea.setId(rs.getInt("id"));
                    tarea.setCompletada(rs.getBoolean("completada"));
                if (rs.getDate("fecha_creacion") != null) {
                    tarea.setFechaCreacion(rs.getDate("fecha_creacion").toLocalDate());
                    return tarea;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener por ID: " + e.getMessage());
        }
        return null;
    }

    // UPDATE
    public void actualizar(Tarea tarea) {
        String sql = "UPDATE tareas SET titulo = ?, descripcion = ?, completada = ? WHERE id = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tarea.getTitulo());
            pstmt.setString(2, tarea.getDescripcion());
            pstmt.setBoolean(3, tarea.isCompletada());
            pstmt.setInt(4, tarea.getId());

            pstmt.executeUpdate();
            System.out.println("Tarea actualizada");
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    // DELETE
    public void eliminar(int id) {
        String sql = "DELETE FROM tareas WHERE id = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Tarea eliminada");
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
