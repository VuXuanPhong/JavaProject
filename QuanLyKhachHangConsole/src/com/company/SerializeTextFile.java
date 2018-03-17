package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Vu Xuan Phong on 07/05/2017.
 */
public class SerializeTextFile {
    public static Boolean luuFile(ArrayList<KhachHang> khachHangs, String path){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(khachHangs);
            oos.close();
            fos.close();
            return true;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    public static ArrayList<KhachHang> docFile(String path){
        ArrayList<KhachHang> khachHangs = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            khachHangs = (ArrayList<KhachHang>) data;
            return khachHangs;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return khachHangs;
    }
}
