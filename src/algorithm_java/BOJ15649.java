package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ15649
 * 백트래킹, DFS
 */
public class BOJ15649 {

    static int N = 0; //수 범위
    static int M = 0; // 선택가능 수
    static boolean[] visit; //방문여부
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        visit = new boolean[N];
        arr = new int[M];
        dfs(N,M,0);
    }

    public static void dfs(int N, int M, int depth){
        
        if(M == depth){
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visit[i]){
                visit[i] = true;
                arr[depth]=i+1;        
                dfs(N,M,depth+1);   
                visit[i] = false;        
            }
        }
    }

}