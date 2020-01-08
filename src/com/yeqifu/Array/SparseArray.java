package com.yeqifu.Array;

/**
 * 稀疏数组
 * @Author: 落亦-
 * @Date: 2020/1/5 20:27
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组 11*11
        //0:表示没有棋子，1表示黑子，2表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组:");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将二维数组转换成稀疏数组
        //1.先遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("sum="+sum);

        //2.创建对应的稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = chessArr1.length;
        sparseArray[0][1] = chessArr1.length;
        sparseArray[0][2] = sum;

        //将二维数组中非0的值存放到稀疏数组中
        //count用于记录是第几个非 0 数据
        int count = 1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j]!=0){
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }

        //输出稀疏数组
        System.out.println("稀疏数组为：");
        for (int[] row : sparseArray) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将稀疏数组恢复成原始的二维数组
        int[][] original = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                original[i][j] = 0;
            }
        }
        for (int i = 1; i < sparseArray.length; i++) {
            original[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //输出恢复后的数组
        System.out.println("将稀疏数组恢复成原始数组：");
        for (int[] row : original) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }



    }
}
