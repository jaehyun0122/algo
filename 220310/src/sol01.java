import java.lang.reflect.Array;
import java.util.*;

public class sol01 {

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Node>[] list;
    public static void main(String[] args) {

        int n = 5;
        int[][] edges = {
                {0,1},
                {0,2},
                {1,3},
                {1,4}
//                {2,3},
//                {0,1},
//                {1,2}
        };
        solution(n, edges);
    }

    public static int solution(int n, int[][] edges){
        int result = 0;

        int[][] arr = new int[n][n];
        for(int i=0; i<edges.length ;i++){
            int x= edges[i][0];
            int y = edges[i][1];
            arr[x][y]  = 1;
            arr[y][x]  = 1;
        }

        boolean[] bln = new boolean[n];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i][j] != 0){
                    bln[j] = true;
                    if(arr[j][i] != 0){
                        for(int k=0; k<arr[j].length; k++){
                            if(i==k) continue;
                            if(arr[j][k] !=0) {
                                bln[k] = true;
                                result++;
                                System.out.println("i : "+i+" - "+j+" - "+k);
                                for(int c=0; c<arr[k].length; c++){
                                    if(c==i || bln[c]) continue;
                                    if(arr[k][c] != 0){
                                        result++;
                                        System.out.println(i+" "+k+"  "+c);
//                                        arr[i][c] = 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int[] a : arr){
            for(int c : a) System.out.print(c+" ");
            System.out.println();
        }
        System.out.println(result);
        return result;
    }
}
