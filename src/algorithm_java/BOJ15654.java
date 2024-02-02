package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ15654 {
    static int N;
    static int M;
    static int[] resultArr;
    static int[] inputArr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        resultArr = new int[M];
        inputArr = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputArr);

        dfs(0,0);

        System.out.println(sb.toString());
    }

    public static void dfs(int depth, int from){
        if(depth == M){
            for (int i : resultArr) {
                sb.append(i);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visit[i]){
                visit[i] = true;
                resultArr[depth] = inputArr[i];
                dfs(depth+1, i+1);
                visit[i] = false;
            }
        }
    }
}
