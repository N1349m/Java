public class Heap {
	private int[] array;
	private int length;
	private int parent;
	private int unsortedLength;

	//*************************

	public Heap(int[] array) {
		this.array = array;
		this.length = array.length;
		this.parent = this.length / 2;
		this.unsortedLength = this.length;
	}

	//*************************

	public void heapsort() {
		createHeap();
		sortHeap();
	}

	//*************************

	public void createHeap() {
		for(int i=this.parent; i>0; i--) {
			siftDown(array[--parent]);
		}
	}

	//*************************

	private void sortHeap() {
		while(--unsortedLength > 0) {
			int temp;

			temp = array[0];
			array[0] = array[unsortedLength];
			array[unsortedLength] = temp;

			siftDown(array[0]);
		}
	}

	//*************************

	public void siftDown(int value) {
		int parent = this.parent;
		int child = 2 * parent + 2;

		while (child < unsortedLength) {
			if (array[child] < array[child-1]) {
				child--;
			}

			if (value < array[child]) {
				array[parent] = array[child];
				parent = child;
				child += 1 + parent;
			} else {
				break;
			}
		}

		array[parent] = value;
	}

	//******************************
	public String displayTree() {
		String output = "";
		int length = array.length;
		int row;
		for(row = 0; Math.pow(2, row)<length; row++);
		
		do{
		for (int i = length; i>Math.pow(2, row-1); i--) {
			
		}
		output = ""+row;
		} while (row>0);
		return output;
	}
}
