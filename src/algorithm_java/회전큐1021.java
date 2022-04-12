package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전큐1021 {

	static LinkedList<Integer> que = new LinkedList<Integer>(); //Deque를 사용
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //큐의 크기
		int M = Integer.parseInt(st.nextToken()); //찾으려는 수의 수
		
		
		int queIndex = 0;
		while(queIndex < N){
			++queIndex;
			que.offer(queIndex);
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int[] findNum = new int[M];
		
		for(int i = 0; i < M; i++){
			findNum[i] = Integer.parseInt(st.nextToken()); 
		}
		
		
		for(int i = 0; i < findNum.length; i++){
			
			if(que.peekFirst() == findNum[i]){
				que.pollFirst();
				continue;
			}
			
			int halfIndex = 0;
			int targetIndex = que.indexOf(findNum[i]);
			if(que.size()%2 == 0){
				halfIndex = que.size()/2-1; 
			} else {
				halfIndex = que.size()/2;
			}
			
			if(halfIndex >= targetIndex ){ //중간지점의 왼쪽에 있는 경우 left
				for(int j = 0; j < targetIndex; j ++){
					int first = que.pollFirst();
					que.offerLast(first);
					cnt++;
				}
			} else { //중간지점의 오른쪽에 있는 경우 right
				for(int j = 0; j < que.size() - targetIndex; j ++){
					int last = que.pollLast();
					que.offerFirst(last);
					cnt++;
				}
			}
			que.pollFirst();
		}
		
		System.out.println(cnt);
		
		
	}

}
