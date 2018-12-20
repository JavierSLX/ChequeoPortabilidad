/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Constantes;
import Modelo.Numero;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Morpheus
 */
public class EscrituraTxt
{
    private static EscrituraTxt escritura;

    private EscrituraTxt()
    {
    }
    
    public static EscrituraTxt getInstance()
    {
        if(escritura == null)
            escritura = new EscrituraTxt();
        
        return escritura;
    }
    
    public void crearTxt(List<Numero> numeros)
    {
        File file = new File(Constantes.resultado);
        
        try
        {
            FileWriter fileWriter = new FileWriter(file, true);
            
            //Coloca la lista en texto
            for(int i = 0; i < numeros.size(); i++)
            {
                String linea = String.format("%s,%s,%s\r\n", numeros.get(i).getFecha(), numeros.get(i).getDigitos(), numeros.get(i).getCliente());
                fileWriter.write(linea);
            }
            
            fileWriter.close();
            System.out.println("Archivo creado correctamente");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
