import java.io.File;
import java.util.Scanner;

public class Algorithm {
	private int mergeSort = 0;
	private int quickSort = 0;
	
	public static void main(String[] args) {
		Algorithm algorithm = new Algorithm();
		
		int n = 2048;
		int n2 = n * n;
		double nlog2n = n * (Math.log(n) / Math.log(2));
		
		System.out.println(n);
		System.out.println(n2);
		System.out.println(nlog2n);
		System.out.println();
		
		String[] UnsortedArray = {"baseball", "football","basketball", "golf"};
		
		System.out.println("Unsorted Array: ");
		for (String s : UnsortedArray) {
			System.out.println(s + " ");
		}
		System.out.println();
		
		algorithm.quickSort = 0;
		algorithm.quicksorti(UnsortedArray, 0, UnsortedArray.length - 1);
		
		System.out.println("Sorted Array: ");
		for (String s : UnsortedArray) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		System.out.println("QuickSort Comparisons with Array: " + algorithm.quickSort);
	
		
		String filename = "random.txt";
		int[] randomNumbers = algorithm.readNumbers(filename, n);
		
		int[] mergeSortNumbers = randomNumbers.clone();
		int[] quickSortNumbers = randomNumbers.clone();
		
		algorithm.mergeSort = 0;
		algorithm.mergeSorti(mergeSortNumbers, 0, mergeSortNumbers.length - 1);
		System.out.println("MergeSort Unsorted: " + algorithm.mergeSort);
		
		algorithm.mergeSort = 0;
		algorithm.mergeSorti(mergeSortNumbers, 0, mergeSortNumbers.length - 1);
		System.out.println("MergeSort Sorted: " + algorithm.mergeSort);
	}
		
	
	public int[] readNumbers(String filename, int n) {
		int[] randomNumbers = new int[n];
		try {
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			int index = 0;
			
			while (scanner.hasNextInt() && index < n) {
				randomNumbers[index] = scanner.nextInt();
				index++;
			}
			
			scanner.close();
			return randomNumbers;
			
		}
		
		catch (Exception e) {
			System.err.println("Error");
			return null;
		}
	}
	
	public void mergeSorti(int [] data, int min, int max) {
		if (min < max) {
			int mid = (min+ max) / 2;
			mergeSorti(data, min, mid);
			mergeSorti(data, mid + 1, max);
			mergei(data, min, mid, max);
		}
	}
	
	public void mergei(int[] data, int first, int mid, int last) {
		int[] temp = new int[data.length];
		int first1 = first;
		int last1 = mid;
		int first2 = mid + 1;
		int last2 = last;
		int index = first1;
		
		while (first1 <= last1 && first2 <= last2) {
			
			if (data[first1] < data[first2]) {
				temp[index] = data[first1];
				first1++;
			}
			else {
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		
		while (first1 <= last1) {
			temp[index] = data[first1];
			first1++;
			index++;
		}
		while (first2 <= last2) {
			temp[index] = data[first2];
			first2++;
			index++;
		}
		
		for (index = first; index <= last; index++) {
			data[index] = temp[index];
		}
		
	}
	
	public void quicksorti(Comparable[] data, int min, int max) {
		if (min < max) {
			int pivot = partitioni(data, min, max);
				
			quicksorti(data, pivot + 1, max);
			quicksorti(data, min, pivot - 1);
			}
		}
	private void swapi(Comparable[] data, int index1, int index2) {
		Comparable temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	private int partitioni(Comparable[] data, int min, int max) {
		Comparable pivot = data[min];
		int left = min;
		int right = max;
		
		while (left < right) {
			
			while(data[left].compareTo(pivot) <= 0 && left < right) {
				left++;
			}
			
			while (data[right].compareTo(pivot) > 0) {
				right--;
			}
			
			if (left < right) {
				swapi(data, left, right);
			}
		}
		
		swapi(data, min, right);
		
		return right;
		
	}
}
