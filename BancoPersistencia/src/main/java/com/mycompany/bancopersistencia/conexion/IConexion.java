/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author lv1821
 */
public interface IConexion {
    public Connection crearConexion()throws SQLException;
    
}
