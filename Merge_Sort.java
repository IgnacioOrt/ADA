import java.lang.Math.*; 
import java.io.*;
import java.util.*;
class Merge_Sort { 
  

    static void mergeSort(int arr[], int n) 
    { 
          
        int curr_size;  
                      
        int left_start; 
                           
        for (curr_size = 1; curr_size <= n-1;  
                      curr_size = 2*curr_size) 
        { 
               
            for (left_start = 0; left_start < n-1; 
                        left_start += 2*curr_size) 
            { 

                int mid = left_start + curr_size - 1; 
          
                int right_end = Math.min(left_start  
                             + 2*curr_size - 1, n-1); 

                merge(arr, left_start, mid, right_end); 
            } 
        } 
    } 
      
    static void merge(int arr[], int l, int m, int r) 
    { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 = r - m; 
      
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 

        for (i = 0; i < n1; i++) 
            L[i] = arr[l + i]; 
        for (j = 0; j < n2; j++) 
            R[j] = arr[m + 1+ j]; 

        i = 0; 
        j = 0; 
        k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 

        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
      
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
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
        mergeSort(arr, n); 
        long endTime = System.nanoTime();

        System.out.printf("\nEl arreglo ordenado es: \n"); 
        printArray(arr, n); 
        
        System.out.println((endTime-startTime)/1e9);
    } 
} 