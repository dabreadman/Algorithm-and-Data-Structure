import java.util.Arrays;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	//select
    	for (int i=1; i<a.length;i++) {
    		int index=i;
    		while(a[index]<a[index-1]) {
    			swap(a,index,index-1);
    			index--;
    			if(index==0) break;
    		}
    	}
    	return a;
    }
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	//outer for loop
    	for(int i=0; i<a.length;i++) {
    		double min = a[i];
    		int index = i;
    		//find min
    		for(int j=i+1;j<a.length;j++) {
    			if(a[j]<min) {
    				min = a[j];
    				index = j;
    			}
    		}
    		//swap elements
    		swap(a,index,i);
    	}
    	return a;
    }

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
	
		 //todo: implement the sort
    	return null;
    }//end quicksort

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {

		 //todo: implement the sort
    	return null;
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	

    	//todo: implement the sort
    	return null;
   }//end mergeSortRecursive
    	
    

    static void swap (double a[], int index1, int index2) {
    	double temp = a[index1];
    	a[index1] = a[index2];
    	a[index2] = temp;
    }
   


    public static void main(String[] args) {
    	double a[] = new double[] {-1,-3,0,1,2,3,5,7,11,8,9.123,-0, 0};
    	long start = System.nanoTime();
    	insertionSort(a);
    	long end = System.nanoTime();
    	System.out.println(end - start + "ns");
    	System.out.println(Arrays.toString(a));
        //todo: do experiments as per assignment instructions
    }

 }//end class

