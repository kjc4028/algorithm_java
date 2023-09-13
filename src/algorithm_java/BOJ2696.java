package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
1
9
1 2 3 4 5 6 7 8 9
예제 입력 1 
3
9
1 2 3 4 5 6 7 8 9
9
9 8 7 6 5 4 3 2 1
23
23 41 13 22 -3 24 -31 -11 -8 -7
3 5 103 211 -311 -45 -67 -73 -81 -99
-33 24 56
예제 출력 1 
5
1 2 3 4 5
5
9 8 7 6 5
12
23 23 22 22 13 3 5 5 3 -3
-7 -3
 */
public class BOJ2696 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		int x;
		
		for (int i = 0; i < T; i++) {
			float M = Integer.parseInt(br.readLine());

			
			
			int mvCnt = 0; //표출할 중앙값 개수
			
			mvCnt = (int) Math.ceil(M/2);
			
			PriorityQueue<Integer> pqR = new PriorityQueue<>(); //우측 큰수
			PriorityQueue<Integer> pqL = new PriorityQueue<>(Collections.reverseOrder()); //좌측 작은수
			
			int index = 0;
			int oddCnt = 0;
			
			sb.append(mvCnt + "\n");
			
			while(index < M){
				
				if(index%10 == 0){
					st = new StringTokenizer(br.readLine(), " ");
				}
				
				x = Integer.parseInt(st.nextToken());
				
				int sizeL = pqL.size();
				int sizeR = pqR.size();
				
				if(sizeL == sizeR){
					pqR.add(x);
				} else {
					pqL.add(x);
				}
				
				if (!pqR.isEmpty() && !pqL.isEmpty()){
					if (pqL.peek() > pqR.peek()) {
						int tmp = pqL.poll(); 
						pqL.add(pqR.poll());
						pqR.add(tmp);
					}
				}
				
				int r = pqR.peek();
				
				index++;

				if(index%2 != 0){
					oddCnt++;
					sb.append(r + " ");
					if(oddCnt%10 == 0){
						sb.append("\n");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}

