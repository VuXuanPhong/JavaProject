
package com.company;

import java.util.ArrayList;

/**
 * Created by hope on 16/05/2017.
 */
public class Aes {
    private static final int[]b= {1,1,0,1,1,0,0,0};

    private static final String[][] ivSubbox = {
            {"52","09","6A","D5","30","36","A5","38","BF","40","A3","9E","81","F3","D7","FB"},
            {"7C","E3","39","82","9b","2f","ff","87","34","8e","43","44","c4","de","e9","cb"},
            {"54","7b","94","32","a6","c2","23","3d","ee","4c","95","0b","42","fa","c3","4e"},
            {"08","2e","a1","66","28","d9","24","b2","76","5b","a2","49","6d","8b","d1","25"},
            {"72","f8","f6","64","86","68","98","16","d4","a4","5c","cc","5d","65","b6","92"},
            {"6c","70","48","50","fd","ed","b9","da","5e","15","46","57","a7","8d","9d","84"},
            {"90","d8","ab","00","8c","bc","d3","0a","f7","e4","58","05","b8","b3","45","06"},
            {"d0","2c","1e","8f","ca","3f","0f","02","c1","af","bd","03","01","13","8a","6b"},
            {"3a","91","11","41","4f","67","dc","ea","97","f2","cf","ce","f0","b4","e6","73"},
            {"96","ac","74","22","e7","ad","35","85","e2","f9","37","e8","1c","75","df","6e"},
            {"47","f1","1a","71","1d","29","c5","89","6f","b7","62","0e","aa","18","be","1b"},
            {"fc","56","3e","4b","c6","d2","79","20","9a","db","c0","fe","78","cd","5a","f4"},
            {"1f","dd","a8","33","88","07","c7","31","b1","12","10","59","27","80","ec","5f"},
            {"60","51","7f","a9","19","b5","4a","0d","2d","e5","7a","9f","93","c9","9c","ef"},
            {"a0","e0","3b","4d","ae","2a","f5","b0","c8","eb","bb","3c","83","53","99","61"},
            {"17","2b","04","7e","ba","77","d6","26","e1","69","14","63","55","21","0c","7d"}
    };
    private static final String[][] subBox= {
            {"63","7c","77","7b","f2","6b","6f","c5","30","01","67","2b","fe","d7","ab","76"},
            {"ca","82","c9","7d","fa","59","47","f0","ad","d4","a2","af","9c","a4","72","c0"},
            {"b7","fd","93","26","36","3f","f7","cc","34","a5","e5","f1","71","d8","31","15"},
            {"04","c7","23","c3","18","96","05","9a","07","12","80","e2","eb","27","b2","75"},
            {"09","83","2c","1a","1b","6e","5a","a0","52","3b","d6","b3","29","e3","2f","84"},
            {"53","d1","00","ed","20","fc","b1","5b","6a","cb","be","39","4a","4c","58","cf"},
            {"d0","ef","aa","fb","43","4d","33","85","45","f9","02","7f","50","3c","9f","a8"},
            {"51","a3","40","8f","92","9d","38","f5","bc","b6","da","21","10","ff","f3","d2"},
            {"cd","0c","13","ec","5f","97","44","17","c4","a7","7e","3d","64","5d","19","73"},
            {"60","81","4f","dc","22","2a","90","88","46","ee","b8","14","de","5e","0b","db"},
            {"e0","32","3a","0a","49","06","24","5c","c2","d3","ac","62","91","95","e4","79"},
            {"e7","c8","37","6d","8d","d5","4e","a9","6c","56","f4","ea","65","7a","ae","08"},
            {"ba","78","25","2e","1c","a6","b4","c6","e8","dd","74","1f","4b","bd","8b","8a"},
            {"70","3e","b5","66","48","03","f6","0e","61","35","57","b9","86","c1","1d","9e"},
            {"e1","f8","98","11","69","d9","8e","94","9b","1e","87","e9","ce","55","28","df"},
            {"8c","a1","89","0d","bf","e6","42","68","41","99","2d","0f","b0","54","bb","16"}
    };
    private static final int[][] invshiftRow = {
            {0,1,2,3},
            {7,4,5,6},
            {10,11,8,9},
            {13,14,15,12}
    };

    private static final int[][] shiftRow = {
            {0,1,2,3},
            {5,6,7,4},
            {10,11,8,9},
            {15,12,13,14}
    };
    private static final int[][] mixColumn={
            {2,3,1,1},
            {1,2,3,1},
            {1,1,2,3},
            {3,1,1,2}
    };
    private static final int[][] invMixColumn={
            {14,11,13,9},
            {9,14,11,13},
            {13,9,14,11},
            {11,13,9,14}
    };
    private static final int[][] forKey={
            {0,1,2,7},
            {4,5,6,11},
            {8,9,10,15},
            {12,13,14,3}
    };
    private static final int[] Rcon1 = {1,0,0,0};
    private static final int[] Rcon2 = {2,0,0,0};
    private static final int[] Rcon3 = {4,0,0,0};
    private static final int[] Rcon4 = {8,0,0,0};
    private static final int[] Rcon5 = {16,0,0,0};
    private static final int[] Rcon6 = {32,0,0,0};
    private static final int[] Rcon7 = {64,0,0,0};
    private static final int[] Rcon8 = {128,0,0,0};
    private static final int[] Rcon9 = {27,0,0,0};
    private static final int[] Rcon10 = {54,0,0,0};

    private static final ArrayList<int[]> listRcon = new ArrayList<>();
    private String plan;
    private String cipher;
    private String key;
    private int[][] cipherkey = new int[4][4];
    private ArrayList<int[][]> listPLan = new ArrayList<>();
    private ArrayList<int[][]> listKey = new ArrayList<>();
    private ArrayList<int[][]> listCipher = new ArrayList<>();

    public Aes(String plan, String key) {
        this.plan = editInput(plan);
        this.key = editKey(key);
        cipherkey = toState(this.key);
        String[] arrPLan = inputToArray(this.plan);
        for (int i=0;i< arrPLan.length;i++){
            listPLan.add(toState(arrPLan[i]));
        }
        listRcon.add(Rcon1);
        listRcon.add(Rcon2);
        listRcon.add(Rcon3);
        listRcon.add(Rcon4);
        listRcon.add(Rcon5);
        listRcon.add(Rcon6);
        listRcon.add(Rcon7);
        listRcon.add(Rcon8);
        listRcon.add(Rcon9);
        listRcon.add(Rcon10);
    }

    public String getPlan() {
        return plan;
    }

    public void setListCipher(String cipher) {
        ArrayList<int[][]> listCipher = new ArrayList<>();
        String[] cc = inputToArray(cipher);
        for (int i = 0;i < cc.length;i++){
            listCipher.add(toState(cc[i]));
        }
        this.listCipher = listCipher;
    }

    public void setPlan(String plan) {
        this.plan = editInput(plan);
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }


    public void setKey(String key) {
        this.key = editKey(key);
        cipherkey = toState(this.key);
        createListKey(cipherkey);

    }
    private String editInput(String input){
        while (input.length()%16!=0){
            input+="!";
        }
        return input;
    }
    private String editKey(String key){
        if (key.length()>16){
            String s="" ;
            for (int i =0 ;i <16;i++){
                s+=key.charAt(i);
            }
            return s;
        }
        else return editInput(key);
    }
    private int[] toHex(int dec){
        int [] hex = new int[2];
        hex[0] = dec/16;
        hex[1] = dec%16;
        return hex;
    }

    public Aes() {
        listRcon.add(Rcon1);
        listRcon.add(Rcon2);
        listRcon.add(Rcon3);
        listRcon.add(Rcon4);
        listRcon.add(Rcon5);
        listRcon.add(Rcon6);
        listRcon.add(Rcon7);
        listRcon.add(Rcon8);
        listRcon.add(Rcon9);
        listRcon.add(Rcon10);
    }

    public String[] inputToArray(String input){
        String [] toReturn = new String[input.length()/16];
        for (int i = 0 ; i < input.length()/16;i++){
            toReturn[i] = input.substring(16*i,16*i+16);
        }
        return toReturn;
    }
    public int[][] toState(String s){
        int [][] toReturn = new int[4][4];
        for (int i = 0; i < 4;i++){
            for (int j = 0; j < 4 ; j ++){
                toReturn[i][j] = s.charAt(i*4+j);
                if (j==3) break;
            }
        }
        return toReturn;
    }

    public static void printState(int [][] x){
        for (int i = 0 ; i < x.length;i++){
            for (int j = 0 ; j < x[0].length;j++){
                System.out.print(x[i][j]+" ");
                if (j==x[0].length - 1) System.out.println();
            }
        }
        System.out.println();
    }
    private int [][] subByte(int [][] tosub, String[][] subbox){
        int [][] toReturn  = new int[tosub.length][tosub[0].length];
        for (int i = 0 ; i < tosub.length;i++){
            for (int j = 0 ;j < tosub[0].length;j++){
                int []a = toHex(tosub[i][j]);
                toReturn[i][j] = Integer.parseInt(subbox[a[0]][a[1]],16);
            }
        }
        return toReturn;
    }
    public int [][] testSubByte(int [][] toSub){
        return subByte(toSub,subBox);
    }

    public int [][] testinvSubByte(int [][] toSub){
        return subByte(toSub,ivSubbox);
    }

    public int[][] shiftRow(int[][] toShiftRow, int[][] shiftBox){
        int [][] toReturn = new int[toShiftRow.length][toShiftRow[0].length];
        for (int i=0;i<toShiftRow.length;i++){
            for (int j=0;j<toShiftRow[0].length;j++){
                int x = shiftBox[i][j];
                int a = x/4;
                int b = x%4;
                toReturn[i][j] = toShiftRow[a][b];
            }
        }
        return toReturn;
    }
    public int[][] textShiftRow(int [][] toShiftRow){
        return shiftRow(toShiftRow,shiftRow);
    }
    public int[][] textinvShiftRow(int [][] toinvShiftRow){
        return shiftRow(toinvShiftRow,invshiftRow);
    }

    public int[] mul2(int [] abyte){
        int[] toReturn = new int[abyte.length];
        toReturn[7] = abyte[6];
        toReturn[6] = abyte[5];
        toReturn[5] = abyte[4];
        toReturn[4] = abyte[3];
        toReturn[3] = abyte[2];
        toReturn[2] = abyte[1];
        toReturn[1] = abyte[0];
        toReturn[0] = 0;
        if (abyte[7]==1) return xor(toReturn,b);
        else return toReturn;
    }

    public int[]xor(int [] a, int []b){
        int []toReturn  = new int[8];
        for (int i =0;i<8;i++){
            if (a[i]==b[i]){
                toReturn[i]=0;
            }
            else toReturn[i]=1;
        }
        return toReturn;
    }

    public static int getListRcon() {
        return listRcon.size();
    }

    public static void pintArr(int [] a){
        for (int i = 0; i < a.length;i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }
    public int[] mulx(int[] a, int x){
        int[] toReturn = new int[8];
        switch (x){
            case 1:
                toReturn= a;
                break;
            case 2:
                toReturn = mul2(a);
                break;
            case 3:
                int [] temp = mul2(a);
                toReturn = xor(temp,a);
                break;
            case 9:
                int[] temp1 = mul2(a);
                 temp1 = mul2(temp1);
                temp1 = mul2(temp1);
                toReturn = xor(temp1,a);

                break;
            case 11:
                int []temp2 = mul2(a);
                temp2 = mul2(temp2);
                 temp2 = xor(temp2,a);
                 temp2 = mul2(temp2);
                toReturn = xor(temp2,a);
                break;
            case 13:
                int[] temp3 = mul2(a);
                temp3 = xor(temp3,a);
                temp3 = mul2(temp3);
                temp3 = mul2(temp3);
                toReturn = xor(temp3,a);
                break;
            case 14:
                int []temp4 =  mul2(a);
                temp4 = xor(temp4,a);
                temp4 = mul2(temp4);
                temp4 =xor(temp4,a);
                toReturn = mul2(temp4);
                break;
            default:
                toReturn = null;
                break;
        }

        return toReturn;
    }

    public int[] toBinary(int dec){
        int [] toBinary  = new int[8];
        for(int i = 0; i < 8;i++){
            toBinary[i] = dec%2;
            dec=dec/2;
        }
        return toBinary;
    }

    public int[][] getCipherkey() {
        return cipherkey;
    }

    public int toDec(int []a){
        return a[0]+a[1]*2+a[2]*4+a[3]*8+a[4]*16+a[5]*32+a[6]*64+a[7]*128;
    }
    private int[][] mixColumn(int [][] toMix, int[][] mixBox){
        int [][] toReturn = new int[4][4];
        for (int j = 0; j < 4 ; j ++) {
            for (int i = 0; i < 4; i++) {
                int[] a1 = mulx(toBinary(toMix[0][j]), mixBox[i][0]);
                int[] a2 = mulx(toBinary(toMix[1][j]), mixBox[i][1]);
                int[] a3 = mulx(toBinary(toMix[2][j]), mixBox[i][2]);
                int[] a4 = mulx(toBinary(toMix[3][j]), mixBox[i][3]);
                int[] a12 = xor(a1, a2);
                int[] a34 = xor(a3, a4);
                int[] a = xor(a12, a34);
                toReturn[i][j]= toDec(a);
            }
        }
        return toReturn;
    }


    public int[][] testMix(int [][] toMix){
        return mixColumn(toMix,mixColumn);
    }

    public int[][] testinvMix(int [][] toMix){
        return mixColumn(toMix,invMixColumn);
    }
    public int subADec(int dec){
        int []a = toHex(dec);
        String s = subBox[a[0]][a[1]];
        return Integer.parseInt(s,16);
    }
    private int [][]createKey(int [][] cipher, int i){
        int [][] toReturn  = new int[4][4];
        int [] columnFinal = new int[4];
        columnFinal[0] = cipher[1][3];
        columnFinal[1] = cipher[2][3];
        columnFinal[2] = cipher[3][3];
        columnFinal[3] =cipher[0][3];
        columnFinal[0] = subADec(columnFinal[0]);
        columnFinal[1] = subADec(columnFinal[1]);
        columnFinal[2] = subADec(columnFinal[2]);
        columnFinal[3] = subADec(columnFinal[3]);
        for (int j = 0 ; j < 4 ; j ++){
            for (int k = 0 ; k < 4 ; k ++){
                int []a = toBinary(cipher[k][j]);
                int []b = toBinary(columnFinal[k]);
                int []c = toBinary(listRcon.get(i)[k]);
                if (j ==0){
                    int []d = xor(a,b);
                    int x = toDec(xor(c,d));
                    columnFinal[k] = x;
                    toReturn[k][0] = x;
                } else {
                    int y = toDec(xor(a,b));
                    columnFinal[k] = y;
                    toReturn[k][j] = y;
                }
            }
        }
        return toReturn;
    }
    public void  createListKey(int [][] cipher){
        for (int i = 0 ; i < 10 ; i ++ ){
            int [][] keySmall = createKey(cipher,i);
            //printState(keySmall);
            listKey.add(keySmall);
            cipher = keySmall;
        }
    }
    public int[][] addRoundKey(int [][] toAdd, int [][] keySmall){
        int [][] toReturn = new int[4][4];
        for (int i = 0 ; i < 4; i ++){
            for (int j = 0 ; j < 4 ; j ++) {
                int[] a = toBinary(toAdd[i][j]);
                int[] b = toBinary(keySmall[i][j]);
                toReturn[i][j] = toDec(xor(a,b));
            }
        }
        return toReturn;
    }
    public String stateToString(int [][] a){
        String s = "";
        for (int i = 0 ; i < 4 ; i ++){
            for(int j = 0 ; j < 4 ; j ++){
                s+=(char)a[i][j];
            }
        }
        return s;
    }
    public String encode(){
        StringBuilder ENCODE = new StringBuilder();
        for (int i = 0 ; i <listPLan.size();i++){
            ENCODE.append(encode(listPLan.get(i)));
        }
        return ENCODE.toString();
    }

    public String decode(){
        StringBuilder Decode = new StringBuilder();
        for (int i = 0 ; i <listCipher.size();i++){
            Decode.append(decode(listCipher.get(i)));
        }
        return Decode.toString();
    }
    public void setCipherkey(int[][] cipherkey) {
        this.cipherkey = cipherkey;
    }

    public String encode(int [][]state){
        //printState(state);
         int [][] first = addRoundKey(state,cipherkey);
         //printState(first);
       for (int i = 0 ; i < 9;i++){
            first = subByte(first,subBox);
           // printState(first);
            int[][] b = shiftRow(first,shiftRow);
           // printState(b);
            int [][] c = mixColumn(b,mixColumn);
           // printState(c);
            first = addRoundKey(c,listKey.get(i));
           // printState(first);
       }
       int [][] a1 = subByte(first,subBox);
        //printState(a1);
       int [][] a2 = shiftRow(a1,shiftRow);
       //printState(a2);
       int [][] toReturn = addRoundKey(a2,listKey.get(9));
       printState(toReturn);
        return stateToString(toReturn);

    }
    public String decode(int [][] state){
        //printState(state);
        int [][] decode = addRoundKey(state,listKey.get(9));
        //printState(decode);
        for (int i = 8; i >=0 ; i --){
            decode = shiftRow(decode,invshiftRow);
          //  printState(decode);
            int [][] a = subByte(decode,ivSubbox);
            //printState(a);
            int [][] b = addRoundKey(a,listKey.get(i));
            //printState(b);
            decode = mixColumn(b,invMixColumn);
            //printState(decode);
        }
        int[][] a1 = shiftRow(decode,invshiftRow);
        //printState(a1);
        int [][] a2 = subByte(a1,ivSubbox);
        //printState(a2);
        int[][] toReturn  = addRoundKey(a2,cipherkey);
        printState(toReturn);
        return stateToString(toReturn);
    }
}
