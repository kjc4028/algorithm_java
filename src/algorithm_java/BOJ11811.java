package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3
0 1 1
1 0 1
1 1 0

비트마스킹
값이 여러개인 경우 아무거나라고 하는 문구 주의
해당행의 각각의 열과 OR 연산으로 확인
*/

public class BOJ11811 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < arr.length; i++) {
            int orVal = arr[i][i];
            for (int j = 0; j < arr.length; j++) {
                orVal = orVal | arr[i][j];
            }
            sb.append(orVal + " ");
        }

        System.out.print(sb.toString());

    }
}