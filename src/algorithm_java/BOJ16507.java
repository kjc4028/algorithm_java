package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
어두운 건 무서워

예제 입력 1
5 6 1
4 1 3 4 9 5
1 2 8 7 5 5
8 1 2 5 3 2
1 5 3 4 2 5
5 2 1 2 3 5
2 2 4 5
예제 출력 1
3
예제 입력 2
4 3 5
25 93 64
10 29 85
80 63 71
99 58 86
2 2 2 3
3 2 3 3
1 2 2 2
1 2 4 3
2 3 2 3
예제 출력 2
57
67
61
68
85
 */
public class BOJ16507 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[R+1][C+1];
		
		int[][] preFixArr = new int[R+1][C+1];
		
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/*System.out.println("===기본 입력 확인");
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}*/

		//누적합 계산
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				preFixArr[i][j] = arr[i][j] + preFixArr[i-1][j] + preFixArr[i][j-1] - preFixArr[i-1][j-1];
			}
		}
		
		/*System.out.println("===누적합 확인");
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				System.out.print(preFixArr[i][j] + " ");
			}
			System.out.println();
		}*/
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r1  = Integer.parseInt(st.nextToken());
			int c1  = Integer.parseInt(st.nextToken());
			int r2  = Integer.parseInt(st.nextToken());
			int c2  = Integer.parseInt(st.nextToken());
			
			int result = preFixArr[r2][c2] - preFixArr[r1-1][c2] - preFixArr[r2][c1-1] + preFixArr[r1-1][c1-1];
			int cnt = (r2-r1+1)*(c2-c1+1);
			sb.append(result/cnt + "\n");
			//System.out.println(result/cnt);
		}
		
		System.out.println(sb.toString());
		
		
	}
	
}