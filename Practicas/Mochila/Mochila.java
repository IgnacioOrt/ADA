import java.util.*;

public class Mochila
{
  public static void main(String[] args) 
  {
    System.out.println("Problema de la mochila");
  	Scanner input =new Scanner (System.in);
  	double pesof = 0;
    System.out.println("Ingrese Cantidad Total de Objetos:");
    int totalObjetos = input.nextInt();
    if (totalObjetos > 0) {
      System.out.println("Ingrese el peso potal que puede llevar la mochila: ");
      int pesoMochila = input.nextInt();
      if (pesoMochila > 0) {
        double [] pesos = new double [totalObjetos];
        double [] valores = new double [totalObjetos];
        double [] division = new double [totalObjetos];
        float [] solucion = new float [totalObjetos];
        System.out.println("\n");
        for(int i=0; i < totalObjetos;i++)
        {
          do
          {
            System.out.println("Ingresa Peso (W) del Objeto "+(i+1)+":");
            pesos[i] = input.nextFloat();
            if(pesos[i] <= 0)
            {
              System.out.println("Error! Introduzca un valor positivo, Por favor"); 
            }
        }while (pesos[i] <= 0);
        do
        {
          System.out.println("Ingresa Valor (V) del Objeto "+(i+1)+":");
          valores[i] = input.nextFloat();
          if(valores[i] <= 0)
          {
            System.out.println("Introduzca un valor positivo, por favor "); 
          }
        }while(valores[i] <= 0);
        division[i] = valores[i]/pesos[i];
      }
      int puntero = 0;
      int [] posicion = new int [totalObjetos];
      double mayor = division[0];
      int i = 0;
      while (i < totalObjetos)
      {
        for(int j=0; j < totalObjetos; j++)
        {
          if(division[j] >= mayor)
          {
            mayor = division[j];
            puntero = j;
          }
        }

        division[puntero] = 0;
        mayor = division[0];
        posicion[i] = puntero;
        i++;
      }

      System.out.println("Lugar\tValor\tPeso\tX\tx * w\n");

      int a = 0;
      int b = 0;

      while (pesof < pesoMochila || b > totalObjetos)
      {
        a = posicion[b];

        if (pesof+pesos[a] <= pesoMochila)
        {
          solucion[a]=1;
          pesof = pesof + pesos[a];
        }
        else
        {
          double x = (pesoMochila-pesof)/pesos[a];
          solucion[a] = (float) x;
          pesof = pesoMochila;
        }

        //System.out.println("\nVector Solucion: "+solucion[a]+", ");
        System.out.println((a+1)+"\t"+valores[a]+"\t"+pesos[a]+"\t"+solucion[a]+"\t"+pesof+" \n");
        b++;
      }
    }else{
      System.out.println("La Cantidad de Objetos tiene que ser mayor a cero");
    }
  }else{
    System.out.println("No puede haber un peso negativo");
  }
  }
}