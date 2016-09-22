package CodeForces_div2;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jc on 9/22/2-216.
 */
public class CF372_B {

    private static HashMap<Character,Integer> map;
    private static int flagNum=-1;

    public static HashMap<Character,Integer> initMap(){
        HashMap<Character,Integer> m=new HashMap<>();
        m.put('A',-2);m.put('B',-2);m.put('C',-2);m.put('D',-2);
        m.put('E',-2);m.put('F',-2);m.put('G',-2);m.put('H',-2);
        m.put('I',-2);m.put('J',-2);m.put('K',-2);m.put('L',-2);
        m.put('M',-2);m.put('N',-2);m.put('O',-2);m.put('P',-2);
        m.put('Q',-2);m.put('R',-2);m.put('S',-2);m.put('T',-2);
        m.put('U',-2);m.put('V',-2);m.put('W',-2);m.put('X',-2);
        m.put('Y',-2);m.put('Z',-2);
        return m;
    }

    public static void change(String s,int start){

        ArrayList<Character> list=new ArrayList<>();
        for(Character c:map.keySet()){
            if(map.get(c)<flagNum){
                list.add(c);
            }
        }

        char[] out=s.toCharArray();
        int tmp=0;
        for(int i=start;i<start+26;i++){
            if(out[i]=='?'){
//                System.out.print(list.get(tmp));
                out[i]=list.get(tmp);
                tmp++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char c:out){
            if(c=='?'){
                sb.append('A');
            }else {
                sb.append(c);
            }

        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input=in.nextLine();
        map=initMap();
        if(input.length()<26){
            System.out.println(-1);
            return;
        }
        char[] ttt=input.toCharArray();
        int posOne=0;
        int posTwo=0;
        int diffLength=0;
        while(posOne<input.length()){
            if(input.charAt(posOne)=='?'){

                diffLength+=1;
                if(diffLength>=26){
                    if(input.charAt(posTwo)=='?'){
                        change(input,0);
                    }else{
                        change(input,posTwo);
                    }

                    return;
                }
                posOne+=1;
                continue;
            }

            if(map.get(input.charAt(posOne))>flagNum){
                posTwo=map.get(input.charAt(posOne))+1;
                map.put(input.charAt(posOne),posOne);
                diffLength=diffLength-posTwo+((flagNum>=0)?flagNum:0);
                flagNum=posTwo;
            }else{
                map.put(input.charAt(posOne),posOne);
                posOne+=1;
                diffLength+=1;
                if(diffLength>=26){
                    if(input.charAt(posTwo)=='?'){
                        change(input,0);
                    }else{
                        change(input,posTwo);
                    }
                    return;
                }
            }
        }
        System.out.println("-1");


    }
}
