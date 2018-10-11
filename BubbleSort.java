package Sorts;

public class BubbleSort {

	public static void main(String[] args) {
		int target1[] = {5,9,23,19,2};
		int target2[] = {104,23,514,235,526,1003};
		int target3[] = {1,2,3,4,5,6,7,8,9,10};
		int target4[] = {10,9,8,7,6,5,4,3,2,1};
		int targetBig[] = {65,83,85,60,8,52,72,15,79,80,97,46,79,51,42,66,4,28,35,33,60,31,67,99,41,42,3,12,37,40,53,7,62,53,61,36,53,53,81,8,82,87,85,29,3,93,11,98,20,56,64,79,70,41,84,9,73,91,14,10,69,96,50,37,3,18,35,38,35,83,33,29,6,59,39,50,10,88,52,6,19,50,24,28,64,86,19,59,24,69,15,91,100,90,71,96,49,65,14,24};
		
		BubbleSort demo = new BubbleSort();
		
		demo.printArray(target1);
		demo.bubbleSort(target1);
		System.out.println();
		
		demo.printArray(target2);
		demo.bubbleSort(target2);
		System.out.println();
		
		demo.printArray(target3);
		demo.bubbleSort(target3);
		System.out.println();
		
		demo.printArray(target4);
		demo.bubbleSort(target4);
		System.out.println();
		
		demo.printArray(targetBig);
		demo.bubbleSort(targetBig);
		System.out.println();
		
	}
	
	
	/*
	 *	This is, for the sake of a starting point, a very simple unoptimized bubble sort. Bubble sorts naturally 
	 *have an worst (and average) case runtime complexity of O(n^2) as it is performed by nested loops (a nested loop implies 
	 *exponential growth as a loop occurs within each iteration of the outside loop) regardless of the state of 
	 *the array, making it, while simple to code and instructional,very inefficient.
	 */
	
	
	//Standard bubble sorting algorithm. Could be optimised in various ways (i.e., bounding the index search 
	//such that it won't check the highest end of the array after sorting as the highest value is guaranteed 
	//to be correct after an iteration.
	public void bubbleSort(int target[]){
		int iterations = 0;
		int operations = 0;
		for(int i = 0;i < target.length-1 ;i++){
			for(int j = 0; j < target.length - 1; j++) {
				if(target[j] > target[j+1]) {
					int temp = target[j];
					target[j] = target[j+1];
					target[j+1] = temp;
					operations++;
				}
				iterations++;
			}
		}
		printArray(target);
		System.out.println("Iterations to sort: " + iterations);
		System.out.println("Operations to sort: " + operations);
	}
	
	//Standard array printing method.
	public void printArray(int array[]) {
		System.out.print("[");
		for(int j = 0; j < array.length; ++j) {
			System.out.print(array[j]);
			if(j < array.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
