/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Reposicion;
import Modelo.Supermercado;
import Modelo.Venta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.postgresql.util.PSQLException;

/**
 *
 * @author alumno
 */
public class GestionSupermercado {
    
    private ResultSet actividades;

    
    public void consulta(String consulta) throws SQLException
    {
        Conexion con = new Conexion();
          
        actividades = con.crearSentenciaSupermercado().executeQuery(consulta);
    }
    
    public void inserccion(String consulta) throws SQLException
    {
        Conexion con = new Conexion();
          
        con.crearSentenciaSupermercado().execute(consulta);
    }
    
    public ArrayList crearListaVenta(int codDirector) throws SQLException
    {
        Conexion con = new Conexion();
        
        ArrayList<Venta> listaVenta = new ArrayList();
        
        // Meter ventas al ArrayList
        actividades = con.crearSentenciaSupermercado().executeQuery("select COD_VEN, GANANCIAS, DIR_SUP, FECHA_SUP FROM VENTA V, SUPERMERCADO S WHERE S.COD_SUP=V.COD_VEN AND DIR_SUP="+codDirector+";");
        

        while(actividades.next()!=false)
        {
            Venta obj = new Venta(actividades.getFloat(2), actividades.getInt(1), actividades.getInt(3), actividades.getDate(4));
            listaVenta.add(obj);
        }
        
            
        return listaVenta; 
         
    }
    
    public ArrayList crearListaRepo (int codDirector) throws SQLException
    {
     
         Conexion con = new Conexion();
        
        ArrayList<Reposicion> listaRepo = new ArrayList();
        
        
        actividades = con.crearSentenciaSupermercado().executeQuery("Select COD_REP, INVERSION,DIR_SUP, FECHA_SUP FROM REPOSICION R, SUPERMERCADO S WHERE S.COD_SUP=R.COD_REP AND DIR_SUP="+codDirector+";");
        
        
        while(actividades.next()!=false)
        {
            Reposicion obj = new Reposicion(actividades.getFloat(2), actividades.getInt(1), actividades.getInt(3), actividades.getDate(4));
            listaRepo.add(obj);
        }
        
        return listaRepo;
    }
    
    
    public ResultSet devolverResultSet()
    {
        return actividades;
    }

}
