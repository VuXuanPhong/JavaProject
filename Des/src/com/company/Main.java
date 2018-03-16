package com.company;

import java.util.Scanner;

public class Main {
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
        Des desDecode = new Des();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào đường dẫn file cần giải mã: ");
        String pathDecode = scanner.nextLine();
        System.out.print("Nhập vào khóa cho giải mã: ");
        String key = scanner.nextLine();
        String forDecode = TextFileIO.docFile(pathDecode);

        desDecode.setKey(key);
        desDecode.createKey();
        desDecode.setCipher(forDecode);
        desDecode.setListStateForDecode();

        String decode = desDecode.DeCode();
        System.out.println("Nhập đường dẫn lưu file sau giải mã: ");
       String decodePath = scanner.nextLine();
        if (TextFileIO.luuFile(decode,decodePath)){
            System.out.println("Giải mã ra file thành công!");
        }
        else System.out.println("Giải mã thất bại!");
    }

    private static void maHoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào đường dẫn File: ");
        String path = scanner.nextLine();
        System.out.print("Nhập vào key cho thuật toán Des: ");
        String key  = scanner.nextLine();
        String input = TextFileIO.docFile(path);
        if (input==null){
            System.out.println("Đọc file thất bại...");
            return;
        }
        System.out.println("Đọc file thành công!");
        Des desEncode = new Des (input,key);
        desEncode.setListstateIP();
        desEncode.createKey();
        desEncode.Encode();
        String s = desEncode.getCipher();
        System.out.print("Nhập vào đường dẫn lưu file mã hóa: ");
        String pathSave = scanner.nextLine();
        if (TextFileIO.luuFile(s,pathSave)){
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
