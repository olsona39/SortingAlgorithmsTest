//reads a list of numbers from a text file, sorts the numbers, and writes out the sorted list to a
//file with a “-sorted” suffix and prints to screen the time taken to perform the sort.
//Implement a 2nd sorting method and produce a comparison of them.
//Adam Olson

import java.util.*;
import java.io.*;
import java.lang.*;

public class interview{

  public static void main(String[]args) throws IOException{
    int [] array = readInputFile();
    test(array);
  }

  public static int [] readInputFile(){
    File file = new File("numbers.txt");
    //ArrayList<Integer> due to uncertainty regarding size of array
    ArrayList<Integer> list = new ArrayList<Integer>();
    try{
      Scanner scanner = new Scanner(file);
      while(scanner.hasNextInt()){
        list.add(scanner.nextInt());
      }
    scanner.close();
    }catch (FileNotFoundException e){
      System.out.println("The file " + file.getPath() + " was not found.");
    }
    //ArrayList<Integer> to int[] conversion
    int [] array = new int[list.size()];
    for(int i = 0; i < array.length; i++){
      array[i] = list.get(i).intValue();
    }
  return array;
  }

  public static void test(int[] array) throws IOException{
    System.out.println();
    long mergeStart = System.nanoTime();
    mergeSort(array);
    long mergeEnd = System.nanoTime();

    long quickStart = System.nanoTime();
    quickSort(array);
    long quickEnd = System.nanoTime();

    long mergeTime = mergeEnd - mergeStart;
    long quickTime = quickEnd - quickStart;

    //write to output file "output-sorted.txt"
    PrintWriter out = new PrintWriter("output.txt");
    out.println("Sorting time results");
    out.println("MergeSort: " + mergeTime + " nanoseconds.");
    out.println("Quicksort: " + quickTime + " nanoseconds.");
    out.println("Testing concluded.");
    out.close();

    System.out.println("Sorting time results: ");
    System.out.println("Mergesort: " + mergeTime + " nanoseconds.");
    System.out.println("Quicksort: " + quickTime + " nanoseconds.");
    System.out.println("Testing concluded.");
  }

  public static int[] mergeSort(int [] unsortedArray){
    int [] A = unsortedArray;
    if(A.length > 1){
      int mid = A.length/2;
      int [] leftHalf = Arrays.copyOfRange(A, 0, mid);
      int [] rightHalf = Arrays.copyOfRange(A, mid, A.length);

      mergeSort(leftHalf);
      mergeSort(rightHalf);
      int i = 0;
      int j = 0;
      int k = 0;

      while(i < leftHalf.length && j < rightHalf.length){
        if(leftHalf[i] < rightHalf[j]){
          A[k] = leftHalf[i];
          i++;
        }else{
          A[k] = rightHalf[j];
          j++;
        }
        k++;
      }
      while(i < leftHalf.length){
        A[k] = leftHalf[i];
        i++;
        k++;
      }
      while(j < rightHalf.length){
        A[k] = rightHalf[j];
        j++;
        k++;
      }
    }
    return A;
    }

    public static int [] quickSort(int [] unsortedArray){
      int [] A = recQuickSort(unsortedArray, 0, unsortedArray.length - 1);
      return A;
    }

    public static int[] recQuickSort (int [] unsortedArray, int first, int last){
      int [] A = unsortedArray;
      if(first < last){
        int splitpoint = partition(A, first,last);
        recQuickSort(A, first, splitpoint-1);
        recQuickSort(A, splitpoint + 1, last);
      }
    return A;
    }

    public static int partition(int [] A, int first, int last){
      int pivot = A[first];
      int r = last;
      int l = first + 1;
      int temp;
      boolean done = false;
      //looking for an 'l' that is greater than pivot
      //and 'r' that is less than pivot
      //if r is less than l swap
      while (!done){
        while(l <= r && A[l] <= pivot){
          l = l + 1;
        }
        while( A[r] >= pivot && r >= l){
          r = r - 1;
        }
        if (r < l){
          done = true;
        }else{
          temp = A[l];
          A[l] = A[r];
          A[r] = temp;
        }
      }
      temp = A[first];
      A[first] = A[r];
      A[r] = temp;
      return r;
    }
}
