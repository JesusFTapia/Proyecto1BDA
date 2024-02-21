/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancodominio.pojo;

/**
 *
 * @author USER
 */
public class Direccion {
    private int idDueno;
    private String codigoPostal;
    private String calle;
    private String colonia;
    private String numeroCasa;

    public Direccion(int idDueno, String codigoPostal, String calle, String colonia, String numeroCasa) {
        this.idDueno = idDueno;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroCasa = numeroCasa;
    }

    public void setIdDueno(int idDueno) {
        this.idDueno = idDueno;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public int getIdDueno() {
        return idDueno;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public String getColonia() {
        return colonia;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }
    
    
    
}
