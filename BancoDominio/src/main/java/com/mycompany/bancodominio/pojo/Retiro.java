/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancodominio.pojo;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Retiro {
    private int idRetiro;
    private int idCuenta;
    private float cantidad;
    private String fechaInicio;
    private String fechaExpiracion;
    private String estado;
    private String contraseña;

    public Retiro() {
    }

    public Retiro(int idRetiro, int idCuenta, float cantidad, String contraseña) {
        this.idRetiro = idRetiro;
        this.idCuenta = idCuenta;
        this.cantidad = cantidad;
        this.contraseña = contraseña;
    }

    public Retiro(int idRetiro, int idCuenta, float cantidad, String fechaInicio, String fechaExpiracion) {
        this.idRetiro = idRetiro;
        this.idCuenta = idCuenta;
        this.cantidad = cantidad;
        this.fechaInicio = fechaInicio;
        this.fechaExpiracion = fechaExpiracion;
    }
    public Retiro(int idRetiro, int idCuenta, float cantidad, String fechaInicio, String fechaExpiracion, String contraseña) {
        this.idRetiro = idRetiro;
        this.idCuenta = idCuenta;
        this.cantidad = cantidad;
        this.fechaInicio = fechaInicio;
        this.fechaExpiracion = fechaExpiracion;
        this.contraseña = contraseña;
    }


    public Retiro(int idRetiro, int idCuenta, String estado,float cantidad, String fechaInicio, String fechaExpiracion) {
        this.idRetiro = idRetiro;
        this.idCuenta = idCuenta;
        this.cantidad = cantidad;
        this.fechaInicio = fechaInicio;
        this.fechaExpiracion = fechaExpiracion;
        this.contraseña = contraseña;
        this.estado=estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    public void setIdRetiro(int idRetiro) {
        this.idRetiro = idRetiro;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getIdRetiro() {
        return idRetiro;
    }

    public String getEstado() {
        return estado;
    }

    
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Retiro{" + "idRetiro=" + idRetiro + ", idCuenta=" + idCuenta + ", cantidad=" + cantidad + ", fechaInicio=" + fechaInicio + ", fechaExpiracion=" + fechaExpiracion + ", estado=" + estado + ", contrase\u00f1a=" + contraseña + '}';
    }

    
    
    
    
    

 
}
