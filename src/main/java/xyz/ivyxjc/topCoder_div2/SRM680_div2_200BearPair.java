package xyz.ivyxjc.topCoder_div2;

/**
 * Created by xgh on 2016/1/30.
 */
public class SRM680_div2_200BearPair {
    public int bigDistance(String s){
        int N=s.length();
        int a=0;
        int b=0;
        for(int i=0;i<N-1;i++){
            for(int j=N-1;j>=0;j--) {
                if (s.charAt(i) != s.charAt(0)) {
                    a = N - i;
                    break;
                }
            }
            if (s.charAt(i) != s.charAt(N - 1)) {
                b = N - i;
                break;
            }
        }

        if(b>a)
            return b-1;
        else
            return a-1;
    }

    public static void main(String[] args){
        SRM680_div2_200BearPair aa=new SRM680_div2_200BearPair();
        System.out.println(aa.bigDistance("oooohyeahpotato" ));
    }
}
