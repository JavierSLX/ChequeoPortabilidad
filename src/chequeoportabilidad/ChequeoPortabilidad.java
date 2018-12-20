/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chequeoportabilidad;

import Controlador.ConsultaBD;
import Controlador.EscrituraTxt;
import Controlador.LecturaTxt;
import Modelo.Constantes;
import Modelo.Numero;
import MySQL.Conexion;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Morpheus
 */
public class ChequeoPortabilidad
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //Obtiene la lista de datos del documento de datos
        List<Numero> lista = LecturaTxt.getInstance().getLista(Constantes.origen);
      
        
        try
        {
            //Obtiene la lista de clientes
            ConsultaBD.getInstance().getClientes(lista);
            
            //Pasa a un documento
            EscrituraTxt.getInstance().crearTxt(lista);
            
        } catch (SQLException ex)
        {
            Logger.getLogger(ChequeoPortabilidad.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
