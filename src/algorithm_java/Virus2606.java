package algorithm_java;

import java.util.*;

/**
 * 백준 바이러스 문제 BFS
 * https://www.acmicpc.net/problem/2606
 */
class Virus2606 {

	public static void main(String[] args){
		//입력단 start
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt()+1; // 컴퓨터 수
		int conn = scan.nextInt()+1; //연결된 수
		
		int[][] network = new int[n][n];		
		int[] visitChk = new int[n];		

		//네트워크 구성 기본 셋팅
		for(int i = 1; i<n; i++){
			for(int j = 1; j<n; j++){
				network[i][j] = 0;
				network[j][i] = 0;
				visitChk[i] = 0; 
			}
		}

		//네트워크 연결 구성 셋팅
		for(int i =1; i<conn; i++){
			int start = scan.nextInt();
			int end = scan.nextInt();
			network[start][end] = 1;
			network[end][start] = 1;
		}

		Queue<Integer> que = new LinkedList<Integer>();
		int cnt = 0;
		que.add(1);
		visitChk[1] = 1;
		while(!que.isEmpty()){
			int target = que.poll();
			for(int i = 1; i<n; i++){
				if(network[target][i] == 1 && visitChk[i] == 0){
					que.add(i);
					visitChk[i] = 1;
					cnt++;
				}
			}
		}

		System.out.println(cnt);
		scan.close();
	}

}
