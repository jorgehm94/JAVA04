package Controlador;



import Vista.VentanaPrincipal;
import java.io.IOException;
import javax.swing.JPanel;


public class Principal {

    private static VentanaPrincipal prog = new VentanaPrincipal();

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                prog.setVisible(true);
            }
        });
            
          
    }
    public  static VentanaPrincipal devolverVentana()
    {
        return prog;
    }
    
    public static void cambioDePanel (JPanel a)
    {
         prog.setContentPane(a);
         prog.pack();
    }
    
}
