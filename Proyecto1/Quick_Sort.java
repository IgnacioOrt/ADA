import java.util.*; 
import java.io.*;
  
class Quick_Sort 
{

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
    static void printArray(int A[], int size)
    {
        int i;
        for (i=0; i < size; i++)
            System.out.printf("%d ", A[i]);
        System.out.printf("\n"); 
    }
    // Driver code 
    public static void main(String args[]) 
    {
        Productor p = new Productor();
        Vector<Integer> vector = new Vector<Integer>();
        vector = p.leer();
        int arr[] = new int[vector.size()]; 
        for (int i = 0; i < vector.size() ; i++ ) {
            arr[i] = vector.elementAt(i);
        }
        
        int n = arr.length; 
        System.out.printf("El arreglo dado es: \n"); 
        printArray(arr, n); 
          
        long startTime = System.nanoTime();        
        quickSortIterative(arr, 0, n-1); 
        long endTime = System.nanoTime();

        System.out.printf("\nEl arreglo ordenado es: \n"); 
        printArray(arr, n); 
        
        System.out.println("\n");
        System.out.println("El Algorito Quick Sort tardó: "+ (endTime-startTime)/1e9 + " segundos");
    } 
} 