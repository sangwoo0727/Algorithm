import java.util.*;
import java.io.*;


class Solution {
    static int n;
    static Pos[] island;
    static double E;    
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t=1; t<=tc; t++){
            n = Integer.parseInt(br.readLine());
            island = new Pos[n];

            String[] temp = br.readLine().split(" ");

            for(int i=0; i<n; i++)
                island[i] = new Pos(Integer.parseInt(temp[i]), 0, 0);

            temp = br.readLine().split(" ");
            for(int i=0; i<n; i++)
                island[i].y = Integer.parseInt(temp[i]);

            E = Double.parseDouble(br.readLine());
            ArrayList<Pos> weights = new ArrayList<>();

            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    weights.add(new Pos(i, j, calWeight(island[i].x, island[i].y, island[j].x, island[j].y)));
                }
            }

            Collections.sort(weights, new Comparator<Pos>() {
                @Override
                public int compare(Pos p1, Pos p2){
                    if(p1.weight < p2.weight)
                        return -1;
                    else if(p1.weight > p2.weight)
                        return 1;
                    return 0;
                }
            });

            p = new int[n];
            for(int i=0; i<n; i++)
                p[i] = i;

            double ans = 0.0;
            for(int i=0; i< weights.size(); i++){
                if(find(weights.get(i).x)!= find(weights.get(i).y)){
                    union(weights.get(i).x, weights.get(i).y);
                    ans = ans + weights.get(i).weight; 
                }
            }
            System.out.format("#%d %.0f\n", t, ans);
        }
    }

    public static int find(int x){
        if(p[x] == x) return x;
        else
            return p[x] = find(p[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            p[y] = x; 
        }
    }

    public static double calWeight(long x, long y, long dx, long dy){        
        return E * Math.pow(Math.sqrt(Math.pow(dx-x, 2) + Math.pow(dy-y, 2)),2);
    }
    static class Pos {
        int x;
        int y;
        double weight;

        Pos(int x, int y, double weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}