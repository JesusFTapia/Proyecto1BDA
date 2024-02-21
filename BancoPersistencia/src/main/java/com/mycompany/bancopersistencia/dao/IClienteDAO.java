/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancopersistencia.dao;

import com.mycompany.bancodominio.dto.ClienteDTO;
import com.mycompany.bancodominio.pojo.Cliente;
import com.mycompany.bancopersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IClienteDAO {
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException;
    public int comprobarSesionCliente(ClienteDTO cliente) throws PersistenciaException;
    public Cliente consultarClientePorID(int id) throws PersistenciaException;
    //public List<Cliente> consultarTodos() throws PersistenciaException; 
}
