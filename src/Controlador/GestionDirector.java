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
    
    public  ResultSet consulta(String consulta) throws SQLException
    {
        Conexion con = new Conexion();
          
        return con.crearSentenciaDirector().executeQuery(consulta);
    }

    
}
