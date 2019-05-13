package myP;

public class RotateMatrix {
    /*整道题的思想一圈一圈转
    首先，第一圈，只需要转第一行中除了最后一个的所有数就可以了，也就是dR - tR - 1个数就可以了
    其次转多少圈：只要tR < dR那就一直转
    */
    public static void rotate(int [][] matrix){
        int tR = 0;//上x
        int tC = 0;//上y
        int dR = matrix.length - 1;//下x
        int dC = matrix[0].length - 1;//下y
        while(tC< dC){
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }
    public static void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC){
        int times = dC - tC;
        int tmp = 0;
//        i就是找 出发点
        for(int i = 0; i != times; i ++){
            tmp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC- i];
            matrix[dR][dC- i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = tmp;
        }
    }
    public static void printMatrix(int[][] matrix){
        for(int i = 0;i < matrix.length; i ++){
            for(int j =0; j < matrix[i].length; j ++){
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
    public static void main(String[] args){
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        rotate(matrix);
        printMatrix(matrix);
    }
}
