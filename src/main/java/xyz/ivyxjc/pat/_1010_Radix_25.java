package xyz.ivyxjc.pat;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by xgh on 2016/2/21.
 */
public class _1010_Radix_25{
    private static HashMap<Character,Integer> map=new HashMap<Character, Integer>();

    public static void main(String[] args) {
        //输入数据
        Scanner in = new Scanner(System.in);
        String[] dataStr = (in.nextLine()).split(" ");
        int charRepNum = 10;

        //设立一个map，其中'a':10;'b':11 ..... 'z':35
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, charRepNum++);
        }
        for (int i = 0; i < 9; i++) {
            map.put((char) (i + 48), i);
        }


        //获取已知进制那个数对应的十进制数
        int givenRadixNumPosi = Integer.parseInt(dataStr[2]);
        long givenRadix = Integer.parseInt(dataStr[3]);
        long givenNum = 0;
        String givenNumStr = dataStr[givenRadixNumPosi - 1];
        givenNum=strToLong(givenNumStr,givenRadix);


        int resRadixNumPosi = 0;
        if (givenRadixNumPosi == 1) {
            resRadixNumPosi = 1;
        } else {
            resRadixNumPosi = 0;
        }

        String resNumStr = dataStr[resRadixNumPosi];
        //获取未知进制数中最大的字符所代表的十进制数
        int biggestCharInResNumStr = map.get(resNumStr.charAt(0));
        for (int i = 0; i < resNumStr.length(); i++) {
            if (map.get(resNumStr.charAt(i)) > biggestCharInResNumStr) {
                biggestCharInResNumStr = map.get(resNumStr.charAt(i));
            }
        }


        if(strToLong(resNumStr,biggestCharInResNumStr+1)==givenNum){
            System.out.println(biggestCharInResNumStr+1);
            return;
        }

        findRadix(givenNum,resNumStr,biggestCharInResNumStr+1,givenNum+1);
    }


    public static void findRadix(long num,String str,long radixBegin,long radixEnd){
        if(radixBegin>radixEnd){
            System.out.println("Impossible");
            return;
        }
        if(radixBegin==radixEnd){
            if(strToLong(str,radixBegin)==num){
                System.out.println(radixBegin);
                return;
            }else{
                System.out.println("Impossible");
                return;
            }
        }
        long radixMiddle=(radixBegin+radixEnd)>>1;
        long middleRadixNum=strToLong(str,radixMiddle);
        if(middleRadixNum>num){
            findRadix(num,str,radixBegin,radixMiddle);
        }else if(middleRadixNum==num){
            System.out.println(radixMiddle);
            return;
        }else{
            findRadix(num,str,radixMiddle+1,radixEnd);
        }


    }

    //已知字符串和进制，算出对应的十进制数
    public static long strToLong(String str,long radix){
        long res=0;
        int tmp=0;
        for(int i=str.length()-1;i>=0;i--){
            res+=map.get(str.charAt(i))*Math.pow(radix,tmp++);
        }
        return res;
    }
}
