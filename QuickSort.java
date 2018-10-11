package Sorts;

public class QuickSort {
	
	public static int iterations = 0;
	public static int operations = 0;

	public static void main(String[] args) {
		
		int target1[] = {5,9,23,19,2};
		int target2[] = {104,23,514,235,526,1003};
		int target3[] = {1,2,3,4,5,6,7,8,9,10};
		int target4[] = {10,9,8,7,6,5,4,3,2,1};
		int targetBig[] = {65,83,85,60,8,52,72,15,79,80,97,46,79,51,42,66,4,28,35,33,60,31,67,99,41,42,3,12,37,40,53,7,62,53,61,36,53,53,81,8,82,87,85,29,3,93,11,98,20,56,64,79,70,41,84,9,73,91,14,10,69,96,50,37,3,18,35,38,35,83,33,29,6,59,39,50,10,88,52,6,19,50,24,28,64,86,19,59,24,69,15,91,100,90,71,96,49,65,14,24};
		
		QuickSort demo = new QuickSort();
		
		demo.printArray(target1);
		demo.quickSort(target1, 0, target1.length-1);
		System.out.println("Iterations to sort: " + iterations);
		System.out.println("Operations to sort: " + operations);
		demo.printArray(target1);
		System.out.println();
		
		demo.printArray(target2);
		demo.quickSort(target2, 0, target2.length-1);
		System.out.println("Iterations to sort: " + iterations);
		System.out.println("Operations to sort: " + operations);
		demo.printArray(target2);
		System.out.println();
		
		demo.printArray(target3);
		demo.quickSort(target3, 0, target3.length-1);
		System.out.println("Iterations to sort: " + iterations);
		System.out.println("Operations to sort: " + operations);
		demo.printArray(target3);
		System.out.println();
		
		demo.printArray(target4);
		demo.quickSort(target4, 0, target4.length-1);
		System.out.println("Iterations to sort: " + iterations);
		System.out.println("Operations to sort: " + operations);
		demo.printArray(target4);
		System.out.println();
		
		demo.printArray(targetBig);
		demo.quickSort(targetBig, 0, targetBig.length-1);
		System.out.println("Iterations to sort: " + iterations);
		System.out.println("Operations to sort: " + operations);
		demo.printArray(targetBig);
		System.out.println();

	}
	
	/*
	 *	Quick sort is the first algorithm in this analysis which utilizes the divide and conquer method of
	 *sorting values by pivoting an array around a given value, sorting the values into arrays on either side,
	 *and repeating. The worst case complexity is still O(n^2) but the advantage of the sort is that the average
	 *complexity is Θ(n log(n)). This average runtime is calculated by considering every possible 
	 *permutation of array which is far too exhaustive for this particular research but the average runtime is 
	 *generally accepted as thus by those who have the time to do so. This average runtime is what makes the
	 *algorithm useful as the average real world case occurs much more frequently and the algorithm can be altered
	 *to suit the specific real world data.
	 * 
	 *Footnote: The "iterations" in this example are technically recursions, but for the sake of parity with the
	 *rest of the analysis and as that the principle that the iterations counter tracks is functionally the same,
	 *the convention remains.
	 */
	
	//The partition algorithm for the sort. Pivots the array around the last element and .
	public int partition(int target[], int low, int high) {
		int pivot = target[high];
		int i = low-1;
		for(int j = low; j <= high-1; j++) {
			iterations++;
			if(target[j] <= pivot) {
				i++;
				int temp = target[i];
	            target[i] = target[j];
	            target[j] = temp;
	            operations++;
			}
		}
		int temp = target[i+1];
        target[i+1] = target[high];
        target[high] = temp;
        operations++;
        return i+1;
	}
	
	//Recursive algorithm to recursively implement the partitioning algorithm and thus sort the array.
	public void quickSort(int target[], int low, int high) {
		if(low < high) {
			int partitionIndex = partition(target, low, high);
			quickSort(target, low, partitionIndex-1);
			quickSort(target, partitionIndex+1, high);
			iterations += 2;
		}
	}
	
	//Method for printing an array. This particular method sets the counter measuring the operations done per
	//sort to 0 for convenience of measuring new arrays. It will always reset the counter after each sorting as
	//it is called to print the end product.
	public void printArray(int array[]) {
		System.out.print("[");
		for(int j = 0; j < array.length; ++j) {
			System.out.print(array[j]);
			if(j < array.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		operations = 0;
	}

}
