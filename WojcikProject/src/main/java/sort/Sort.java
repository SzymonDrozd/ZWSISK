package sort;

import java.util.ArrayList; 
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.List;

public class Sort {

	 /* This function takes last element as pivot, 
    places the pivot element at its correct 
    position in sorted list, and places all 
    smaller (smaller than pivot) to left of 
    pivot and all greater elements to right 
    of pivot */
 int partition(List<Integer> list, int low, int high) 
 { 
     int pivot = list.get(high);  
     int i = (low-1); // index of smaller element 
     for (int j=low; j<high; j++) 
     { 
         if (list.get(j) <= pivot) 
         { 
             i++; 
             int temp = list.get(i); 
             list.set(i, list.get(j)); 
             list.set(j, temp);
         } 
     } 

     int temp = list.get(i+1); 
     list.set(i+1, list.get(high));
     list.set(high, temp);

     return i+1; 
 } 


 /* implements QuickSort() 
*/
 public void quickSort(List<Integer> list, int low, int high) 
 { 
     if (low < high) 
     { 
         int pi = partition(list, low, high); 

         quickSort(list, low, pi-1); 
         quickSort(list, pi+1, high); 
     } 
 } 

}
