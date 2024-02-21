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
public class Cuenta {
    private int idcuenta;
    private int numeroCuenta;
    private int idcliente;
    private String fechaApertura;
    private float saldo;
    private String estado;

    public Cuenta() {
        
    }

    public Cuenta(int numeroCuenta, int idcliente, float saldo) {
        this.numeroCuenta = numeroCuenta;
        this.idcliente = idcliente;
        this.saldo = saldo;
    }
    

    public Cuenta(int numeroCuenta, int idcliente, String fechaApertura, float saldo, String estado) {
        this.numeroCuenta = numeroCuenta;
        this.idcliente = idcliente;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.estado = estado;
    }

    public Cuenta(int idcuenta, int numeroCuenta, int idcliente, String fechaApertura, float saldo, String estado) {
        this.idcuenta = idcuenta;
        this.numeroCuenta = numeroCuenta;
        this.idcliente = idcliente;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.estado = estado;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public float getSaldo() {
        return saldo;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return ""+ numeroCuenta + "";
    }

    
    
    
}
