package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ15650
 * 백트래킹, DFS
 */
public class BOJ15650 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수 범위
        int M = Integer.parseInt(st.nextToken());  // 선택가능 수

        boolean[] visit = new boolean[N]; //방문 여부
        int[] arr = new int[M]; //출력보관

        dfs(N,M,0,visit,arr,0);
    }

    public static void dfs(int N, int M, int depth,boolean[] visit, int[] arr, int at){
        
        if(M == depth){
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i < N; i++) {
            if(!visit[i]){
                visit[i] = true;
                arr[depth]=i+1;        
                dfs(N,M,depth+1,visit,arr,i+1);   
                visit[i] = false;        
            }
        }
    }
    

}