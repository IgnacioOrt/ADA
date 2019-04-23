import java.util.*;
class b_binaria 
{
	static void escribirArreglo(int arr[])
	{
		for (int i = 0 ; i < arr.length; i++)
		{
			System.out.print(" " + arr[i]);
		}
	}
	static int partition(int arr[], int low, int high) 
    {
        int pivot = arr[high];

        int i = (low-1);
        for (int j = low; j <= high-1; j++)
        {

            if (arr[j] <= pivot)
            {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    static void quickSortIterative (int arr[], int l, int h)
    {

        int[] stack = new int[h-l+1];
     
        int top = -1;
       
        stack[++top] = l;
        stack[++top] = h;
     
        while (top >= 0)
        {
            // Pop h and l
            h = stack[top--];
            l = stack[top--];
         
            int p = partition(arr, l, h);
       
            if (p-1 > l)
            {
                stack[++top] = l;
                stack[++top] = p - 1;
            }
            
            if (p+1 < h)
            {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    }
    static int buscar (int dato, int arr[])
    {
    	int inicio = 0;
        int fin = arr.length - 1;
        int pos = 0;
        while (inicio <= fin) 
        {
            pos = (inicio+fin) / 2;
            if ( arr[pos] == dato )
                return pos;
            else if ( arr[pos] < dato ) 
            {
                inicio = pos+1;
            } 
            else 
            {
                fin = pos-1;
            }
        }
            return -1;
    }
	public static void main(String[] args)
	{
		System.out.println("Busqueda binaria interativo");
		Scanner sc = new Scanner(System.in);
		int n, dato;
		System.out.print("Da el tamano del arreglo: ");
		n = sc.nextInt();
		int [] arr = new int[n];
		System.out.println("Introduce los datos del arreglo");
		for (int i = 0; i < n ; i++)
		{
			System.out.print(" A["+ (i + 1) + "] = ");
			arr[i] = sc.nextInt();
		}
		quickSortIterative(arr, 0, n-1); 	
		System.out.println("Ingresa el dato a buscar en el arreglo: ");
		dato = sc.nextInt();
		int pos = buscar(dato,arr);
		if (pos > -1)
			System.out.println("Elemento encontrado en el arreglo en la posicion: " + pos);
		else
			System.out.println("No se ha encontrado el dato");
	}
}