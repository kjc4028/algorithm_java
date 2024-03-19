package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*55 73
126*/

/*
 * 비트연산자 XOR(^) 활용
 */
public class BOJ27960 {
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int userA= Integer.parseInt(st.nextToken());
		int userB= Integer.parseInt(st.nextToken());
		
		int userC = (userA^userB);
		
		System.out.println(userC); 
		
	}
}