package Cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Cliente extends Conexion
{
    public Cliente() throws IOException{super("cliente");} //Se usa el constructor para cliente de Conexion

    Scanner Entrada = new Scanner(System.in);
    public void startClient() //Método para iniciar el cliente
    {
       
        try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());
            
            String MNSC=""; char R='S'; int x=1;
            while (R == 's' || R == 'S')
            {
                System.out.println("+ ¿Qué desea enviarle al Servidor?");
                MNSC = Entrada.next();
                salidaServidor.writeUTF("- MSNC No. " + (x) + ": " + MNSC + "\n"); x++;
                System.out.println("");
                System.out.println("          ¿Desea enviarle algo más? S/N");
                R = Entrada.next().charAt(0);
                System.out.println("");
            }
            
            cs.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
