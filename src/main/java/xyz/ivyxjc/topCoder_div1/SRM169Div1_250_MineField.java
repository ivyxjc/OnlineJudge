package xyz.ivyxjc.topCoder_div1;

import java.util.Scanner;

/**
 * Created by xgh on 2016/1/30.
 */
/*
该题以字符串形式标明地雷位置
输出字符串数组表明任何一个地点周围地雷的个数
 */
public class SRM169Div1_250_MineField {
    public String[] getMineField(String mineField){
        int[][] table=new int[9][9];
        String[] res=new String[9];
        int[] vertiacal_offset={-1,-1,-1,0,0,1,1,1};
        int[] horizontal_offset={-1,0,1,-1,1,-1,0,1};

        mineField=mineField.replaceAll("[(,)]"," ");
        System.out.println(mineField);

        Scanner in=new Scanner(mineField);
        while(in.hasNext()){
            int vertical_coordinate=in.nextInt();
            int horizontal_coordinate=in.nextInt();
            table[vertical_coordinate][horizontal_coordinate]=-100;
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
        int a;

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(table[i][j]<0){
                    for(int k=0;k<8;k++){
                        if(i + vertiacal_offset[k]>=0&&i + vertiacal_offset[k]<9&&j + horizontal_offset[k]>=0&&j + horizontal_offset[k]<9) {
                            table[i + vertiacal_offset[k]][j + horizontal_offset[k]] += 1;
                            System.out.println("-------"+i+j);
                        }
                    }
                }
            }
        }
        System.out.println("------------------------");
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
        for(int i=0;i<9;i++){
            StringBuilder stringBuilder=new StringBuilder();
            for(int j=0;j<9;j++){
                if(table[i][j]<0)
                    stringBuilder.append('M');
                else
                    stringBuilder.append(table[i][j]);
            }
            res[i]=stringBuilder.toString();
        }

        return res;
    }

    public static void main(String[] args){
        SRM169Div1_250_MineField test=new SRM169Div1_250_MineField();

        String[] ss=test.getMineField("(0,1)(0,0)(1,0)(2,0)(3,0)(4,0)");
        System.out.println("------------------------");
        for(int i=0;i<9;i++){
            System.out.println(ss[i]);
        }

    }
}
