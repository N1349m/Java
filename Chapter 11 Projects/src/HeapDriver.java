
public class HeapDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {40, 26, 82, 69, 16, 67, 34, 58, 11, 23, 91, 72};
		//int[] array = {2, 1, 4, 3};
		Heap heap = new Heap(array);
		
		System.out.println("\noriginal array");
		display(array);
		
		heap.createHeap();
		
		System.out.println("\n\nheap");
		display(array);
		
		System.out.println("\nheap as tree:");
		System.out.println(heap.displayTree());
		
		heap.heapsort();
		
		System.out.println("\n\nsorted array");
		display(array);
		
	}

	//****************************************
	
	private static void display(int[] array) {
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
