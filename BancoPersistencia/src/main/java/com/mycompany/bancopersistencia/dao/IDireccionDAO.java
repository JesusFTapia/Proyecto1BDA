/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancopersistencia.dao;


import com.mycompany.bancodominio.dto.DireccionDTO;
import com.mycompany.bancodominio.pojo.Direccion;
import com.mycompany.bancopersistencia.excepciones.PersistenciaException;

/**
 *
 * @author USER
 */
public interface IDireccionDAO {
    public Direccion agregarDireccion(Direccion direccion) throws PersistenciaException;
    public Direccion actualizarDireccion(Direccion direccion) throws PersistenciaException;
    public void eliminarDireccion(int id) throws PersistenciaException;
    public Direccion consultarDireccion(int id) throws PersistenciaException;
}
