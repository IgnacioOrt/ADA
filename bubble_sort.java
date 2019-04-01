import java.util.*;
public class bubble_sort {  
    static void bubbleSort(int[] arr) {  
        int n = arr.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arr[j-1] > arr[j]){  
                                 //swap elements  
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
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
    public static void main(String[] args) {
        Productor p = new Productor();
        Vector<Integer> vector = new Vector<Integer>();
        vector = p.leer();
        int arr[] = new int[vector.size()]; 
        for (int i = 0; i < vector.size() ; i++ ) {
            arr[i] = vector.elementAt(i);
        }
        int n = arr.length; 
        long startTime = System.nanoTime();
        System.out.printf("El arreglo dado es: \n"); 
        printArray(arr, n);
        System.out.println();  

        bubbleSort(arr);//sorting array elements using bubble sort  

        System.out.println("\nnEl arreglo ordenado es: ");  
        for(int i=0; i < arr.length; i++){  
            System.out.print(arr[i] + " ");  
        }  
        long endTime = System.nanoTime();
        System.out.println("\n" + (endTime-startTime)/1e9 + " segundos");
    }  
}  