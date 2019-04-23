import java.util.*;
class b_Rec
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
    public static int busquedaBinariaRecursiva(int[] arreglo, int busqueda, int izquierda, int derecha){
 
        // Si izquierda es mayor que derecha significa que no encontramos nada
        if(izquierda > derecha){
            return -1;
        }
 
        // Calculamos las mitades...
        int indiceDelElementoDelMedio = (int) Math.floor((izquierda + derecha) / 2);
        int elementoDelMedio = arreglo[indiceDelElementoDelMedio];
 
        // Ver si está en la mitad
        if(elementoDelMedio == busqueda){
            return indiceDelElementoDelMedio;
        }
        // Si no, entonces vemos si está a la izquierda o derecha
 
        if(busqueda < elementoDelMedio){
            derecha = indiceDelElementoDelMedio - 1;
            return busquedaBinariaRecursiva(arreglo, busqueda, izquierda, derecha);
        }else{
            izquierda = indiceDelElementoDelMedio + 1;
            return busquedaBinariaRecursiva(arreglo, busqueda, izquierda, derecha);
        }
    }

	public static void main(String[] args)
	{
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
        int indiceDelElementoBuscado = busquedaBinariaRecursiva(arr, dato, 0, arr.length - 1);
		System.out.println("El elemento buscado (" + String.valueOf(dato) + ") se encuentra en la posicion " + indiceDelElementoBuscado);
	}
}