package xyz.ivyxjc.codeForces_div2;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

/**
 * Created by yanjiusuo4 on 2016/10/9.
 */

/**
 * 先获取该光线所经过的所有点的坐标放入grid_time之中。
 * 再查询
 * 复杂度最差O(m*n*search_times)
 * 该方法未能accepted
 */
public class IntelC {

    static int n;
    static int m;
    static int time;

    static int refX;
    static int refY;

    static int runX=1;
    static int runY=1;

    static HashMap<Integer,HashMap<Integer,Integer>> grid_time=new HashMap<>();

    public static void main(String[]args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));

        n = nextInt();
        m = nextInt();

        refX=0;
        refY=0;

        int sensorNum = nextInt();
        int[][] sensorPlace = new int[sensorNum][2];
        for (int i = 0; i < sensorNum; i++) {

            sensorPlace[i][0] = nextInt();
            sensorPlace[i][1] = nextInt();
        }
        if (n == m) {
            for (int i = 0; i < sensorNum; i++) {
                if (sensorPlace[i][0] == sensorPlace[i][1]) {
                    out.println(sensorPlace[i][0]);
                } else {
                    out.println(-1);
                }
            }
            in.close();
            out.close();
            return;
        }
        make();
        for(int i=0;i<sensorNum;i++){
            if(grid_time.get(sensorPlace[i][0])==null){
                out.println(-1);
            }else{
                HashMap<Integer,Integer> a= grid_time.get(sensorPlace[i][0]);
                if(a.get(sensorPlace[i][1])==null){
                    out.println(-1);
                }else{
                    out.println(a.get(sensorPlace[i][1]));
                }
            }
        }
        in.close();
        out.close();

    }


    public static void make(){
        while (true){
            if(!laser()){
                break;
            }
        };
    }

    public static boolean laser() {
        int ray_x = refX;
        int ray_y = refY;

        while (true) {
            ray_x += runX;
            ray_y += runY;
            time += 1;
            if(ray_x==n){
                if(ray_y==0||ray_y==m){
                    return false;
                }
            }
            if(ray_y==m){
                if(ray_x==0||ray_x==n){
                    return false;
                }
            }

            if (grid_time.get(ray_x) == null) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(ray_y, time);
                grid_time.put(ray_x, map);
            } else {
                HashMap<Integer, Integer> tmp = grid_time.get(ray_x);
                if (tmp.get(ray_y) == null) {
                    grid_time.get(ray_x).put(ray_y, time);
                } else {

                }
            }
            if (ray_x == n) {
                runX=-1;
                if (ray_y > refY) {
                    runY=1;
                } else {
                    runY=-1;
                }
                refX=ray_x;
                refY=ray_y;
                return true;
            }
            if (ray_x == 0) {
                runX=1;
                if (ray_y > refY) {
                    runY = 1;
                } else {
                    runY = -1;
                }
                refX=ray_x;
                refY=ray_y;
                return true;
            }
            if (ray_y == m) {
                runY = -1;
                if (ray_x > refX) {
                    runX = 1;
                } else {
                    runX = -1;
                }
                refX=ray_x;
                refY=ray_y;
                return true;
            }
            if (ray_y == 0) {
                runY=1;
                if (ray_x > refX) {
                    runX=1;
                } else {
                    runX=-1;
                }
                refX=ray_x;
                refY=ray_y;
                return true;
            }

        }

    }










    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

    static int nextInt() throws IOException {
        return parseInt(next());
    }

    static long nextLong() throws IOException {
        return parseLong(next());
    }

    static double nextDouble() throws IOException {
        return parseDouble(next());
    }

    static String next() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }
}
