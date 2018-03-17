package com.company;

import java.util.Scanner;

public class Main {
    enum Huong{Trai_Phai, Phai_Trai, Tren_Duoi, Duoi_Tren}

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào n: ");
        int n = sc.nextInt();
        int [][]S = new int[n][n];
        NhapArray(S);
        System.out.println("Màn game có dạng: ");
        PrintArray(S);
        int dem = 0;
        int x = 0, y = 0;
        Huong bd = Huong.Trai_Phai;
        while (true){
            if(x < 0 || y< 0|| x> S.length-1 || y > S.length - 1){
                System.out.println("Số lần phản xạ: "+ dem);
                break;
            }
            if (S[x][y]==1){
                bd = DuyetHuong(bd,1);
                dem++;

            }
            if (S[x][y]==2){
                bd = DuyetHuong(bd,2);
                dem++;
            }
            if (bd == Huong.Duoi_Tren){
                x--;
            }

            if (bd == Huong.Tren_Duoi){
                x++;
            }

            if (bd == Huong.Phai_Trai){
                  y--;
            }

            else if (bd == Huong.Trai_Phai){
                y++;

            }
        }


    }
    static Huong DuyetHuong(Huong Bd,int n){
        if (Bd == Huong.Duoi_Tren){
            if (n==1) return Huong.Trai_Phai;
            else if (n==2) return Huong.Phai_Trai;
        }

        if (Bd == Huong.Tren_Duoi){
            if (n==1) return Huong.Phai_Trai;
            else if (n==2) return Huong.Trai_Phai;
        }

        if (Bd == Huong.Phai_Trai){
            if (n==1) return Huong.Tren_Duoi;
            else if (n==2) return Huong.Duoi_Tren;
        }

        if (Bd == Huong.Trai_Phai){
            if (n==1) return Huong.Duoi_Tren;
            else if (n==2) return Huong.Tren_Duoi;
        }
        return null;
    }
    public static void PrintArray(int [][]A){
        for(int i=0;i<A.length;i++){
            for(int j=0; j < A[0].length;j++){
                System.out.print(A[i][j]+" ");
                if (j == A[0].length-1){
                    System.out.println();
                }
            }
        }
    }
    static void NhapArray(int [][]A){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<A.length;i++){
            System.out.println("Nhập vào hàng thứ "+ (i+1));
            for(int j=0; j < A[0].length;j++){
                System.out.println("Nhập vào phần tử thứ " + (j+1));
                A[i][j] = sc.nextInt();
            }
        }
    }
}
