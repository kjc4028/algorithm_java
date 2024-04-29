package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 비트마스킹 + 조합
 * 캠프준비
 */
public class BOJ16938 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int rsCnt = 0;
        
        st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i < (1 << N); i++) {
            int cnt = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            
            for(int j = 0; j < N; j++) {
                if((i & (1 << j)) != 0) {
                    cnt = cnt +1;
                    max = Math.max(max, arr[j]);
                    min = Math.min(min, arr[j]);
                    sum += arr[j];
                }
            }
            
            //문제는 두 문제 이상이어야 한다
            if(cnt < 2){
                continue;
            }
            //가장 어려운 문제와 가장 쉬운 문제의 난이도 차이는 X보다 크거나 같아야 한다.
            if(max-min < X){
                continue;
            }
            //문제 난이도의 합은 L보다 크거나 같고, R보다 작거나 같아야 한다
            if(sum < L || sum > R ){
                continue;
            }
            
            rsCnt +=1;
        }
        System.out.println(rsCnt);
    }
}
