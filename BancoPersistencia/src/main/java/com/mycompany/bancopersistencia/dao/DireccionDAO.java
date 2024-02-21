/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancopersistencia.dao;

import com.mycompany.bancodominio.dto.DireccionDTO;
import com.mycompany.bancodominio.pojo.Direccion;
import com.mycompany.bancopersistencia.conexion.Conexion;
import com.mycompany.bancopersistencia.conexion.IConexion;
import com.mycompany.bancopersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class DireccionDAO implements IDireccionDAO{
    final String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
    final String usuario = "root";
    final String contra = "sally2023";
    Conexion conexionBD = new Conexion(cadenaConexion, usuario, contra);
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public DireccionDAO() {
    }
    @Override
    public Direccion agregarDireccion(Direccion direccion) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO DIRECCIONES (idcliente,codigoPostal,calle,colonia,numeroCasa) VALUES(?,?,?,?,?)";

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            
            comandoSQL.setString(1, Integer.toString(direccion.getIdDueno()));
            comandoSQL.setString(2, direccion.getCodigoPostal());
            comandoSQL.setString(3, direccion.getCalle());
            comandoSQL.setString(4, direccion.getColonia());
            comandoSQL.setString(5, direccion.getNumeroCasa());
            
            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "se ha agregado (0)", resultado);

            Direccion direccionGuardada = new Direccion(direccion.getIdDueno(), direccion.getCodigoPostal(), direccion.getCalle(), direccion.getColonia(), direccion.getNumeroCasa());

            return direccionGuardada;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public void eliminarDireccion(int id) throws PersistenciaException {
        String sentenciaSQL = "DELETE FROM DIRECCIONES WHERE Icliente=?";

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            
            comandoSQL.setInt(1, id);
            
            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "se ha eliminado (0)", resultado);

        } catch (SQLException e) {
            
            LOG.log(Level.SEVERE, "No se pudo eliminar la direccion");
            throw new PersistenciaException("No se pudo eliminar la direccion");
            
        }
    }
    @Override
    public Direccion actualizarDireccion(Direccion direccion) throws PersistenciaException {
        String sentenciaSQL = "UPDATE DIRECCIONES SET codigopostal=?, calle=?, colonia=?, numerocasa=? WHERE Idcliente=?";

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, direccion.getCodigoPostal());
            comandoSQL.setString(2, direccion.getCalle());
            comandoSQL.setString(3, direccion.getColonia());
            comandoSQL.setString(4, direccion.getNumeroCasa());
            comandoSQL.setInt(5, direccion.getIdDueno());
            
            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "se ha agregado (0)", resultado);

            ResultSet res = comandoSQL.getGeneratedKeys();

            res.next();

            Direccion direccionGuardada = new Direccion(direccion.getIdDueno(), direccion.getCodigoPostal(), direccion.getCalle(), direccion.getColonia(), direccion.getNumeroCasa());
            return direccionGuardada;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo actualizar la direccion");
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Direccion consultarDireccion(int id) throws PersistenciaException {
        String sentencia = "SELECT * FROM DIRECCIONES WHERE idcliente= ?";


        try (Connection conexion = this.conexionBD.crearConexion()) {
            PreparedStatement comandoSQL = conexion.prepareCall(sentencia);

            comandoSQL.setInt(1, id);

            ResultSet resultado = comandoSQL.executeQuery();
            resultado.next();

            Direccion direccion = new Direccion(resultado.getInt(1),
                    resultado.getString(2),
                    resultado.getString(3),
                    resultado.getString(4),
                    resultado.getString(5));

            return direccion;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, sentencia, e);
            throw new PersistenciaException("No se pudo consultar la direccion");

        }
        
    }
    
}
