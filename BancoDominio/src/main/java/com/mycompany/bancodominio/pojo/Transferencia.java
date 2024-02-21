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
public class Transferencia {
    private int idTransferencia;
    private int idCuentaEnvia;
    private int idCuentaRecibe;
    private int numCuentaEnvia;
    private int numCuentaRecibe;
    private float cantidad;
    private String fecha;

    public Transferencia() {
    }

    public Transferencia(int idCuentaEnvia, int idCuentaRecibe, int numCuentaEnvia, int numCuentaRecibe, float cantidad) {
        this.idCuentaEnvia = idCuentaEnvia;
        this.idCuentaRecibe = idCuentaRecibe;
        this.numCuentaEnvia = numCuentaEnvia;
        this.numCuentaRecibe = numCuentaRecibe;
        this.cantidad = cantidad;
    }

    public Transferencia(int idCuentaEnvia, int idCuentaRecibe, int numCuentaEnvia, int numCuentaRecibe, float cantidad, String fecha) {
        this.idCuentaEnvia = idCuentaEnvia;
        this.idCuentaRecibe = idCuentaRecibe;
        this.numCuentaEnvia = numCuentaEnvia;
        this.numCuentaRecibe = numCuentaRecibe;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Transferencia(int idTransferencia, int idCuentaEnvia, int idCuentaRecibe, int numCuentaEnvia, int numCuentaRecibe, float cantidad, String fecha) {
        this.idTransferencia = idTransferencia;
        this.idCuentaEnvia = idCuentaEnvia;
        this.idCuentaRecibe = idCuentaRecibe;
        this.numCuentaEnvia = numCuentaEnvia;
        this.numCuentaRecibe = numCuentaRecibe;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public int getIdCuentaEnvia() {
        return idCuentaEnvia;
    }

    public void setIdCuentaEnvia(int idCuentaEnvia) {
        this.idCuentaEnvia = idCuentaEnvia;
    }

    public int getIdCuentaRecibe() {
        return idCuentaRecibe;
    }

    public void setIdCuentaRecibe(int idCuentaRecibe) {
        this.idCuentaRecibe = idCuentaRecibe;
    }

    public int getNumCuentaEnvia() {
        return numCuentaEnvia;
    }

    public void setNumCuentaEnvia(int numCuentaEnvia) {
        this.numCuentaEnvia = numCuentaEnvia;
    }

    public int getNumCuentaRecibe() {
        return numCuentaRecibe;
    }

    public void setNumCuentaRecibe(int numCuentaRecibe) {
        this.numCuentaRecibe = numCuentaRecibe;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "idTransferencia=" + idTransferencia + ", idCuentaEnvia=" + idCuentaEnvia + ", idCuentaRecibe=" + idCuentaRecibe + ", numCuentaEnvia=" + numCuentaEnvia + ", numCuentaRecibe=" + numCuentaRecibe + ", cantidad=" + cantidad + ", fecha=" + fecha + '}';
    }

    
    
}
