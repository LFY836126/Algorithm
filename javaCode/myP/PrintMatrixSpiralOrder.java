package myP;

public class PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][] matrix){
        /*用两个点，四个坐标来打印第一圈矩形，再把两个点的坐标往里推一个，转圈打印里面一层的矩形，以此类推*/
        int tR = 0;//上x
        int tC = 0;//上y
        int dR = matrix.length - 1;//下x
        int dC = matrix[0].length - 1;//下y
        while (tR <= dR && tC <= dC) {
            printEdge(matrix , tR++, tC++, dR--, dC--);
        }
    }
    public static void printEdge(int[][] matrix, int tR, int tC, int dR, int dC){
        if(tC == dC){
            for(int i = 0;i <= dR - tR; i ++ ){
                System.out.print(matrix[tR+i][tC] + " ");
            }
        }else if(tR == dR){
            for(int i = 0;i <= dC - tC; i ++ ){
                System.out.print(matrix[tR][tC+i] + " ");
            }
        }else{
            int curR = tR;
            int curC = tC;
            while(curC != dC){
                System.out.print(matrix[tR][curC ++] + " ");
            }
            while(curR != dR){
                System.out.print(matrix[curR ++][dC]+ " ");
            }
            while(curC != tC){
                System.out.print(matrix[dR][curC --]+ " ");
            }
            while(curR != tR){
                System.out.print(matrix[curR --][tC]+ " ");
            }
        }
    }
    public static void main(String[] args){
        int[][] Matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        spiralOrderPrint(Matrix);
    }
}
