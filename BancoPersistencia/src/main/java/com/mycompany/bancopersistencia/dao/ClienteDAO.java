/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancopersistencia.dao;


import com.mycompany.bancodominio.dto.ClienteDTO;
import com.mycompany.bancodominio.pojo.Cliente;
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
public class ClienteDAO implements IClienteDAO{
    final String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
    final String usuario = "root";
    final String contra = "sally2023";
    Conexion conexionBD = new Conexion(cadenaConexion, usuario, contra);
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public ClienteDAO() {
        
    }
    
    @Override
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO CLIENTES (nombre,nombreUsuario,apellidoPaterno,apellidoMaterno,contrasena,fechaNacimiento) VALUES(?,?,?,?,?,?)";

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            
            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getNombreUsuario());
            comandoSQL.setString(3, cliente.getApellidoPaterno());
            comandoSQL.setString(4, cliente.getApellidoMaterno());
            comandoSQL.setString(5, cliente.getContrasena());
            comandoSQL.setString(6, cliente.getFechaNacimiento());
            
            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "se ha agregado (0)", resultado);

            ResultSet res = comandoSQL.getGeneratedKeys();

            res.next();
            Cliente clienteGuardado = new Cliente(res.getInt(1));

            return clienteGuardado;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo agregar el cliente");
            throw new PersistenciaException(e.getMessage());
        }
    }


    @Override
    public int comprobarSesionCliente(ClienteDTO cliente) throws PersistenciaException {
        String sentencia = "SELECT * FROM CLIENTES WHERE nombreUsuario= ? and contrasena=?; ";

        try (Connection conexion = this.conexionBD.crearConexion()) {
            PreparedStatement comandoSQL = conexion.prepareCall(sentencia);

            comandoSQL.setString(1, cliente.getNombreUsuario());
            comandoSQL.setString(2, cliente.getContrasena());
            ResultSet res = comandoSQL.executeQuery();
            res.next();
            return res.getInt("idcliente");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, sentencia, e);
            throw new PersistenciaException("El nombre de usuario o contraseña son incorrectos.");

        }
    }
    @Override
    public Cliente consultarClientePorID(int id) throws PersistenciaException {
        String sentencia = "SELECT * FROM CLIENTES WHERE idcliente= ?";

        try (Connection conexion = this.conexionBD.crearConexion()) {
            PreparedStatement comandoSQL = conexion.prepareCall(sentencia);

            comandoSQL.setInt(1, id);

            ResultSet resultado = comandoSQL.executeQuery();
            resultado.next();

            Cliente cliente = new Cliente(resultado.getInt("idcliente"),
                    resultado.getString("nombre"),
                    resultado.getString("nombreUsuario"),
                    resultado.getString("apellidoPaterno"),
                    resultado.getString("apellidoMaterno"),
                    resultado.getString("contrasena"),
                    resultado.getString("fechaNacimiento"));

            return cliente;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, sentencia, e);
            throw new PersistenciaException("No se pudo agregar el cliente");

        }
    }
    public Cliente actualizarCliente(Cliente cliente) throws PersistenciaException {
        String sentenciaSQL = "UPDATE CLIENTES SET nombre=?,nombreUsuario=?, apellidoPaterno=?, apellidoMaterno=? WHERE Idcliente=?";

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getNombreUsuario());
            comandoSQL.setString(3, cliente.getApellidoPaterno());
            comandoSQL.setString(4, cliente.getApellidoMaterno());
            comandoSQL.setInt(5, cliente.getIdcliente());
            
            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "se ha agregado (0)", resultado);

            ResultSet res = comandoSQL.getGeneratedKeys();

            res.next();

            Cliente clienteGuardado = new Cliente();
            return clienteGuardado;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo actualizar el cliente");
            throw new PersistenciaException(e.getMessage());
        }
    }
}



    
    

