package algorithm.dynamicProgram;

/**
 * Created by ivxyjc on 2016/12/6.
 */

import java.util.ArrayList;

/**
 * 矩阵链乘法
 * 算法导论-动态规划-钢条切割
 */
public class Matrix {

    public ArrayList<int[][]> matrixChainOrder(int[] p){
        //矩阵个数
        int n=p.length-1;
        int[][]m=new int[n+1][n+1];
        int[][]s=new int[n+1][n+1];
        for (int i = 0; i < n+1 ; i++) {
            for (int j = 0; j < 2; j++) {
                m[i][j]=0;
            }
        }
        for (int l = 2; l < n+1 ; l++) {
            for (int i = 1; i < n- l+2; i++) {
                int j=i+l-1;
                m[i][j]=Integer.MAX_VALUE;
                for (int k = i; k < j ; k++) {
                    int q=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                    if(q<m[i][j]){
                        m[i][j]=q;
                        s[i][j]=k;
                    }
                }
            }
        }

        ArrayList<int[][]> res=new ArrayList<>();
        res.add(m);
        res.add(s);
        return res;
    }



    public static void main(String[] args){
//        int [][] p=new int[7][];
//        for (int i = 0; i <p.length ; i++) {
//            p[i]=new int[2];
//        }
////        int[]
//        p[0][0]=30;
//        p[0][1]=35;
//        p[1][0]=35;
//        p[1][1]=15;
//        p[2][0]=15;
//        p[2][1]=5;
//        p[3][0]=5;
//        p[3][1]=10;
//        p[4][0]=10;
//        p[4][1]=20;
//        p[5][0]=20;
//        p[5][1]=26;
//        p[6][0]=30;
//        p[6][1]=30;
//        p[7][0]=30;
//        p[7][1]=30;

        int[] p={30,35,15,5,10,20,25};
        ArrayList<int[][]> res=new Matrix().matrixChainOrder(p);
        for(int[][] i:res){
            for (int j = 0; j < i.length; j++) {
                for (int k = 0; k < i[j].length; k++) {
                    System.out.print(i[j][k]+" ");
                }
                System.out.println();
            }
        }
//        System.out.println(new Matrix().matrixChainOrder(p));
    }
}
