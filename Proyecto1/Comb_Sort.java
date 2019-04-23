import java.lang.Math.*; 
import java.io.*;
import java.util.*;

class Comb_Sort 
{

    static void combsort(int arr[], int n) 
    {
        int gap = arr.length;
        double factor = 1.3;
        boolean swapped = false;

        while (gap > 1 || swapped == true) 
        { 
 
            if(gap > 1)
            {
                gap = (int)(gap/factor);
            }
  
            swapped = false; 

            for (int i=0; gap+i < arr.length; i++) 
            { 
                if (arr[i] > arr[i+gap]) 
                { 

                    int temp = arr[i]; 
                    arr[i] = arr[i+gap]; 
                    arr[i+gap] = temp; 
  
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
        long startTime = System.nanoTime();
        combsort(arr, n); 
        long endTime = System.nanoTime();
        System.out.printf("\nEl arreglo ordenado es: \n"); 
        printArray(arr, n); 
        
        System.out.println((endTime-startTime)/1e9);
    } 
} 