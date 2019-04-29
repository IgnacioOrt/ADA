import java.util.*;
import java.io.*;

public class Kruskal
{	
	int tam;
	int[] raiz;
	arista[] aristas;

	public Kruskal(int tam)
	{	
		this.tam = tam;

		raiz = new int[tam];
	}

	public void Inicializar(int n)
	{
		for(int i=0; i < n; i++)
		{
			raiz[i] = i;
		}
	}

	public boolean ComparaRaices(int vertice1, int vertice2)//Compara si entre los 2 nodos ingresados hay una raíz compartida
	{
		if( BuscarRaiz(vertice1) == BuscarRaiz(vertice2))
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	public int BuscarRaiz(int vertice1)//Busca El Vértice RAIZ del Vértice que se ingresa
	{
		if( vertice1 == raiz[vertice1] )
		{
			return vertice1;
		}
		else
		{
			return raiz[vertice1] = BuscarRaiz(raiz[vertice1]);

		}
	}

	public void Unir(int vertice1, int vertice2)//Asigna una nueva Relación entre los 2 vértices ingresados
	{
		raiz[BuscarRaiz(vertice1)] = BuscarRaiz(vertice2); 
	}

	public void kruskal()
	{
		int vertice1, vertice2;
		int numAristas= 0;
		int totalpeso = 0;
		
		Inicializar( aristas.length );//Inicializar cada Elemento(Nodo)

		for (int i = 0; i < aristas.length; i++) //Recorrer las aristas ordenadas por Peso
		{
			vertice1 = arista[i].vertice1;
			vertice2 = arista[i].vertice2;
			peso = arista[i].peso;

			if(!ComparaRaices(vertice1, vertice2))
			{
				totalpeso += peso; //Incrementa el peso Total del Resultado Final
				Unir(vertice1,vertice2);
				 //????[ numAristas++ ] = arista[ i ]; 

			}
		}

		if( totalAristas- 1 != numAristas ) //NOMBRE DE LA VARIABLE??????
		{
	        System.out.println("\nERROR: No existe Solución válida para el grafo ingresado.");
	        return;
		}

		System.out.println("La Solución Encontrada es: \n");

		for( int i = 0 ; i < numAristas ; ++i )
		{
	        //System.out.printf("( %d , %d ) : %d\n" , ??[ i ].vertice1 , ??[ i ].vertice2 , ??[ i ].peso ); //Impresión de la Solución
		}

		System.out.printf( "El costo minimo de la Solución al Grafo es : %d\n" , totalpeso);
	}


	public void creaAristas(int matriz[][])
	{
		arista temp;
		int k = 0;
		for (int i = 0; i < raiz.length; i++ ) {
			for (int j = i + 1; j < raiz.length; j++) {
				if (matriz[i][j] > 0) {
					k++;
				}
			}
		}
		aristas = new arista[k];
		k = 0;

		for (int i = 0; i < raiz.length; i++ ) {
			for (int j = i + 1; j < raiz.length; j++) {
				if (matriz[i][j] > 0) {
					temp = new arista(i,j,matriz[i][j]);
					aristas[k] = temp;
					k++;
				}
			}
		}
		ordenaAristas();
	}

	public void ordenaAristas()
	{
		int n = aristas.length;
        arista temp;
        for(int i=0; i < n; i++)
        {
            for(int j=1; j < (n-i); j++)
            {
                if(aristas[j-1].peso > aristas[j].peso)
                {
                    temp = aristas[j-1];
                    aristas[j-1] = aristas[j];
                    aristas[j] = temp;
                }
            }
        }
	}

	public void printAristas()
	{
		for (int i = 0; i < aristas.length; i++) {
			aristas[i].escribeArista();
		}
	}
	public static void main(String args[])
	{
		grafo G = new grafo();
		G.LeeGrafo("entrada.dat");
 		G.escribematriz();
 		Kruskal k = new Kruskal(G.getSize());
 		k.creaAristas(G.getMatriz());
 		k.printAristas();

 		k.kruskal();
	}

}