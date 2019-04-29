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

	public boolean ComparaRaices(int nodoActual, int odoFuturo)
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
			return Find( raiz [nodoActual] );
		}
	}

	public void Unir(int nodoActual, int nodoFuturo)
	{
		int raizX = BuscarRaiz( nodoActual );
		int raizY = BuscarRaiz( nodoFuturo );
		raiz[ raizX ] = raizY;
	}


	public static void main(String args[])
	{

	}
}