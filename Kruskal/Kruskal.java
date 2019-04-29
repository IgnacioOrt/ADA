import java.util.*;
import java.io.*;

public class Kruskal
{	
	int[] raiz;
	arista[] aristas;
	public Kruskal(int tam)
	{
		aristas = new arista[tam];
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

		



	}


	public void creaAristas(int matriz[][])
	{
		
	}
	public static void main(String args[])
	{
		grafo G = new grafo();
		G.LeeGrafo("entrada.dat");
 		G.escribematriz();
 		Kruskal k = new Kruskal(G.getSize());
 		k.creaAristas(G.getMatriz());
 		k.kruskal();
	}

}