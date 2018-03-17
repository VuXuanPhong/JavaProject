package com.company;

import java.util.Date;
import java.util.Scanner;

public class Main {
    static  boolean NamNhuan(int nam){
        if(nam %400 == 0) return true;
        if (nam % 100 == 0) return false;
        if ( nam % 4 == 0) return true;
        return false;
    }

    static int SoNgayLonNhatTrongThang(int nam, int thang){
        if(thang == 2) {
            if(NamNhuan(nam)== true) return 29;
            else  return 28;
        }
        if(thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10|| thang == 12){
            return 31;
        }
        return 30;
    }
    static boolean KiemTraNgayThang(int Ngay, int Thang, int Nam){
        if(Thang ==2) {
            if(NamNhuan(Nam)==true){
                if(Ngay >0 && Ngay < 30) return true;
                return  false;
            }
            else {
                if(Ngay >0 && Ngay < 29) return  true;
                return false;
            }
        }
        if(Thang == 1 || Thang == 3 || Thang == 5 || Thang == 7 || Thang == 8 || Thang == 10 || Thang == 12 ){
            if(Ngay>0 && Ngay < 32) return true;
            return false;
        }
        else if (Thang == 2 || Thang == 4 || Thang == 6 || Thang == 9 || Thang == 11 ){
            if(Ngay > 0 && Ngay < 31) return true;
            return false;
        }
        else return false;
    }

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int NgaySinh = 0;
        int ThangSinh = 0;
        int NamSinh = 0;
        while (true){
            System.out.println("Nhập vào ngày sinh của bạn : ");
            NgaySinh = sc.nextInt();
            System.out.println("Nhập vào tháng sinh của bạn : ");
            ThangSinh = sc.nextInt();
            System.out.println("Nhập vào năm sinh của bạn : ");
            NamSinh = sc.nextInt();

            if (KiemTraNgayThang(NgaySinh,ThangSinh,NamSinh)==false) {
                System.out.println("Ngay, Thang, Nam ban nhap khong hop le.");
                continue;
            }
            break;
        }
        System.out.println(NgaySinh +" " + ThangSinh+" " + NamSinh);
        Date date = new Date();
        int NgayHienTai =  date.getDay();
        int ThangHienTai = date.getMonth();
        int NamHienTai = date.getYear();
        System.out.println(NgayHienTai + " "+ ThangHienTai + " " + NamHienTai);
        int Count = 0;
        while (true){
            if (NgaySinh == NgayHienTai && NamSinh == NamHienTai && ThangSinh == ThangHienTai) break;
            NgaySinh ++;
            Count++;
            if (NgaySinh > SoNgayLonNhatTrongThang(NamSinh,ThangSinh)){
                NgaySinh = 1;
                ThangSinh++;
                if (ThangSinh > 12) {
                    ThangSinh = 1;
                    NamSinh ++;
                }
            }
        }

        System.out.println("So Ngay can tinh : " + Count);

    }
}
