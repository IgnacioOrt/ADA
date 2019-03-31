import java.util.Random;
import java.util.*;
import java.io.*;

public class Productor
{
    public static void escribir(int[] array)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("archivo.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < array.length; i++)
            {
                if(array.length-1 == i)
                {
                    pw.print(array[i]);
                }
                else
                {
                    pw.println(array[i]);
                }
            }

        } 

        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
           try 
           {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
            if (null != fichero)
              fichero.close();
           } 
           catch (Exception e2) 
           {
              e2.printStackTrace();
            }
        }
    }


    public static void leer()
    {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try 
        {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("archivo.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

         // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
                System.out.println("Leido: "+linea);
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
        finally
        {
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
            try
            {                    
                if( null != fr )
                {   
                    fr.close();     
                }                  
            }
            catch (Exception e2)
            { 
                e2.printStackTrace();
            }
        }
    }

  public static void main (String[] args) 
  {
    int n;  
    Random rnd = new Random();
    Scanner input =new Scanner (System.in);


    System.out.println("Ingrese numero de Datos: "); 
    int numero = input.nextInt();
    long startTime = System.nanoTime();

    int ndigitos[] = new int[numero]; 

// verificar que los números aleatorios están uniformente distribuídos
        for (int i=0; i < numero; i++) 
        {
            // genera un número aleatorio entre 0 y 9
            n = rnd.nextInt(100-0)+0;
            ndigitos[i] = n;

            System.out.println(n+"\n");
        }
        long endTime = System.nanoTime();
        System.out.println("Tardó "+(endTime-startTime)/1e9+" segundos");
        System.out.println("\n");

        escribir(ndigitos);
        leer();


        // imprime los resultados
    }
}