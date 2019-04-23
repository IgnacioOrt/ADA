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
    static boolean buscar (int dato, int arr[])
    {
    	boolean band = false;
    	int bajo = 0;
    	int medio;
    	int alto = arr.length - 1;
    	do
    	{
    		medio = (alto + bajo)/2;
    		if (dato < arr[medio])
    		{
    			alto = medio;
    		}
    		else
    		{
    			if (dato > arr[medio])
    			{
    				bajo = medio;
    			}
    			else
    			{
    				band = true;
    			}
    		}
    	} while ( (!band) && (bajo != alto - 1));
    	return band;
    }
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n, dato;
		System.out.print("Da el tamaño del arreglo: ");
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
		if (buscar(dato,arr))
			System.out.println("Elemento encontrado en el arreglo");
		else
			System.out.println("No se ha encontrado el dato");
	}
}