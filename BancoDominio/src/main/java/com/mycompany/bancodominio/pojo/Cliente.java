/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancodominio.pojo;

import java.util.Objects;

/**
 *
 * @author USER
 */
public class Cliente {
    private int idcliente;
    private String nombre;
    private String nombreUsuario;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String contrasena;
    private String fechaNacimiento;
    

    public Cliente() {
    }

    public Cliente(int idcliente) {
        this.idcliente = idcliente;
    }
    

    public Cliente(String nombre, String nombreUsuario, String apellidoPaterno, String apellidoMaterno, String contrasena, String fechaNacimiento) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasena = contrasena;
    }

    public Cliente(int idcliente,String nombre, String nombreUsuario, String apellidoPaterno, String apellidoMaterno, String contrasena) {
        this.idcliente=idcliente;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasena = contrasena;
    }
    

    public Cliente(int idcliente, String nombre, String nombreUsuario, String apellidoPaterno, String apellidoMaterno, String contrasena, String fechaNacimiento) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasena = contrasena;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    

    
    
    
}
