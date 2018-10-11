package Sorts;

public class SelectionSort {

	public static void main(String[] args) {
		int target1[] = {5,9,23,19,2};
		int target2[] = {104,23,514,235,526,1003};
		int target3[] = {1,2,3,4,5,6,7,8,9,10};
		int target4[] = {10,9,8,7,6,5,4,3,2,1};
		int targetBig[] = {65,83,85,60,8,52,72,15,79,80,97,46,79,51,42,66,4,28,35,33,60,31,67,99,41,42,3,12,37,40,53,7,62,53,61,36,53,53,81,8,82,87,85,29,3,93,11,98,20,56,64,79,70,41,84,9,73,91,14,10,69,96,50,37,3,18,35,38,35,83,33,29,6,59,39,50,10,88,52,6,19,50,24,28,64,86,19,59,24,69,15,91,100,90,71,96,49,65,14,24};
		//Implement some larger arrays ordered descending to demonstrate the quadratic increase
		//in runtime.
		
		SelectionSort demo = new SelectionSort();
		
		demo.printArray(target1);
		demo.selectionSort(target1);
		System.out.println();
		
		demo.printArray(target2);
		demo.selectionSort(target2);
		System.out.println();
		
		demo.printArray(target3);
		demo.selectionSort(target3);
		System.out.println();
		
		demo.printArray(target4);
		demo.selectionSort(target4);
		System.out.println();
		
		demo.printArray(targetBig);
		demo.selectionSort(targetBig);
		System.out.println();
	}
	
	/*
	 *	Selection sorts, like bubble sorts, also have an inefficient runtime complexity of O(n^2), due to the
	 *existence of the nested loop. However, the value of this algorithm is that it will never perform more than 
	 *O(n) operations (operations defined as integer swaps in all cases in this discussion) which makes it useful 
	 *in situations when writing memory is a costly operation. This specific construction of the algorithm is 
	 *unstable, but is suitable enough for our purposes.
	 */
	
	//Selection sort algortithm. Searches the array for the lowest value, then places it in the array in front of
	//the last value sorted (which will, by virtue of the algorithm, be in the proper place already.)
	public void selectionSort(int target[]){
		int iterations = 0;
		int operations = 0;
		for(int i = 0;i < target.length-1;i++) {
			int minVal = i;
			for(int j = i+1;j < target.length;j++) {
				if(target[j] < target[minVal]){
					minVal = j;
					iterations++;
					operations++;
				}
				
			}
			int temp = target[minVal];
            target[minVal] = target[i];
            target[i] = temp;
            iterations++;
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
