import java.util.*;
import java.io.*;

public class Kruskal
{	

	
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
			return raiz[nodoActual] = Find(raiz[nodoActual]);
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


	public static void main(String args[])
	{
			grafo g = new grafo();

			kruskal();
	}

}