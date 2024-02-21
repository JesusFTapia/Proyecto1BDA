/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banconegocio.control;

import com.mycompany.bancodominio.dto.ClienteDTO;
import com.mycompany.bancodominio.dto.TransferenciaDTO;
import com.mycompany.bancodominio.pojo.Transferencia;
import com.mycompany.banconegocio.excepciones.ControlException;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IControl {
    public int comprobarSesion(ClienteDTO cliente)throws ControlException;
    public void transferir(TransferenciaDTO transferencia)throws ControlException;
    public int numCuenta(int id)throws ControlException;
    public int idCuenta(int id)throws ControlException;
    public int idCliente(int id)throws ControlException;
    public List<Transferencia> consultarTransferenciasCliente(int id) throws ControlException;
   
}
