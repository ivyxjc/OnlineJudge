package leetcode.easy;

/**
 * Created by jc on 4/25/2016.
 */
public class No_344_ReverseString {
    public String reverseString(String s) {
        StringBuilder res=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            res.append(s.charAt(i));
        }

        return res.toString();
    }

    public static void main(String[] args){
        String data="hel lo";
        No_344_ReverseString test=new No_344_ReverseString();
        System.out.print(test.reverseString(data));
    }
}
