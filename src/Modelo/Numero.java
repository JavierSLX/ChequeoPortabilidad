/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Morpheus
 */
public class Numero
{
    private String fecha;
    private String digitos;
    private String cliente;

    public Numero(String fecha, String digitos)
    {
        this.fecha = fecha;
        this.digitos = digitos;
    }

    public Numero(String fecha, String digitos, String cliente)
    {
        this.fecha = fecha;
        this.digitos = digitos;
        this.cliente = cliente;
    }

    public String getFecha()
    {
        return fecha;
    }

    public void setFecha(String fecha)
    {
        this.fecha = fecha;
    }

    public String getDigitos()
    {
        return digitos;
    }

    public void setDigitos(String digitos)
    {
        this.digitos = digitos;
    }

    public String getCliente()
    {
        return cliente;
    }

    public void setCliente(String cliente)
    {
        this.cliente = cliente;
    }

    @Override
    public String toString()
    {
        return String.format("Fecha: %s, Numero: %s, Cliente: %s", getFecha(), getDigitos(), getCliente() == null ? "S/C" : getCliente());
    }
}
