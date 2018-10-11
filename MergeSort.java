package Sorts;

public class MergeSort {

	public static int iterations = 0;
	public static int operations = 0;
	
	public static void main(String[] args) {

		int target1[] = {5,9,23,19,2};
		int target2[] = {104,23,514,235,526,1003};
		int target3[] = {1,2,3,4,5,6,7,8,9,10};
		int target4[] = {10,9,8,7,6,5,4,3,2,1};
		int targetBig[] = {65,83,85,60,8,52,72,15,79,80,97,46,79,51,42,66,4,28,35,33,60,31,67,99,41,42,3,12,37,40,53,7,62,53,61,36,53,53,81,8,82,87,85,29,3,93,11,98,20,56,64,79,70,41,84,9,73,91,14,10,69,96,50,37,3,18,35,38,35,83,33,29,6,59,39,50,10,88,52,6,19,50,24,28,64,86,19,59,24,69,15,91,100,90,71,96,49,65,14,24};
		
		MergeSort demo = new MergeSort();
		
		demo.printArray(target1);
		demo.mergeSort(target1, 0, target1.length-1);
		System.out.println("Iterations to sort: " + iterations);
		System.out.println("Operations to sort: " + operations);
		demo.printArray(target1);
		System.out.println();
		
		demo.printArray(target2);
		demo.mergeSort(target2, 0, target2.length-1);
		System.out.println("Iterations to sort: " + iterations);
		System.out.println("Operations to sort: " + operations);
		demo.printArray(target2);
		System.out.println();
		
		demo.printArray(target3);
		demo.mergeSort(target3, 0, target3.length-1);
		System.out.println("Iterations to sort: " + iterations);
		System.out.println("Operations to sort: " + operations);
		demo.printArray(target3);
		System.out.println();
		
		demo.printArray(target4);
		demo.mergeSort(target4, 0, target4.length-1);
		System.out.println("Iterations to sort: " + iterations);
		System.out.println("Operations to sort: " + operations);
		demo.printArray(target4);
		System.out.println();
		
		demo.printArray(targetBig);
		demo.mergeSort(targetBig, 0, targetBig.length-1);
		System.out.println("Iterations to sort: " + iterations);
		System.out.println("Operations to sort: " + operations);
		demo.printArray(targetBig);
		System.out.println();


	}
	
	
	/*
	 *	 Merge sort is another algorithm that employs the divide and conquer concept, splitting the given array
	 *in half and then merging it. Merging algorithms have a complexity of O(n*log(n)) for every case because of
	 *this, as the merging post split is done in linear time. Aside from the benefits of this increased 
	 *efficiency in comparison to the other algorithms we've explored, merge algorithms can also be easily 
	 *modified to also calculate count inversion (how far an array is from being sorted.) 
	 *
	 *This is also a recursive function but the iteration naming convention continues to stand.
	 */
	
	public void merge(int target[], int left, int middle, int right) {
		
		int n1 = middle - left + 1;
		int n2 = right - middle;
		
		int Left[] = new int [n1];
		int Right[] = new int [n2];
		
		for (int i = 0; i<n1; ++i) {
            Left[i] = target[left + i]; 
		}
        for (int j = 0; j<n2; ++j) {
        	 Right[j] = target[middle + 1 + j];
        }
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) { 
                target[k] = Left[i];
                i++;
                operations++;
            } else { 
                target[k] = Right[j]; 
                j++;
                operations++;
            } 
            k++; 
        }
        
        while (i < n1) { 
            target[k] = Left[i];
            operations++;
            i++; 
            k++;
        }
        
        while (j < n2) { 
            target[k] = Right[j]; 
            operations++;
            j++; 
            k++; 
        }
    }
	
	public void mergeSort(int target[], int left, int right) {
		
		if(left < right) {
			int middle = (left+right)/2;
			mergeSort(target, left, middle); 
            mergeSort(target, middle+1, right); 
            iterations += 2;
            
            merge(target, left, middle, right);
		}
	}
	
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
