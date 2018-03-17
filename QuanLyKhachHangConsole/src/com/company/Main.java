package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<KhachHang> khachHangs = new ArrayList<>();
    private static void createMenu(){
        System.out.println("Menu: ");
        System.out.println("1.Nhap Khach Hang.");
        System.out.println("2.Xuat Danh Sach Khach Hang.");
        System.out.println("3.Tim Kiem Khach Hang");
        System.out.println("4.Sap Xep Khach Hang");
        System.out.println("5.Luu Danh Sach Khach Hang");
        System.out.println("6.Doc Danh Sach Khach Hang");
        System.out.println("7.Thong Ke Khach Hang Theo Nha Mang");
        System.out.println("8.Exit");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        switch (choose){
            case 1:
                xuLyNhap();
                break;
            case 2:
                xuLyXuat();
                break;
            case 3:
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhap vao so dien thoai can tim kiem :");
                String s = sc.nextLine();
                xuLyTimKiem(s);
                break;
            case 4:
                xulySapXep();
                break;
            case 5:
                xulyLuu();
                break;
            case 6:
                xulyDoc();
                break;
            case 7:
                xuLyThongKe();
                break;
            case 8:
                xuLyThoat();
                break;
            default:
                break;
        }


    }

    private static void xuLyThoat() {
        System.out.println("Bye bye !!!");
        System.exit(0);
    }

    private static void xuLyThongKe() {
    }

    private static void xulyDoc() {
        khachHangs = SerializeTextFile.docFile("E:\\khachHang.txt");
        System.out.println("Doc Thanh Cong");
    }

    private static   void xulyLuu() {
        Boolean check = SerializeTextFile.luuFile(khachHangs, "E:\\khachHang.txt");
        if (check){
            System.out.println("Luu Thanh Cong");
        }
        else System.out.println("Luu That Bai");
    }

    private static void xulySapXep() {
        Collections.sort(khachHangs);
        System.out.println("Đã sắp xếp");
    }

    private static void xuLyTimKiem(String s) {
        for (KhachHang khachHang : khachHangs){
            if (khachHang.getPhone().contains(s)){
                System.out.println("==================================");
                System.out.println(khachHang);
                System.out.println("==================================");
            }
        }
    }

    private static void xuLyXuat() {
        System.out.println("=========================================");
        for (KhachHang khachHang: khachHangs){
            System.out.println(khachHang);
        }
        System.out.println("=========================================");
    }


    private static void xuLyNhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao thong tin Khach Hang :");
        System.out.print("Nhap vao ma khách hang : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhap vao ten khach hang: ");
        String name = scanner.nextLine();
        System.out.print("Nhap vao so dien thoai : ");
        String phone = scanner.nextLine();
        KhachHang khachHang = new KhachHang(id, name, phone);
        khachHangs.add(khachHang);
    }

    public static void main(String[] args) {
	// write your code here
        while (true){
            createMenu();
        }
    }
}
