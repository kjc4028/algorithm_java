package algorithm_java;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
예제 입력 1 
7
1
5
2
10
-99
7
5
예제 출력 1 
1
1
2
2
2
2
5
내림차순 우선순위큐 
오름차순 우선순위큐
 */
public class BOJ1655 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine()); //N개 문제
		
		PriorityQueue<Integer> minpq = new PriorityQueue<Integer>();
		
		PriorityQueue<Integer> maxpq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			int inputNum = Integer.parseInt(br.readLine());
			
			int minSize = minpq.size();
			int maxSize = maxpq.size();
			
			if(minSize == maxSize){
				maxpq.add(inputNum);
			} else {
				minpq.add(inputNum);
			}
			
			if (!maxpq.isEmpty() && !minpq.isEmpty()){
				if (minpq.peek() < maxpq.peek()) {
					int tmp = minpq.poll(); 
					minpq.add(maxpq.poll());
					maxpq.add(tmp);
				}
			}
			sb.append(maxpq.peek()+"\n"); // StringBuffer 미사용시 시간초과
		}
        System.out.println(sb.toString());		// StringBuffer 미사용시 시간초과
		
	}
}