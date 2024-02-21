/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancopersistencia.dao;

import com.mycompany.bancodominio.pojo.Retiro;
import com.mycompany.bancopersistencia.conexion.Conexion;
import java.util.logging.Logger;
import com.mycompany.bancopersistencia.excepciones.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author USER
 */
public class RetiroDAO {
    final String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
    final String usuario = "root";
    final String contra = "sally2023";
    Conexion conexionBD = new Conexion(cadenaConexion, usuario, contra);
    private static final Logger LOG = Logger.getLogger(RetiroDAO.class.getName());
    
    public void agregarRetiro(Retiro retiro) throws PersistenciaException {
        String sentenciaSQL = "{CALL generar_retiro(?, ?, ?, ?)}";
        try (Connection conexion = this.conexionBD.crearConexion(); CallableStatement comandoSQL = conexion.prepareCall(sentenciaSQL);) {
            comandoSQL.setInt(1,retiro.getIdCuenta() );
            comandoSQL.setInt(2, retiro.getIdRetiro());
            comandoSQL.setFloat(3, retiro.getCantidad());
            comandoSQL.setString(4, retiro.getContraseña());
            comandoSQL.executeUpdate();
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException(e.getMessage());
        }
        
    }
    
    public List<Retiro> consultarRetirosCliente(int id) throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM RETIROSSINCUENTA WHERE idcuenta=?;";
        List<Retiro> lista = new ArrayList<>();
        
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {
            
            comandoSQL.setInt(1, id);

            ResultSet res = comandoSQL.executeQuery();
            while (res.next()) {
                int idcuenta = res.getInt("idcuenta");
                int folio = res.getInt("folio");
                String estado = res.getString("estado");
                float monto = res.getFloat("saldo");
                String fechai = res.getString("fechainicio");
                String fechae = res.getString("fechaexpiracion");
                Retiro r=new Retiro(folio, idcuenta,estado, monto, fechai, fechae);
                lista.add(r);
            }

            LOG.log(Level.INFO, "Se consultaron {0}", lista.size());

            return lista;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentenciaSQL, e);
            throw new PersistenciaException("No se pudieron consultar los retiros");
        }
    }
    

    public List<Retiro> consultarRetirosPorPeriodo(String desde,String hasta) throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM RETIROSSINCUENTA WHERE fechainicio between ? and ?;";
        List<Retiro> lista = new ArrayList<>();
        
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {
            
            comandoSQL.setString(1, desde);
            comandoSQL.setString(2, hasta);
            System.out.println(desde);
            System.out.println(hasta);


            ResultSet res = comandoSQL.executeQuery();
            while (res.next()) {
                int idcuenta = res.getInt("idcuenta");
                int folio = res.getInt("folio");
                String estado = res.getString("estado");
                float monto = res.getFloat("saldo");
                String fechai = res.getString("fechainicio");
                String fechae = res.getString("fechaexpiracion");
                Retiro r=new Retiro(folio, idcuenta,estado, monto, fechai, fechae);
                System.out.println(r);
                lista.add(r);
            }
            
            LOG.log(Level.INFO, "Se consultaron {0}", lista.size());

            return lista;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentenciaSQL, e);
            throw new PersistenciaException("No se pudieron consultar los retiros");
        }
    }
    public void cobrarRetiro(int id,String contra) throws PersistenciaException {
        String sentenciaSQL = "{CALL cobrar_retiro(?,?)}";
        try (Connection conexion = this.conexionBD.crearConexion(); CallableStatement comandoSQL = conexion.prepareCall(sentenciaSQL);) {
            
            comandoSQL.setInt(1,id );
            comandoSQL.setString(2,contra );
            comandoSQL.executeUpdate();
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException(e.getMessage());
        }
    }
    public float consultarCantRetiro(int id) throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM RETIROSSINCUENTA WHERE folio=?;";
        try (Connection conexion = this.conexionBD.crearConexion(); CallableStatement comandoSQL = conexion.prepareCall(sentenciaSQL);) {
            
            comandoSQL.setInt(1,id );
            ResultSet res = comandoSQL.executeQuery();
            res.next();
            float monto=res.getFloat("saldo");
            String estado=res.getString("estado");
            if(estado.equalsIgnoreCase("Cobrado")){
                throw new PersistenciaException("Este retiro ya esta cobrado");
            }
            return monto;
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException(e.getMessage());
        }
    }

}
