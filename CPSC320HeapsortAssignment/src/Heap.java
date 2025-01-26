/**
 * 
 * @author https://java2blog.com/heap-sort-in-java/
 */
public class Heap {
	
	private int counter;
	
	/**
	 * Last non leaf node will be at (arr.length-1)/2
	 * so we will start from this location for heapifying the elements */
	public void buildheap(int []arr) {
		
		for(int i = (arr.length-1)/2; i>=0; i--) {
			heapify(arr,i,arr.length-1);
			counter++;
		}
	}
	
	public void heapify(int[] arr, int i, int size) {
		int lChild = 2 * i + 1;
		int rChild = 2 * i + 2;
		int max;
		if (lChild <= size && arr[lChild] > arr[i]) {
			max = lChild;
		} else {
			max = i;
		}
		
		if (rChild <= size && arr[rChild] > arr[max]) {
			max = rChild;
		}
		
		// If max is not current node, exchange it with max of lChild and rChild
		if (max != i) {
			swap(arr, i, max);
			heapify(arr, max, size);
		}
		
	}
	
	void swap(int [] arr, int i, int j) {
		counter++;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/** Get the sorted list from a max heap */
	public int [] heapSort(int[] arr) {
		counter = 0;
		buildheap(arr);
		int sizeOfHeap = arr.length-1;
		for(int i = sizeOfHeap; i > 0; i--) {
			swap(arr, 0, i);
			sizeOfHeap = sizeOfHeap - 1;
			heapify(arr, 0, sizeOfHeap);
		}
		System.out.println("Counter value: " + counter);
		return arr;
	}
	
	public static void main(String [] args) {
		Heap h = new Heap();
		int [] arr = {97,77,66,61,46,42,40,30,25,24,15,13,12,10,7,0};
		int [] sorted = h.heapSort(arr);
		for (int i : sorted) {
			System.out.print(i + " ");
		}
	}

}
