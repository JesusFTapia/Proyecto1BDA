/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancodominio.dto;

/**
 *
 * @author USER
 */
public class TransferenciaDTO {
    private int idCuentaEnvia;
    private int idCuentaRecibe;
    private float cantidad;

    public TransferenciaDTO() {
    }

    public TransferenciaDTO(int idCuentaEnvia, int idCuentaRecibe, float cantidad) {
        this.idCuentaEnvia = idCuentaEnvia;
        this.idCuentaRecibe = idCuentaRecibe;
        this.cantidad = cantidad;
    }

    public int getIdCuentaEnvia() {
        return idCuentaEnvia;
    }

    public int getIdCuentaRecibe() {
        return idCuentaRecibe;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setIdCuentaEnvia(int idCuentaEnvia) {
        this.idCuentaEnvia = idCuentaEnvia;
    }

    public void setIdCuentaRecibe(int idCuentaRecibe) {
        this.idCuentaRecibe = idCuentaRecibe;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
