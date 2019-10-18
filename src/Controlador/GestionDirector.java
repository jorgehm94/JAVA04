/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alumno
 */
public class GestionDirector {
        
    ResultSet datos;
    
    public void consulta(String consulta) throws SQLException
    {
        Conexion con = new Conexion();
          
        datos = con.crearSentenciaDirector().executeQuery(consulta);
    }
    
    public void avanzar() throws SQLException
    {
        datos.next();
    }
    
    public void retroceder() throws SQLException
    {
        datos.previous();
    }
    
    public void primero() throws SQLException
    {
        datos.beforeFirst();
        datos.next();
    }
    
    
    public void ultimo() throws SQLException
    {
        datos.afterLast();
        datos.previous();
    }
    
    public boolean isFirst() throws SQLException
    {
        return datos.isFirst();
    }
    
    public boolean isLast() throws SQLException
    {
        return datos.isLast();
    }
    
    public String devolverColumna(int i) throws SQLException
    {
        return datos.getString(i);
    }
    
}
