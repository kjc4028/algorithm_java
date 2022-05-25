package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Z2750 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N; i++){
			System.out.println(arr[i]);
		}
		
		
	}
	
}