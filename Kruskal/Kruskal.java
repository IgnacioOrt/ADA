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

	public boolean ComparaRaices(int nodoActual, int nodoFuturo)
	{
		if( BuscarRaiz( nodoActual, nodoFuturo ))
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	public int BuscarRaiz(int nodoActual)
	{
		if( nodoActual == raiz[nodoActual] )
		{
			return actual;
		}
		else
		{
			return raiz[nodoActual] = BuscarRaiz(raiz[nodoActual]);
		}
	}

	public void Unir(int nodoActual, int nodoFuturo)
	{
		int raizX = BuscarRaiz( nodoActual );
		int raizY = BuscarRaiz( nodoFuturo );
		raiz[ raizX ] = raizY;
	}

	public void kruskal()
	{
		int vertice1, vertice2;
		int totalAristas= 0;
		int total = 0;
		
		inicializar( vertices );//Inicializar cada Elemento(Nodo)

		for (int i = 0; i < aristas; i++) //Recorrer las aristas ordenadas por Peso
		{
			vertice1 = 
		}



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