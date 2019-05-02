import java.util.*;
class monedas
{
	public int denominaciones[];
	public int cantidad[];
	public int cambio[];
	public monedas(int m[], int n[])
	{

	}
	public monedas(int tam)
	{
		denominaciones = new int[tam];
		cambio = new int[tam];
		cantidad = new int[tam];
	}
	public void leerMonedas()
	{
		System.out.println("Escriba las denomicaciones de las monedas");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < denominaciones.length; i++)
		{
			System.out.print("\nDenominacion moneda " + (i+ 1) + ": " );
			denominaciones[i] = sc.nextInt();
			System.out.print("\nCantidad de monedas " + (i + 1) +": ");
			cantidad[i] = sc.nextInt();
		}
		invertirCantidades();
	}
	public void escribirCantidades()
	{
		System.out.println("\n");
		for (int i = 0 ; i < cantidad.length; i++)
		{
			System.out.print("Moneda ["+i+"]: " + cantidad[i]+"\n");
		}
	}
	public void escribirDenominaciones()
	{
		System.out.println("\n");
		for (int i = 0 ; i < denominaciones.length; i++)
		{
			System.out.print("Moneda ["+i+"]: $" + denominaciones[i]+"\n");
		}
	}
	public void escribirCambio()
	{
		System.out.println("\n");
		for (int i = cambio.length - 1; i >= 0 ; i--)
		{
			System.out.println(cambio[i] + " monedas de " + denominaciones[i]);
		}
	}
	public int calcularCambio(int cant)
	{
		int i = this.denominaciones.length - 1;
		int temp;
		while ( cant != 0) 
		{
			temp = cant / denominaciones[i];
			if (cantidad[i] >= temp) 
			{
				cambio[i] = cant / denominaciones[i];
				cant = cant % denominaciones[i];
			}else{
				cambio[i] = cantidad[i];
				cant =  (cant - (denominaciones[i] * cantidad[i]));
			}
			if ((cant < denominaciones[0]) || i == 0 )
			{
				break;
			}else
			{
				i--;
			}
		}
		return cant;
	}
	public void ordenar()
	{
		int n = denominaciones.length;
        int temp = 0;
        for(int i=0; i < n; i++)
        {
            for(int j=1; j < (n-i); j++)
            {
                if(denominaciones[j-1] > denominaciones[j])
                {
                    temp = denominaciones[j-1];
                    denominaciones[j-1] = denominaciones[j];
                    denominaciones[j] = temp;
                }
            }
        }
	}
	public void invertirCantidades()
	{
		int[] temp = new int[cantidad.length];
		for (int i = 0; i < cantidad.length ; i++) {
			temp[i] = cantidad[i];
		}
		int j = cantidad.length - 1;
		for (int i = 0;	i <  cantidad.length; i++ ) {
			cantidad[i] = temp[j];
			j--;
		}
		
	}
	public int verifMayorValor(int cant)
	{
		int band = 0;
		if (cant > denominaciones[0]) {
			band = 1;
		}
		//Si la bandera es 1 se puede dar cambio
		return band;
	}
	public static void main(String[] args) 
	{
		int tam;
		int cant;
		Scanner sc = new Scanner(System.in);
		System.out.println("********************************");
        System.out.println("********Programa Monedas********");
        System.out.println("************LIMITADO************");
        System.out.println("********************************\n");
		System.out.print("Ingrese el numero de denominaciones disponibles: ");
		tam = sc.nextInt();
		if (tam > 0)
		{
			monedas m = new monedas(tam);
			m.leerMonedas();	
			m.ordenar();
			System.out.print("\nLas monedas ingresadas Ordenadamente son: ");
			m.escribirDenominaciones();
			System.out.print("\nNumero de monedas por denominacion: ");
			m.escribirCantidades();
			System.out.print("\nIngrese la cantidad para pagar: ");
			cant = sc.nextInt();

			if (m.verifMayorValor(cant) == 1)
			{
				int cambio = m.calcularCambio(cant);
				if (cambio == 0) {
					System.out.print("\nCambio: ");
					m.escribirCambio();	
				}else{
					System.out.print("\nNo se puede dar cambio completo con las denominaciones dadas faltan $" + cambio);
					System.out.println("\nCambio: ");
					m.escribirCambio();	
				}
			}else{
				System.out.print("\nNo se puede dar cambio de la cantidad ingresada");
			}
		}else{
			System.out.println("\nIngrese una cantidad mayor a cero");
		}
	}
}
//50, 5, 100, 1, 10, 5, 5, 5, 1, 3