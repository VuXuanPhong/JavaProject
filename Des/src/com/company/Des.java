package com.company;

import java.util.ArrayList;

/**
 * Created by Vu Xuan Phong on 10/05/2017.
 */
public class Des {
    private String plan;
    private String cipher;
    private ArrayList<int[][]> listSbox = new ArrayList<>();
    private ArrayList<int[][]> getListKey() {
        return listKey;
    }
    private ArrayList<String> inputArray = new ArrayList<>();
    private String key;
    private int cout;

    public Des() {
        listSbox.add(S1);
        listSbox.add(S2);
        listSbox.add(S3);
        listSbox.add(S4);
        listSbox.add(S5);
        listSbox.add(S6);
        listSbox.add(S7);
        listSbox.add(S8);
    }

    private ArrayList<int[][]> liststateIP = new ArrayList<>();
    private ArrayList<int[][]> listKey = new ArrayList<>();

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public void setListStateForDecode() {
        ArrayList<int[][]> state = this.toState(cipher);
        for (int i = 0; i < state.size();i++){
            listStateForDecode.add(hoanVi(state.get(i),IP));
        }
    }

    private ArrayList<int[][]> listStateForDecode = new ArrayList<>();

    private final static int[][] IP= {
            {57,49,41,33,25,17,9,1},
            {59,51,43,35,27,19,11,3},
            {61,53,45,37,29,21,13,5},
            {63,55,47,39,31,23,15,7},
            {56,48,40,32,24,16,8,0},
            {58,50,42,34,26,18,10,2},
            {60,52,44,36,28,20,12,4},
            {62,54,46,38,30,22,14,6}
    };

    private final static int [][] FP = {
            {39,7,47,15,55,23,63,31},
            {38,6,46,14,54,22,62,30},
            {37,5,45,13,53,21,61,29},
            {36,4,44,12,52,20,60,28},
            {35,3,43,11,51,19,59,27},
            {34,2,42,10,50,18,58,26},
            {33,1,41,9,49,17,57,25},
            {32,0,40,8,48,16,56,24}
    };

    private final static int[][] PC1 = {
            {56,48,40,32,24,16,8},
            {0,57,49,41,33,25,17},
            {9,1,58,50,42,34,26},
            {18,10,2,59,51,43,35},
            {62,54,46,38,30,22,14},
            {6,61,53,45,37,29,21},
            {13,5,60,52,44,36,28},
            {20,12,4,27,19,11,3}
    };

    private final static int[][] PC2 ={
            {13,16,10,23,0,4},
            {2,27,14,5,20,9},
            {22,18,11,3,25,7},
            {15,6,26,19,12,1},
            {40,51,30,36,46,54},
            {29,39,50,44,32,47},
            {43,48,38,55,33,52},
            {45,41,49,35,28,31}
    };
    private final static int[][] XV1 ={{1,2,3,4,5,6,7},
            {8,9,10,11,12,13,14},
            {15,16,17,18,19,20,21},
            {22,23,24,25,26,27,0},
    };
    private final static int[][] XV2 ={{2,3,4,5,6,7,8},
            {9,10,11,12,13,14,15},
            {16,17,18,19,20,21,22},
            {23,24,25,26,27,0,1}
    };
    private final static  int[][] E = {
            {31,0,1,2,3,4},
            {3,4,5,6,7,8},
            {7,8,9,10,11,12},
            {11,12,13,14,15,16},
            {15,16,17,18,19,20},
            {19,20,21,22,23,24},
            {23,24,25,26,27,28},
            {27,28,29,30,31,0}
    };
    private final static int[][] S1 = {{14,04,13,01,02,15,11,8,03,10,06,12,05,9,00,07},
            {0,15,7,4,14,2,13,10,3,6,12,11,9,5,3,8},
            {4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},
            {15,2,8,2,4,9,1,7,5,11,3,14,10,0,6,13}
    };
    private final static int[][] S2 = {{15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},
            {3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},
            {0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15},
            {13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9}
    };
    private final static int[][] S3 = {{10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8},
            {13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1},
            {13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7},
            {1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12}
    };
    private final static int[][] S4 = {{7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15},
            {13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9},
            {10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4},
            {3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14}
};
    private final static int[][] S5={{2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9},
            {14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6},
            {4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14},
            {11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3}
    };
    private final static int[][] S6={{12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11},
            {10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8},
            {9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6},
            {4,3,2,12,9,5,15,10,11,14,1,7,10,0,8,13}
};
    private final static int[][] S7={{4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1},
            {13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6},
            {1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2},
            {6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12}
    };
    private final static int[][] S8={{13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7},
            {1,15,13,8,10,3,7,4,12,5,6,11,10,14,9,2},
            {7,11,4,1,9,12,14,2,0,6,10,10,15,3,5,8},
            {2,1,14,7,4,10,8,13,15,12,9,9,3,5,6,11}
};
    private final static int [][] Pbox = {
            {15,6,19,20,28,11,27,16},
            {0,14,22,25,4,17,30,9},
            {1,7,23,13,31,26,2,8},
            {18,12,29,5,21,10,3,24}
    };
    public String getPlan() {
        return plan;
    }
    public void print(int []a){
        for (int i=a.length;i>=0;i--){
            System.out.print(a[i]);
        }
    }

    public ArrayList<int[][]> getListstateIP() {
        return liststateIP;
    }

    public void setListstateIP(){
        ArrayList<int[][]> state = toState(this.plan);
        for (int i = 0 ; i <  state.size();i++){
            liststateIP.add(hoanVi(state.get(i),IP));
        }
    }
    public int[] toBinary(int x,int n){
        int [] a = new int[n];
        for (int i = 0;i<n;i++){
            int du = x%2;
            x = x/2;
            a[i] = du;
        }
        return a;
    }

    public int[][] hoanVi(int [][] state, int [][] matrixHoanVi){
        int n = state[0].length;
        int [][] stateReturn =  new int[matrixHoanVi.length][matrixHoanVi[0].length];
        for (int i =0 ; i < matrixHoanVi.length; i++){
            for (int j = 0; j < matrixHoanVi[0].length;j++){
                int x = matrixHoanVi[i][j];
                int a = x/n;
                int b = x%n;
                stateReturn[i][j] = state[a][b];
            }
        }
        return stateReturn;
    }

    public void  createKey(){
        int[][] stateKey = toState(key).get(0);
        int [][] stateKeyPC1 = hoanVi(stateKey,PC1);
        int[][] C = new int[4][7];
        int[][] D = new int[4][7];
        C[0] = stateKeyPC1[0];
        C[1] = stateKeyPC1[1];
        C[2] = stateKeyPC1[2];
        C[3] = stateKeyPC1[3];
        D[0] = stateKeyPC1[4];
        D[1] = stateKeyPC1[5];
        D[2] = stateKeyPC1[6];
        D[3] = stateKeyPC1[7];
        for (int i = 0 ; i < 16;i++){
            if (i==0||i==1||i==8||i==15){
                C = hoanVi(C,XV1);//
                D = hoanVi(D,XV1);
            } else {
                C = hoanVi(C,XV2);
                D = hoanVi(D,XV2);
            }
            int [][] keyTemp = new int[8][7];
            keyTemp[0] = C[0];
            keyTemp[1] = C[1];
            keyTemp[2] = C[2];
            keyTemp[3] = C[3];
            keyTemp[4] = D[0];
            keyTemp[5] = D[1];
            keyTemp[6] = D[2];
            keyTemp[7] = D[3];
            int [][] key = hoanVi(keyTemp,PC2);
            listKey.add(key);
        }
    }

    public String getKey() {
        return key;
    }

    public void printState(int [][] x){
        for (int i = 0 ; i < x.length;i++){
            for (int j=0;j<x[0].length;j++){
                System.out.print(x[i][j]);
                if (j==8) break;
            }
            System.out.println();
        }
    }
    public int [][] EncodeState(int i){
        int[][] halfTop = new int[4][8];
        int[][] halfBottom = new int[4][8];
        divInput(liststateIP.get(i),halfTop,halfBottom);
        for (int j = 0 ; j < 16 ; j ++){
            int [][] left = Fiestel(halfBottom, listKey.get(j));
            int [][] right = xor(halfTop, left);
            if (j==15) {
                halfTop = right;
                break;
            }
            halfTop = halfBottom;
            halfBottom = right;
        }
        int [][] stateEncode = new int[8][8];
        stateEncode[0] = halfTop[0];
        stateEncode[1] = halfTop[1];
        stateEncode[2] = halfTop[2];
        stateEncode[3] = halfTop[3];
        stateEncode[4] = halfBottom[0];
        stateEncode[5] = halfBottom[1];
        stateEncode[6] = halfBottom[2];
        stateEncode[7] = halfBottom[3];

        return hoanVi(stateEncode,FP);
    }
    public int [][] DecodeState(int i){
        int[][] halfTop = new int[4][8];
        int[][] halfBottom = new int[4][8];
        divInput(listStateForDecode.get(i),halfTop,halfBottom);
        for (int j = 15 ; j >=0 ; j --){
            int [][] left = Fiestel(halfBottom, listKey.get(j));
            int [][] right = xor(halfTop, left);
            if (j==0) {
                halfTop = right;
                break;
            }
            halfTop = halfBottom;
            halfBottom = right;
        }
        int [][] stateDecode = new int[8][8];

        stateDecode[0] = halfTop[0];
        stateDecode[1] = halfTop[1];
        stateDecode[2] = halfTop[2];
        stateDecode[3] = halfTop[3];
        stateDecode[4] = halfBottom[0];
        stateDecode[5] = halfBottom[1];
        stateDecode[6] = halfBottom[2];
        stateDecode[7] = halfBottom[3];

        return hoanVi(stateDecode,FP);
    }

    public String statetoString(int [][] x){
        StringBuilder stringReturn = new StringBuilder();
        for (int i = 0 ; i < 8; i++){
            int c = x[i][0] + x[i][1]*2 + x[i][2]*4+x[i][3]*8+x[i][4]*16 + x[i][5]*32 + x[i][6]*64+x[i][7]*128;
            stringReturn.append ((char) c);
        }
        return stringReturn.toString();
    }

    public void setKey(String key) {
        if (key.length()>8){
            StringBuilder sbKey = new StringBuilder();
            for (int i = 0; i < 8;i++){
                sbKey.append(key.charAt(i));
            }
            this.key = sbKey.toString();
        }else {
            this.key = editInput(key);
        }
    }

    public void Encode(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < liststateIP.size();i++){
            String s = statetoString(EncodeState(i));
            stringBuilder.append(s);

        }
        this.cipher = stringBuilder.toString();
    }
    public String DeCode(){
        StringBuilder sDecode = new StringBuilder();
        for (int i = 0; i < listStateForDecode.size();i++){
            String s = statetoString(DecodeState(i));
            sDecode.append(s);
        }
        return sDecode.toString();
    }

    public  int[] Sbox(int [] unKnow, int i ){
        int x = unKnow[5] + unKnow[0]*2;
        int y = unKnow[4] + unKnow[3]*2 + unKnow[2]* 4 + unKnow[1]*8;
        int hex = listSbox.get(i)[x][y];
        return toBinary(hex,4);
    }

    public int[][] Fiestel(int [][] inputStateBottom, int[][] key){

        int [][] Ex = hoanVi(inputStateBottom,E);
        int [][] F = xor(Ex,key);
        int [][] Freturn = new int[8][4];
        for (int j=0;j < 8;j++){
            Freturn[j] = Sbox(F[j],j);
        }
        return hoanVi(Freturn,Pbox);
    }

    public int [][] xor(int [][] X, int [][] Y){
        int [][] xorReturn = new int[X.length][X[0].length];
        for (int i = 0 ; i < X.length;i ++){
            for (int j=0;j<X[0].length;j++){
                if (X[i][j]==Y[i][j]){
                    xorReturn[i][j] = 0;
                }
                else xorReturn[i][j] = 1;
            }
        }
        return xorReturn;
    }

    public ArrayList<int[][]> toState(String s){
        ArrayList<String> X = inputToArray(s);
        ArrayList<int[][]> listState = new ArrayList<>();
        int [][] state = new int[8][8];
        for (int i = 0; i < X.size();i++){
            for (int j =0; j < 8;j++){
                int x = X.get(i).charAt(j);
                state[j] = toBinary(x,8);
            }
            listState.add(state);
            state = new int[8][8];
        }

        return listState;
    }

    public String getCipher() {
        return cipher;
    }
    public ArrayList<String> inputToArray(String s){
        ArrayList<String> R = new ArrayList<>();
        for (int i = 0; i < (s.length()/8);i++){
            String x = s.substring(i*8,i*8+8);
            R.add(x);
        }
        return R;
    }

    public Des(String plan, String key) {
        this.plan = editInput(plan);
        if (key.length()>8){
            StringBuilder sbKey = new StringBuilder();
            for (int i = 0; i < 8;i++){
                sbKey.append(key.charAt(i));
            }
            this.key = sbKey.toString();
        }else {
            this.key = editInput(key);
        }
        listSbox.add(S1);
        listSbox.add(S2);
        listSbox.add(S3);
        listSbox.add(S4);
        listSbox.add(S5);
        listSbox.add(S6);
        listSbox.add(S7);
        listSbox.add(S8);
        cout = editInput(plan).length()/8;
        System.out.println("Key : " + this.key);
    }

    private String editInput(String s){
        if (s.length()%8==0){
            return s;
        }else {
            do {
                s+="!";
            }while (s.length()%8!=0);
        }
        return s;
    }

    public void divInput(int [][] X, int [][] halfTop, int [][] halfBottom){
        halfTop[0] = X[0];
        halfTop[1] = X[1];
        halfTop[2] = X[2];
        halfTop[3] = X[3];
        halfBottom[0] = X[4];
        halfBottom[1] = X[5];
        halfBottom[2] = X[6];
        halfBottom[3] = X[7];
    }
}
