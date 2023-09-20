package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
예제 입력 1
2 3
1 2 4
8 16 32
3
1 1 2 3
1 2 1 2
1 3 2 3
예제 출력 1
63
2
36
*/
public class BOJ2167 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][M + 1];
        int[][] prefixArr = new int[N + 1][M + 1];

        // 기본 배열 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 진행
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefixArr[i][j] = arr[i][j] + prefixArr[i - 1][j] + prefixArr[i][j - 1] - prefixArr[i - 1][j - 1];
            }
        }

        // 배열 누적합배열 값 확인
        // for (int i = 0; i <= N; i++) {
        //     for (int j = 0; j <= M; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // for (int i = 0; i <= N; i++) {
        //     for (int j = 0; j <= M; j++) {
        //         System.out.print(prefixArr[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int K = Integer.parseInt(br.readLine());

        // 좌표 입력 결과 표출
        for (int z = 0; z < K; z++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            System.out.println(prefixArr[x][y] - prefixArr[i - 1][y] - prefixArr[x][j - 1] + prefixArr[i - 1][j - 1]);

        }
    }

}