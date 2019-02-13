import java.util.*;
public class sortingPack{
  public static void main(String[]args){
    int [] array = {1, 3, 5, 3, 6, 4, 2};
    System.out.println(Arrays.toString(mergeSort(array)));
  }
  public static int[] mergeSort(int[] unsortedArr){
    int [] A = unsortedArr;
    if (A.length > 1){
      int mid = A.length/2;
      int [] lefthalf = Arrays.copyOfRange(A,0,mid);
      int [] righthalf = Arrays.copyOfRange(A,mid,A.length);

      mergeSort(lefthalf);
      mergeSort(righthalf);
      int i = 0;
      int j = 0;
      int k = 0;

      while (i < lefthalf.length && j < righthalf.length){
        if ( lefthalf[i] < righthalf[j]){
          A[k] = lefthalf[i];
          i++;
        }else{
          A[k] = righthalf[j];
          j++;
        }
        k++;
      }
      while (i < lefthalf.length){
        A[k] = lefthalf[i];
        i++;
        k++;
      }
      while ( j < righthalf.length){
        A[k] = righthalf[j];
        j++;
        k++;
      }
    }
    return A;
  }
}
