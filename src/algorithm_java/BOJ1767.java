package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
4 2
4 2
3 1
우선순위큐 + 위상정렬
큐에 적재 후 한번에 출력하는것보다는 적재 후 조건에 따라서 출력
결과 큐 별도 생성
 */
public class BOJ1767 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " "); 
		
		int N = Integer.parseInt(st.nextToken()); //N개 문제
		int M = Integer.parseInt(st.nextToken()); // M개 조건
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		
		List<ArrayList<Integer>> list = new ArrayList<>();
		
		int[] indegreeArr = new int[N+1];
		
		for (int i = 0; i < N+1; i++) {
			list.add( new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int pre = Integer.parseInt(st.nextToken()); //선행 문제 번호
			int after = Integer.parseInt(st.nextToken()); //후행 문제 번호
			list.get(pre).add(after);
			indegreeArr[after] += 1;
		}
		
		//System.out.println(Arrays.toString(indegreeArr));
		
		
		for (int i = 1; i <= N; i++) {
			if(indegreeArr[i] == 0){
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()){
			int curProblem = pq.poll();
			
			for(int i :list.get(curProblem)){
				indegreeArr[i]--;
				if(indegreeArr[i] == 0){
					pq.add(i);
				}
			}
			q.add(curProblem);
		}
		
		while(!q.isEmpty()){
			System.out.print(q.poll()+ " ");
		}
		
		
	}
}