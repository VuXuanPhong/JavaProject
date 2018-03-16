package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void pintArr(int [] a){
        for (int i = 0; i < a.length;i++){
            System.out.print(a[i]);
        }
    }

    private static void createMenu(){
        System.out.println("Menu: ");
        System.out.println("1. Mã hóa");
        System.out.println("2. Giải mã");
        System.out.println("3. Thoat");
        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();
        switch (choose){
            case 1: maHoa();
                break;
            case 2: giaiMa();
                break;
            case 3:
                System.exit(0);
            default:
                break;
        }
    }

    private static void giaiMa() {
        Aes aesDecode = new Aes();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào đường dẫn file cần giải mã: ");
        String pathDecode = scanner.nextLine();
        System.out.print("Nhập vào khóa cho giải mã: ");
        String key = scanner.nextLine();
        String forDecode = TextIOFile.docFile(pathDecode);
        aesDecode.setListCipher(forDecode);
        aesDecode.setKey(key);
        System.out.println("Nhập vào đường dẫn lưu file giải mã: ");
        String pathdc = scanner.nextLine();
        if (TextIOFile.luuFile(aesDecode.decode(),pathdc)){
            System.out.println("Giải mã thành công...");
        }else System.out.println("Giải mã thất bại!");
    }

    private static void maHoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào đường dẫn File: ");
        String path = scanner.nextLine();
        System.out.print("Nhập vào key cho thuật toán Aes: ");
        String key  = scanner.nextLine();
        String input = TextIOFile.docFile(path);
        if (input==null){
            System.out.println("Đọc file thất bại...");
            return;
        }
        System.out.println("Đọc file thành công!");
        Aes aesEncode = new Aes (input,key);
        aesEncode.createListKey(aesEncode.getCipherkey());
        String s =aesEncode.encode();
        System.out.print("Nhập vào đường dẫn lưu file mã hóa: ");
        String pathSave = scanner.nextLine();
        if (TextIOFile.luuFile(s,pathSave)){
            System.out.println("Mã hóa File thành công!");
        }
        else System.out.println("Mã hóa File thất bại!");
    }

    public static void main(String[] args) {
	// write your code here
        while (true){
            createMenu();
        }

    }
}
