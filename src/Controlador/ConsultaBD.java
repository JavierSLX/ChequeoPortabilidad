/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Numero;
import MySQL.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Morpheus
 */
public class ConsultaBD
{
    private static ConsultaBD bd;
    private Conexion conexion;

    private ConsultaBD() throws SQLException
    {
        conexion = Conexion.getInstance();
    }
    
    public static ConsultaBD getInstance() throws SQLException
    {
        if(bd == null)
            bd = new ConsultaBD();
        
        return bd;
    }
    
    //Obtiene el cliente (lo llena tambien en la clase numero)
    private String getCliente(Numero numero) throws SQLException
    {
        String cliente = null;
        
        //Preparamos la consulta
        String query = "SELECT n.digitos, CONCAT(pv.tipo, '-', cc.numero) AS cliente FROM numero n JOIN clave_cliente cc ON cc.cliente_id = n.cliente_id JOIN punto_venta pv ON pv.id = cc.puntoVenta_id WHERE n.digitos = ?";
        PreparedStatement consulta = Conexion.getInstance().getConnection().prepareStatement(query);
        
        consulta.setString(1, numero.getDigitos());
        
        //Obtenemos un apuntador con los resultados
        ResultSet set = consulta.executeQuery();
        if(set.first())
        {
            cliente = set.getString("cliente");
            numero.setCliente(cliente);
        }
        
        consulta.close();
        return cliente;
    }
    
    //Obtiene una lista de clientes en base a una lista de numeros
    public List<String> getClientes(List<Numero> numeros) throws SQLException
    {
        List<String> lista = new ArrayList<>();
        for(int i = 0; i < numeros.size(); i++)
            lista.add(getCliente(numeros.get(i)));
        
        return lista;
    }
}
