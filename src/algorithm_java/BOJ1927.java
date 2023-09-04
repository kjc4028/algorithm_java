package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1927 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int x;
		
		for (int i = 0; i < N; i++) {
			x = Integer.parseInt(br.readLine());
			if(x == 0){
				if(pq.isEmpty()){
					System.out.println(0);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				pq.add(x);
			}
		}
		
		
	}
	
}