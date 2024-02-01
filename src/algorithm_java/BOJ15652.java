package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652 {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        dfs(0,0);

        System.out.println(sb.toString());
    }

    public static void dfs(int depth, int from){
        if(depth == M){
            for (int i : arr) {
                sb.append(i);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = from; i < N; i++) {
            arr[depth] = i+1;
            dfs(depth+1, i);
        }
    }
}
