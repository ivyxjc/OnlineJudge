package xyz.ivyxjc.leetcode.easy;

/**
 * Created by jc on 4/25/2016.
 */
public class _11_TMP {

    char[] alphabet={'\t','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public String convertToTitle(int n) {

        int a=(int)(Math.log(n)/Math.log(26));
        a+=1;

        char[] s=new char[a];

        int start=0;
        int index=a-1;
        while(n!=0){
//            if(n%26==0){
//                s[index]='Z';
//                n=n/26;
//                n--;
//                if(index==1)
//                    start=1;
//            }else{
//                s[index]=alphabet[n%26];
//                n=n/26;
//            }
//            index--;
            s[index]=alphabet[n%27];
            n=n/27;
        }

        System.out.println(start);
        StringBuilder sb=new StringBuilder();

        for(int i=start;i<s.length;i++){
            sb.append(s[i]);
        }

        System.out.println(sb.charAt(0));
        return sb.toString();
    }


    public int titleToNumber(String s) {
        int res=0;
        int count=0;
        int length=s.length();
        for(int i=length-1;i>=0;i--){
            int num=0;
            char a=s.charAt(i);
            for(int j=0;j<alphabet.length;j++){
                if(alphabet[j]==a){
                    num=j;
                    break;
                }
            }
            res+=num*Math.pow(26,count);
            count++;
        }
        return res;
    }


    public static void main(String[] args){
        int num=52;
        _11_TMP test=new _11_TMP();

        System.out.println(test.convertToTitle(num));
        System.out.println(test.titleToNumber("AXZ"));

    }
}
