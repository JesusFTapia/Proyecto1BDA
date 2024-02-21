/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancopersistencia.dao;

import com.mycompany.bancodominio.pojo.Cuenta;
import com.mycompany.bancopersistencia.conexion.Conexion;
import com.mycompany.bancopersistencia.conexion.IConexion;
import com.mycompany.bancopersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class CuentaDAO implements ICuentaDAO{
    final String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
    final String usuario = "root";
    final String contra = "sally2023";
    Conexion conexionBD = new Conexion(cadenaConexion, usuario, contra);
    private static final Logger LOG = Logger.getLogger(CuentaDAO.class.getName());

    public CuentaDAO() {
        
    }
    
    public void agregarCuenta(Cuenta cuenta) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO cuentas (idcliente,numeroCuenta, fechaApertura, saldo,estado) VALUES (?,?,now(),?,'Activa');";

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            
            comandoSQL.setInt(1, cuenta.getIdcliente());
            comandoSQL.setInt(2, cuenta.getNumeroCuenta());
            comandoSQL.setFloat(3, cuenta.getSaldo());
            
            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "se ha agregado (0)", resultado);

            ResultSet res = comandoSQL.getGeneratedKeys();

            res.next();

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo agregar el cliente");
            throw new PersistenciaException(e.getMessage());
        }
    }
    @Override
    public List<Cuenta> consultarCuentasCliente(int id) throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM CUENTAS WHERE IDCLIENTE=? and estado='Activa';";
        List<Cuenta> lista = new ArrayList<>();
        
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {
            
            comandoSQL.setInt(1, id);

            ResultSet res = comandoSQL.executeQuery();
            while (res.next()) {
                int idcliente = res.getInt("idcliente");
                int idcuenta = res.getInt("idcuenta");
                int numerocuenta = res.getInt("numeroCuenta");
                String fechaApertura = res.getString("fechaApertura");
                float saldo = res.getFloat("saldo");
                String estado = res.getString("estado");
                Cuenta c=new Cuenta(idcuenta, numerocuenta, idcliente, fechaApertura, saldo, estado);
                lista.add(c);
            }

            LOG.log(Level.INFO, "Se consultaron {0}", lista.size());

            return lista;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, sentenciaSQL, e);
            throw new PersistenciaException("No se pudieron consultar las cuentas");
        }
    }
    @Override
    public Cuenta consultarCuentaPorIDCliente(int id) throws PersistenciaException {
        String sentencia = "SELECT * FROM CUENTAS WHERE idcliente= ?";

        try (Connection conexion = this.conexionBD.crearConexion()) {
            PreparedStatement comandoSQL = conexion.prepareCall(sentencia);

            comandoSQL.setInt(1, id);

            ResultSet res = comandoSQL.executeQuery();
            res.next();
            int idcliente = res.getInt("idcliente");
            int idcuenta = res.getInt("idcuenta");
            int numerocuenta = res.getInt("numeroCuenta");
            String fechaApertura = res.getString("fechaApertura");
            float saldo = res.getFloat("saldo");
            String estado = res.getString("estado");
            Cuenta c=new Cuenta(idcuenta, numerocuenta, idcliente, fechaApertura, saldo, estado);
                

            return c;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, sentencia, e);
            throw new PersistenciaException("No se pudo encontrar la cuenta");

        }
    }
    
    @Override
    public Cuenta consultarCuentaPorIDCuenta(int id) throws PersistenciaException {
        String sentencia = "SELECT * FROM CUENTAS WHERE idcuenta= ?;";

        try (Connection conexion = this.conexionBD.crearConexion()) {
            PreparedStatement comandoSQL = conexion.prepareCall(sentencia);

            comandoSQL.setInt(1, id);

            ResultSet res = comandoSQL.executeQuery();
            res.next();
            int idcliente = res.getInt("idcliente");
            int idcuenta = res.getInt("idcuenta");
            int numerocuenta = res.getInt("numeroCuenta");
            String fechaApertura = res.getString("fechaApertura");
            float saldo = res.getFloat("saldo");
            String estado = res.getString("estado");
            Cuenta c=new Cuenta(idcuenta, numerocuenta, idcliente, fechaApertura, saldo, estado);
                

            return c;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, sentencia, e);
            throw new PersistenciaException("No se pudo encontrar la cuenta");

        }
    }
    
    @Override
    public Cuenta consultarCuentaPorNumCuenta(int id) throws PersistenciaException {
        String sentencia = "SELECT * FROM CUENTAS WHERE numeroCuenta= ?;";

        try (Connection conexion = this.conexionBD.crearConexion()) {
            PreparedStatement comandoSQL = conexion.prepareCall(sentencia);

            comandoSQL.setInt(1, id);

            ResultSet res = comandoSQL.executeQuery();
            res.next();
            int idcliente = res.getInt("idcliente");
            int idcuenta = res.getInt("idcuenta");
            int numerocuenta = res.getInt("numeroCuenta");
            String fechaApertura = res.getString("fechaApertura");
            float saldo = res.getFloat("saldo");
            String estado = res.getString("estado");
            Cuenta c=new Cuenta(idcuenta, numerocuenta, idcliente, fechaApertura, saldo, estado);
                

            return c;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, sentencia, e);
            throw new PersistenciaException("No se pudo encontrar la cuenta");

        }
    }
    @Override
    public int consultarNumCuentaPorIDCuenta(int id) throws PersistenciaException {
        String sentencia = "SELECT * FROM CUENTAS WHERE idcuenta= ?;";

        try ( Connection conexion = this.conexionBD.crearConexion()) {
            PreparedStatement comandoSQL = conexion.prepareCall(sentencia);

            comandoSQL.setInt(1, id);

            ResultSet res = comandoSQL.executeQuery();
            res.next();
            return res.getInt("numeroCuenta");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, sentencia, e);
            throw new PersistenciaException("No se pudo encontrar la cuenta");

        }
    }

    @Override
    public int consultarClientePorIDCuenta(int id) throws PersistenciaException {
        String sentencia = "SELECT * FROM CLIENTES WHERE idcliente= ?;";

        try ( Connection conexion = this.conexionBD.crearConexion()) {
            PreparedStatement comandoSQL = conexion.prepareCall(sentencia);

            comandoSQL.setInt(1, id);

            ResultSet res = comandoSQL.executeQuery();
            res.next();
            return res.getInt("idcliente");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, sentencia, e);
            throw new PersistenciaException(e.getMessage());

        }
    }
    
}
