import java.lang.Math.*; 
import java.io.*;
import java.util.*;

class Comb_Sort 
{
    /* Function to merge the two haves arr[l..m] and 
    arr[m+1..r] of array arr[] */
    static void combsort(int arr[], int n) 
    {
        int gap = arr.length;
        double factor = 1.3;
        // Initialize swapped as true to make sure that 
        // loop runs 
        boolean swapped = false;

        // Keep running while gap is more than 1 and last 
        // iteration caused a swap 
        while (gap > 1 || swapped == true) 
        { 
            // Find next gap 
            if(gap > 1)
            {
                gap = (int)(gap/factor);
            }
            // Initialize swapped as false so that we can 
            // check if swap happened or not 
            swapped = false; 
            // Compare all elements with current gap 
            for (int i=0; gap+i < arr.length; i++) 
            { 
                if (arr[i] > arr[i+gap]) 
                { 
                    // Swap arr[i] and arr[i+gap] 
                    int temp = arr[i]; 
                    arr[i] = arr[i+gap]; 
                    arr[i+gap] = temp; 
  
                    // Set swapped 
                    swapped = true; 
                } 
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
      
    /* Driver program to test above functions */
    public static void main(String[] args) 
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
        long startTime;
        long endTime;
        for (int i = 0 ; i < 10 ; i++ ) {
            startTime = System.nanoTime();
            combsort(arr, n);
            System.out.printf("\nEl arreglo ordenado es: \n"); 
            printArray(arr, n); 
            endTime = System.nanoTime();
            System.out.println((endTime-startTime)/1e9);
        }
        
    } 
} 