package com.edgar.tareas.modelo;

import java.time.LocalDate;

public class Tarea {
    private int id;
    private String titulo;
    private String descripcion;
    private boolean completada;
    private LocalDate fechaCreacion;

    // Constructor
    public Tarea(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = false;
        this.fechaCreacion = LocalDate.now();
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public boolean isCompletada() { return completada; }
    public void setCompletada(boolean completada) { this.completada = completada; }

    public LocalDate getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDate fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    @Override
    public String toString() {
        return String.format(
                "[%d] %s - %s (Estado: %s) - Creado: %s",
                id, titulo, descripcion,
                completada ? "✅ Completada" : "⏳ Pendiente",
                fechaCreacion
        );
    }
}