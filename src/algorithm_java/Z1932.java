package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z1932 {

	static int[][] arr; 
	static Integer[][] dp;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
	    arr = new int[N][N];
		dp = new Integer[N][N];
	    
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < i+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			dp[N-1][i] = arr[N-1][i];
		}
		
		System.out.println(find(0, 0));
		
		
	}
	
	public static int find(int x, int y) throws Exception{
		
		if(x == N-1){
			return dp[x][y];
		}
		
		if(dp[x][y] == null){
			dp[x][y] = Math.max(find(x+1,y), find(x+1,y+1)) + arr[x][y];
		}else{
			return dp[x][y];
		}
		
		
		return dp[x][y];
	}
	
}