import java.util.*;

public class Mochila
{
    public static void main(String[] args) 
    {
      	Scanner input =new Scanner (System.in);

        System.out.println("********************************");
        System.out.println("********Programa Mochila********");
        System.out.println("********************************\n");


        System.out.println("Ingrese Cantidad Total de Objetos:");
        int totalObjetos = input.nextInt();

        while(totalObjetos <= 0)
        {
        		System.out.println("\nERROR!!! ");
        		System.out.println("La Cantidad de Objetos tiene que ser mayor a 0 (Cero) ");
        		System.out.println("Por favor, ingrese una cantidad aceptable de objetos");
        		totalObjetos = input.nextInt();
        }

        System.out.println("Ingrese el Peso Total que puede llevar la mochila (de 50 a 100): ");
        int pesoMochila = input.nextInt();

      	while(pesoMochila < 50 || pesoMochila > 100 )
        {
        		System.out.println("\nERROR!!! ");
        		System.out.println("La Cantidad de Peso tiene que ser mayor a 50 (Cincuenta) y menor que 100 (Cien)");
        		System.out.println("Por favor, ingrese una cantidad aceptable de Peso");
        		pesoMochila = input.nextInt();
        }

			int [][] pesoObjeto = new int [totalObjetos][2];
			System.out.println("\n");

      		for(int i=0; i < totalObjetos;i++)
        	{
        	 	for(int j=0; j < 2;j++)
        		{	
        	 		if(j == 0)
        	 		{
        	 			System.out.println("Ingresa Peso (W) del Objeto "+(i+1)+":");
        	 			pesoObjeto[i][j] = input.nextInt();
        	 		}
        	 		else
        	 		{
        	 			System.out.println("Ingresa Valor (V) del Objeto "+(i+1)+":");
        	 			pesoObjeto[i][j] = input.nextInt();
        	 		}
        	 	}
        	}


			System.out.println("\n");
        	for(int i=0; i < totalObjetos;i++)
        	{
        	 	for(int j=0; j < 2;j++)
        		{	
        	 		if(j == 0)
        	 		{
        	 			System.out.println("Peso del Objeto "+(i+1)+" (W) :"+pesoObjeto[i][j]);
        	 		}
        	 		else
        	 		{
        	 			System.out.println("Valor del Objeto "+(i+1)+" (V) :"+pesoObjeto[i][j]);
        	 		}
        	 	}
        	}


    }
}