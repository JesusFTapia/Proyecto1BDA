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
public class DireccionDTO {
    private String codigoPostal;
    private String calle;
    private String colonia;
    private String numeroCasa;

    public DireccionDTO() {
    }

    public DireccionDTO(String codigoPostal, String calle, String colonia, String numeroCasa) {
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroCasa = numeroCasa;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }
    
    
}
