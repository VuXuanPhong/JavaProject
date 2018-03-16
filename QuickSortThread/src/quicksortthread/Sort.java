/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksortthread;

import java.util.Random;

/**
 *
 * @author Vu Xuan Phong
 */
public class Sort {
    public static void main(String [] args){
        System.out.println("Hello : ))");
        int a[] = new int[120000000];
        for(int i =0; i < 120000000; i++){
            Random rd = new Random();
            a[i] = rd.nextInt();
        }
//        MergeSort merge = new MergeSort(a);
//        merge.start();
        
        QuickSort quick = new QuickSort(a);
        quick.start();
    }
}
