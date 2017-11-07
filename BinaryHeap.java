import org.junit.Assert;

public class BinaryHeap implements PriorityQueue{
	private int[] arr;
	private int size;
	
	public BinaryHeap(){
		arr = new int[10];
		arr[0] = Integer.MAX_VALUE;
		size = 0;
	}
	
	private int parent(int n){
		return n/2;
	}
	
	private int leftChild(int n){
		return 2*n;
	}
	
	private int rightChild(int n){
		return 2*n+1;
	}
	
	private void swap(int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
	}
	
	public void add(int n){
		if(size == arr.length-1){
			growHeap();
		}
		arr[size+1] = n;
		int currIndex = size+1;
		while((arr[currIndex]<arr[parent(currIndex)])&&(currIndex>1)){
			swap(currIndex, parent(currIndex));
			currIndex = parent(currIndex);
		}
		size++;
	}
	
	public int remove(){
		Assert.assertFalse("There is an exception, size is 0", (size==0));
		int n = arr[1];
		arr[1] = arr[size];
		int currIndex = 1;
		while(((leftChild(currIndex)<size)||(rightChild(currIndex)<size))&&((arr[currIndex]>arr[leftChild(currIndex)]||(arr[currIndex]>arr[rightChild(currIndex)])))){
			if (arr[leftChild(currIndex)]>arr[rightChild(currIndex)]){
				swap(currIndex,rightChild(currIndex));
				currIndex = rightChild(currIndex);
			}else{
				swap(currIndex,leftChild(currIndex));
				currIndex = leftChild(currIndex);
			}
		}
		size--;
		return n;
	}
	
	private void growHeap(){
		int[] newArray = new int[arr.length*2];
		for(int i = 0; i < arr.length; i++){
			newArray[i] = arr[i];
		}
		arr = newArray;

	}
}
