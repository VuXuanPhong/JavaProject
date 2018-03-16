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
public class Merge {

    public static int[] Merge(int []B, int left, int midle, int right){
        int pL = left;
        int pR = midle+1;
        int temp[] = new int[right-left+1];
        int i =0;
        while((pL<=midle)&&(pR<= right)){
            if(B[pL] <= B[pR]) {
                temp[i] = B[pL];
                i++;
                pL++;
            }
            else{
                temp[i] = B[pR];
                i++;
                pR++;
            }
        }
        
        while(pL <= midle) {
            temp[i] = B[pL];
            i++;
            pL++;
        }
        
        while(pR <= right) {
            temp[i] = B[pR];
            i++;
            pR++;
        }
        
        return temp;
    }
}
