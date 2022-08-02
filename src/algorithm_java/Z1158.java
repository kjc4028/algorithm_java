package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Z1158 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //총 수
		int K = Integer.parseInt(st.nextToken()); //제거패턴 수
		
		Queue<Integer> qu = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		
		//초기화
		for (int i = 0; i < N; i++) {
			qu.add(i+1);
		}
		
		while(!qu.isEmpty()){
			for (int i = 0; i < K; i++) {
				if(i == K-1){
					if(qu.size() == 1){
						sb.append(qu.poll()).append(">");
					} else {
						sb.append(qu.poll()).append(", ");
					}
				} else {
					qu.add(qu.poll());
				}
			}
		}
		
		System.out.println(sb.toString());
		
	}
}


