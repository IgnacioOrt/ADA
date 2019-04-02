import java.util.Random;
import java.util.*;
import java.io.*;

class Productor
{
    public Productor()
    {

    }
    public void generar(){
        Random rnd = new Random();
        Scanner input =new Scanner (System.in);

        System.out.println("Ingrese nombre del Archivo: ");
        String archivo = input.nextLine();
        System.out.println("Ingrese numero de Datos: ");
        int numero = input.nextInt();
        int ndigitos[] = new int[numero];
        // verificar que los números aleatorios están uniformente distribuídos
        for (int i=0; i < numero; i++) 
        {
            // genera un número aleatorio entre 0 y 9
            ndigitos[i] = rnd.nextInt(1000000-0)+0;

            System.out.println(ndigitos[i]+"\n");
        }
        escribir(ndigitos, archivo + ".txt");
    }
    public void escribir(int[] array, String nombre)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nombre);
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

    public Vector leer()
    {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        Vector<Integer> ndigitos=new Vector<Integer>();
        Scanner input =new Scanner (System.in);

        System.out.println("Ingrese nombre del Archivo: ");
        String nombre = input.nextLine();

        try 
        {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File (nombre + ".txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
            {
                System.out.println("Leido: "+linea);
                ndigitos.addElement( Integer.parseInt(linea));
            }
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
        return ndigitos;
    }
    /*
        long endTime = System.nanoTime();
        System.out.println("Tardó "+(endTime-startTime)/1e9+" segundos");
        System.out.println("\n");*/
}