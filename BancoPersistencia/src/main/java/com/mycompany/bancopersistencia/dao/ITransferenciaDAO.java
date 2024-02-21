/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancopersistencia.dao;

import com.mycompany.bancodominio.pojo.Transferencia;
import com.mycompany.bancopersistencia.excepciones.PersistenciaException;

/**
 *
 * @author USER
 */
public interface ITransferenciaDAO {
    public void agregarTransferencia(Transferencia transferencia) throws PersistenciaException;
}
