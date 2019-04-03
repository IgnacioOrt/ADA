import java.util.*; 
import java.io.*;
  
class Quick_Sort 
{
    /* This function takes last element as pivot, 
    places the pivot element at its correct 
    position in sorted array, and places all 
    smaller (smaller than pivot) to left of 
    pivot and all greater elements to right 
    of pivot */
    static int partition(int arr[], int low, int high) 
    {
        int pivot = arr[high];
        // index of smaller element
        int i = (low-1);
        for (int j = low; j <= high-1; j++)
        {
            // If current element is smaller than or 
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    /* A[] --> Array to be sorted,
    l  --> Starting index,
    h  --> Ending index */
    static void quickSortIterative (int arr[], int l, int h)
    {
        // Create an auxiliary stack
        int[] stack = new int[h-l+1];
        // initialize top of stack
        int top = -1;
        // push initial values of l and h to stack
        stack[++top] = l;
        stack[++top] = h;
        // Keep popping from stack while is not empty
        while (top >= 0)
        {
            // Pop h and l
            h = stack[top--];
            l = stack[top--];
            // Set pivot element at its correct position
            // in sorted array
            int p = partition(arr, l, h);
            // If there are elements on left side of pivot,
            // then push left side to stack
            if (p-1 > l)
            {
                stack[++top] = l;
                stack[++top] = p - 1;
            }
            // If there are elements on right side of pivot,
            // then push right side to stack
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
          
        // Function calling 
        long startTime = System.nanoTime();        
        quickSortIterative(arr, 0, n-1); 
        long endTime = System.nanoTime();

        System.out.printf("\nEl arreglo ordenado es: \n"); 
        printArray(arr, n); 
        
        System.out.println("\n");
        System.out.println("El Algorito Quick Sort tardó: "+ (endTime-startTime)/1e9 + " segundos");
    } 
} 