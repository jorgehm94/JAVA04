

import java.io.IOException;


public class Principal {


    public static void main(String[] args) throws ClassNotFoundException, IOException {
        
           Conexion con = new Conexion("postgres");
           
           con.cerrarConexion();
           
    }
    
}
