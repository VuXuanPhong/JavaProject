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
public class MergeSort extends Thread{
    int array[];
    public long timeMillis;
    
    MergeSort(int Array[]){
        this.array = Array;
    }

    @Override
    public void run() {
        long startTime=System.currentTimeMillis();
        Merge_Sort(0,array.length-1);
        timeMillis=System.currentTimeMillis()-startTime;
        System.out.println("Sorting in :"+ timeMillis+ " millis seconds");
//        for(int i=0; i < array.length;i++){
//            System.out.print(array[i]+" ");
//        }
    }
    public void Merge (int p, int q, int r){
	int szLeft = q - p + 1;
	int szRight = r - q;
	
        int temp1[] = new int[szLeft];
        int temp2[] = new int[szRight];

	for (int i = 0; i < szLeft; i++){
		temp1[i] = array[p+i];
	}

	for (int j = q+1; j < r+1; j++){
		temp2[j-q-1] = array[j];
	}
	int pL = 0;
	int pR = 0;
	for (int i = p; i < r+1; i++){
		if (temp1[pL] <= temp2[pR]){
			array[i] = temp1[pL];
			pL++;
			if (pL >= szLeft){
				int k = i+1;
				for (int j = pL; j < szRight; j++){
					array[k] = temp2[j];
					k++;
				}
				break;
			}

		}
		else
		{
			array[i] = temp2[pR];
			pR++;
			if (pR >= szRight){
				int k = i+1;
				for (int j = pL; j < szLeft; j++){
					array[k] = temp1[j];
					k++;
		
				}

				break;
			}
		}
	}
}

    public void Merge_Sort(int p, int r){
	if (p < r){
		int q = (r + p) / 2;
		Merge_Sort( p, q);
		Merge_Sort( q + 1, r);
		Merge( p, q, r);
	}
    }
    
}
