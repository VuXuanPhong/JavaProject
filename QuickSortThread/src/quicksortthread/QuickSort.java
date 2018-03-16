/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksortthread;

/**
 *
 * @author Vu Xuan Phong
 */
public class QuickSort extends Thread {
    int array[];
    public long timeMillis;
    //private boolean isSorted = false;
    QuickSort(int Array []){
        this.array = Array;
    }
    
    @Override
    public void run() {
        long startTime=System.currentTimeMillis();
        quickSort(0,array.length-1);
        timeMillis=System.currentTimeMillis()-startTime;
        System.out.println("Sorting in :"+ timeMillis+ " millis seconds");
        
//        for(int i=0; i < array.length;i++){
//            System.out.print(array[i]+" ");
//        }
    }
    
public void swap(int i, int j){
	int temp = array[i];
        array[i] = array[j];
	array[j] = temp;
}

private int findPivot( int left, int right){
	int midle = (left + right) / 2;
	int a[] = new int[3];
	
        a[0] = array[left];
	a[1] = array[midle];
	a[2] = array[right];

	for (int i = 0; i < 2; i++){
		for (int j = i+1; j < 3; j++){
			if (a[i] > a[j]){
                            int temp = a[i];
                            a[i] = a[j];
                            a[j] = temp;
			}
		}
	}
        
        int pivot = left;
        if(array[midle]==a[1]) pivot = midle;
        else if(array[right]==a[1]) pivot = right;
        return pivot;
}

private int part(int left, int right, int x){
	int i = left, j = right;
	while (i<=j)
	{
		while (array[i] < x) i++;
		while (array[j] > x) j--;
		if (i <= j) {
			swap(i, j);
			i++;
			j--;
		}
	}
	return i;
}

private void quickSort( int left, int right){
	if (right - left == 0) return;
	if (right - left == 1){
		if (array[left] > array[right]) swap(left, right);
		return;
	}
	if (left < right){
		int pivot = findPivot(left, right);
		int x = array[pivot];
		swap(pivot, right);
		int k = part( left, right-1, x);
		swap(k, right);

		quickSort(left, k - 1);
		quickSort(k+1, right);
	}
        
}

    
}
