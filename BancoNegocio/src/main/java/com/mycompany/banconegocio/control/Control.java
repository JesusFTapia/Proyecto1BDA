/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banconegocio.control;
import com.mycompany.bancodominio.dto.ClienteDTO;
import com.mycompany.bancodominio.dto.DireccionDTO;
import com.mycompany.banconegocio.excepciones.ControlException;
import com.mycompany.bancodominio.dto.TransferenciaDTO;
import com.mycompany.bancodominio.pojo.Cliente;
import com.mycompany.bancodominio.pojo.Cuenta;
import com.mycompany.bancodominio.pojo.Direccion;
import com.mycompany.bancodominio.pojo.Retiro;
import com.mycompany.bancodominio.pojo.Transferencia;
import com.mycompany.bancopersistencia.dao.ClienteDAO;
import com.mycompany.bancopersistencia.dao.CuentaDAO;
import com.mycompany.bancopersistencia.dao.DireccionDAO;
import com.mycompany.bancopersistencia.dao.RetiroDAO;
import com.mycompany.bancopersistencia.dao.TransferenciaDAO;
import com.mycompany.bancopersistencia.excepciones.PersistenciaException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;

/**
 *
 * @author USER
 */
public class Control implements IControl{
    
    

    @Override
    public void transferir(TransferenciaDTO transferencia) throws ControlException{
        if(transferencia.getCantidad()<=0 || transferencia.getIdCuentaEnvia()==0 ||transferencia.getIdCuentaRecibe()==0){
            throw new ControlException("Datos incompletos");
        }else{
            try{
                
                TransferenciaDAO t=new TransferenciaDAO();
                CuentaDAO c=new CuentaDAO();
                Transferencia transferenciaNueva=new Transferencia(
                        transferencia.getIdCuentaEnvia(), 
                        transferencia.getIdCuentaRecibe(), 
                        c.consultarNumCuentaPorIDCuenta(transferencia.getIdCuentaEnvia()),
                        c.consultarNumCuentaPorIDCuenta(transferencia.getIdCuentaRecibe()),
                        transferencia.getCantidad());
                t.agregarTransferencia(transferenciaNueva);
            }catch(PersistenciaException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    @Override
    public int numCuenta(int id)throws ControlException{
        int numEnvia=-1;
        try{
            CuentaDAO c=new CuentaDAO();
            numEnvia=c.consultarCuentaPorIDCuenta(id).getNumeroCuenta();
            return numEnvia;
        }catch(PersistenciaException e){
            throw new ControlException("No se encontro la cuenta");
        }
    }
    @Override
    public int idCuenta(int id)throws ControlException{
        int idCuenta=-1;
        try{
            CuentaDAO c=new CuentaDAO();
            idCuenta=c.consultarCuentaPorNumCuenta(id).getIdcuenta();
            return idCuenta;
        }catch(PersistenciaException e){
            throw new ControlException("No se encontro la cuenta");
        }
    }

    @Override
    public int comprobarSesion(ClienteDTO cliente)throws ControlException {
        int idCuenta=-1;
        try{
            ClienteDAO c=new ClienteDAO();
            idCuenta=c.comprobarSesionCliente(cliente);
            return idCuenta;
        }catch(PersistenciaException e){
            throw new ControlException("No se encontro la cuenta");
        }
    }
    
    public List<Cuenta> consultarCuentasCliente(int id) throws ControlException{
        try{
            CuentaDAO c=new CuentaDAO();
            return c.consultarCuentasCliente(id);
        }catch(PersistenciaException e){
            throw new ControlException("No se encontraron cuentas");
        }
    }
    
    @Override
    public int idCliente(int id)throws ControlException{
        int idCliente=-1;
        try{
            CuentaDAO c=new CuentaDAO();
            idCliente=c.consultarClientePorIDCuenta(id);
            return idCliente;
        }catch(PersistenciaException e){
            throw new ControlException("No se encontro la cuenta");
        }
    }
    
    @Override
    public List<Transferencia> consultarTransferenciasCliente(int id) throws ControlException{
        try{
            TransferenciaDAO t=new TransferenciaDAO();
            return t.consultarTransferenciasCliente(id);
        }catch(PersistenciaException e){
            throw new ControlException("No se encontraron cuentas");
        }
    }
    
    public List<Transferencia> consultarTransferenciasPorPeriodo(String desde,String hasta) throws ControlException{
        try{
            TransferenciaDAO t=new TransferenciaDAO();
            return t.consultarTransferenciasPorPeriodo(desde,hasta);
        }catch(PersistenciaException e){
            throw new ControlException("No se encontraron cuentas");
        }
    }
    
    public List<Retiro> consultarRetirosCliente(int id) throws ControlException{
        try{
            RetiroDAO r=new RetiroDAO();
            return r.consultarRetirosCliente(id);
        }catch(PersistenciaException e){
            throw new ControlException("No se encontraron cuentas");
        }
    }
    
    public List<Retiro> consultarRetirosPorPeriodo(String desde,String hasta) throws ControlException{
        try{
            RetiroDAO r=new RetiroDAO();
            return r.consultarRetirosPorPeriodo(desde, hasta);
        }catch(PersistenciaException e){
            throw new ControlException("No se encontraron cuentas");
        }
    }
    
    public Retiro generarRetiro(int id,float monto) throws ControlException{
        if(monto<=0){
            throw new ControlException("Monto inválido");
        }else{
            try{
                
                RetiroDAO r=new RetiroDAO();
                Retiro retiro=new Retiro(this.generarFolio(),id,monto, generarContrasena());
                r.agregarRetiro(retiro);
                return retiro;
            }catch(PersistenciaException e){
                throw new ControlException(e.getMessage());
            }
        }
        
    }
    
    public float cobrarRetiro(int id,String contra) throws ControlException {
        try {
            RetiroDAO r = new RetiroDAO();
            r.cobrarRetiro(id,contra);
            float monto=r.consultarCantRetiro(id);
            return monto;
        } catch (PersistenciaException e) {
            throw new ControlException(e.getMessage());
        }

    }
    
    public String generarContrasena() {
        String caracteres= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder contrasena = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int indice = random.nextInt(caracteres.length());
            contrasena.append(caracteres.charAt(indice));
        }
        return contrasena.toString();
    }
    
    public int generarFolio() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }
    
    public int generarNumeroCuenta() {
        Random random = new Random();
        // Generar un número aleatorio de 8 dígitos (entre 10000000 y 99999999)
        return 10000000 + random.nextInt(90000000);
    }
    
    public void registrarCliente(ClienteDTO cliente,DireccionDTO direccion) throws ControlException {
        if(cliente.getNombre().equalsIgnoreCase("")||
                cliente.getApellidoPaterno().equalsIgnoreCase("")||
                cliente.getApellidoMaterno().equalsIgnoreCase("")||
                cliente.getFechaNacimiento().equalsIgnoreCase("")||
                cliente.getNombreUsuario().equalsIgnoreCase("")||
                cliente.getContrasena().equalsIgnoreCase("")||
                direccion.getCodigoPostal().equalsIgnoreCase("")||
                direccion.getCalle().equalsIgnoreCase("")||
                direccion.getColonia().equalsIgnoreCase("")||
                direccion.getNumeroCasa().equalsIgnoreCase("")){
            throw new ControlException("Necesitas llenar todos los campos");
        }
        try{
            ClienteDAO c=new ClienteDAO();
            DireccionDAO d=new  DireccionDAO();
            Cliente clienteTemp=c.agregarCliente(cliente);
            Direccion direccionTemp=new Direccion(clienteTemp.getIdcliente(), direccion.getCodigoPostal(), direccion.getCalle(), direccion.getColonia(), direccion.getNumeroCasa());
        d.agregarDireccion(direccionTemp);
        }catch(PersistenciaException e){
            throw new ControlException(e.getMessage());
        }
        
    }
    
    public Direccion consultarDireccion(int id) throws ControlException{
        try {

            DireccionDAO d=new DireccionDAO();
            Direccion direccion = d.consultarDireccion(id);
            return direccion;
        } catch (PersistenciaException e) {
            throw new ControlException(e.getMessage());
        }
        
    }
    
    public Cliente consultarCliente(int id)throws ControlException{
        try {

            ClienteDAO c=new ClienteDAO();
            Cliente cliente=c.consultarClientePorID(id);
            return cliente;
        } catch (PersistenciaException e) {
            throw new ControlException(e.getMessage());
        }
    }
    
    public void actualizarDatos(int id,ClienteDTO cliente,DireccionDTO direccion) throws ControlException{
        if(cliente.getNombre().equalsIgnoreCase("")||
                cliente.getApellidoPaterno().equalsIgnoreCase("")||
                cliente.getApellidoMaterno().equalsIgnoreCase("")||
                cliente.getNombreUsuario().equalsIgnoreCase("")||
                direccion.getCodigoPostal().equalsIgnoreCase("")||
                direccion.getCalle().equalsIgnoreCase("")||
                direccion.getColonia().equalsIgnoreCase("")||
                direccion.getNumeroCasa().equalsIgnoreCase("")){
            throw new ControlException("Necesitas llenar todos los campos");
        }
        try{
            ClienteDAO c=new ClienteDAO();
            DireccionDAO d=new  DireccionDAO();
            Cliente clienteTemp=new Cliente(id,cliente.getNombre(), cliente.getNombreUsuario(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getContrasena());
            c.actualizarCliente(clienteTemp);
            Direccion direccionTemp=new Direccion(clienteTemp.getIdcliente(), direccion.getCodigoPostal(), direccion.getCalle(), direccion.getColonia(), direccion.getNumeroCasa());
            d.actualizarDireccion(direccionTemp);
        }catch(PersistenciaException e){
            throw new ControlException(e.getMessage());
        }  
    }
    
    public int agregarCuenta(int idcliente,float monto) throws ControlException{
        if(monto<=0){
            throw new ControlException("Monto inválido");
        }else{
            try{
                
                CuentaDAO c=new CuentaDAO();
                int numCuenta=this.generarNumeroCuenta();
                Cuenta cuenta=new Cuenta(numCuenta, idcliente, monto);
                c.agregarCuenta(cuenta);
                return numCuenta;
            }catch(PersistenciaException e){
                throw new ControlException(e.getMessage());
            }
        }
    }
}
