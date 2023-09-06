package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ14235 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//거점지 수
		int N = Integer.parseInt(br.readLine());
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if("0".equals(input)){
				if(pq.isEmpty()){
					System.out.println(-1);
				}else{
					System.out.println(pq.poll());
				}
			} else {
				st = new StringTokenizer(input, " ");
				st.nextToken(); //StringTokenizer 사용하면 첫번째 입력값 불필요
				while(st.hasMoreTokens()){
					pq.add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		
	}
	
}