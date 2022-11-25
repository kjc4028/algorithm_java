package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

예제 입력 1 
5 17
예제 출력 1 
4
힌트
수빈이가 5-10-9-18-17 순으로 가면 4초만에 동생을 찾을 수 있다.

 */
public class Z1697 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int MAX_VALUE = 100000;
		int N = Integer.parseInt(st.nextToken()); //수빈 위치
		int K = Integer.parseInt(st.nextToken()); //동생 위치
		
		int[] arr = new int[MAX_VALUE+1];
		
		
		Queue<Integer> que = new LinkedList<>();
		
		que.add(N);
		
		while(!que.isEmpty()){
			int i = que.poll();
			
			if(i==K){
				System.out.println(arr[i]);
				return;
			}
			
			if(i+1 <= MAX_VALUE && i+1 >= 0 && arr[i+1] == 0){
				arr[i+1] = arr[i] + 1;
				que.add(i+1);
			}
			if(i-1 <= MAX_VALUE && i-1 >= 0 && arr[i-1] == 0){
				arr[i-1] = arr[i] + 1;
				que.add(i-1);
			}
			if(i*2 <= MAX_VALUE && i*2 >= 0 && arr[i*2] == 0){
				arr[i*2] = arr[i] + 1;
				que.add(i*2);
			}
			
		}
		
	}
	
}
