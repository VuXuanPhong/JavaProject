package com.company;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Vu Xuan Phong on 13/05/2017.
 */
public class TextFileIO {
    public static Boolean luuFile(String Decodes, String path){
        try{
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(Decodes);
            bw.close();
            osw.close();
            fos.close();
            return true;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    public static String docFile(String path){
        StringBuilder sBPlantext = new StringBuilder();
        try{
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null){
                sBPlantext.append(line);
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
            return sBPlantext.toString();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
