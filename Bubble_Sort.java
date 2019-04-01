import java.util.*;
public class Bubble_Sort {
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
    static void printArray(int A[]) 
    {
        int i;
        for (i=0; i < A.length; i++)
            System.out.printf("%d ", A[i]);
        System.out.printf("\n");
    } 
    static int[] cargarArchivo(String nombre){
        Productor p = new Productor();
        Vector<Integer> vector = new Vector<Integer>();
        vector = p.leer(nombre);
        int arr[] = new int[vector.size()];
        for (int i = 0; i < vector.size() ; i++ ) {
            arr[i] = vector.elementAt(i);
        }
        int n = arr.length;
        return arr;
    }
    public static void main(String[] args) {
        //String[] archivos = {"Diez","Cien","Mil","Diezmil","Cienmil"};
        String[] archivos = {"Diez","Cien"};
        System.out.printf("El arreglo dado es: \n");
        int arr[];
        long startTime;
        long endTime;
        double tiempos[] = new double[10 * archivos.length];
        int k = 0;
        for (int j = 0; j < archivos.length ; j++ ) {
            
            for (int i = 0 ; i < 10 ; i++ ) {
                arr = cargarArchivo(archivos[j]);
                startTime = System.nanoTime();
                bubbleSort(arr);
                System.out.println("\nnEl arreglo ordenado es: ");  
                printArray(arr);
                endTime = System.nanoTime();
                tiempos[k + i] = (endTime-startTime)/1e9;
                System.out.println("\n" + (endTime-startTime)/1e9 + " segundos");
            }
            k+=10;
        }
        System.out.println("Tiempo de ejecución");
        k = 0;
        for (int i = 0 ; i < archivos.length ; i++ ) {
            System.out.println("Archivo: " + archivos[i]);
            for (int j = 0; j < 10 ; j++) {
                System.out.println("Tiempos: " + tiempos[k + j]);
            }
            k+=10;
        }
        
    }
}