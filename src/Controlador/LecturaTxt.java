/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Numero;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Morpheus
 */
public class LecturaTxt
{
    private static LecturaTxt lectura;

    private LecturaTxt()
    {
    }
    
    public static LecturaTxt getInstance()
    {
        if(lectura == null)
            lectura = new LecturaTxt();
        
        return lectura;
    }
    
    public List<Numero> getLista(String archivo)
    {
        List<Numero> lista = new ArrayList<>();
        BufferedReader br = null;
        
        InputStreamReader reader = null;
        try
        {
            //Abre el archivo
            reader = new InputStreamReader(new FileInputStream(archivo), "ISO-8859-1");
            br = new BufferedReader(reader);
            
            //Lee cada linea de texto y los acomoda en la lista
            String linea;
            while((linea = br.readLine()) != null && !linea.isEmpty())
            {
                String campos[] = new String[2];
                campos = linea.split("\t");
                
                lista.add(new Numero(campos[0], campos[1]));
            }
            
            return lista;
            
        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            try
            {
                reader.close();
                br.close();
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
