package algorithm_java;

import java.util.*;

class Floydwarshall1956 {

	static int INF = 5000000;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int V = scan.nextInt(); //마을
		int E = scan.nextInt(); //도로
		
		int[][] arr = new int[V][V];
		
		//초기화

		for(int i =0; i < V; i++){
			for(int j = 0; j < V; j++){
				if(i!=j){
					arr[i][j] = INF;
				} else {
					arr[i][j] = 0;
				}
			}
		}
		
				//그래프 중간 확인
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length; j++){
				if(arr[i][j] == INF){
					System.out.print("INF" +" "); 
				} else {
					System.out.print(arr[i][j] +" "); 
				}
			}
			System.out.println();
		}

		//입력받은 거리 셋팅
		for(int i = 0; i < E; i++){
			int a = scan.nextInt(); //출발지
			int b = scan.nextInt(); //목적지
			int c = scan.nextInt(); //거리
			arr[a-1][b-1] = c;
		}
		
				//그래프 중간 확인
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length; j++){
				if(arr[i][j] == INF){
					System.out.print("INF" +" "); 
				} else {
					System.out.print(arr[i][j] +" "); 
				}
			}
			System.out.println();
		}		
		scan.close();

		//플로이드워셜알고리즘
		for(int k = 0; k < V; k++){
			for(int i = 0; i < V; i++){
				for(int j = 0; j < V; j++){
					if(i==j){
						continue;
					}
					if(arr[i][j] > arr[i][k] + arr[k][j]){
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		
		int result = INF;
		
		for(int i = 0; i < V; i++){
			for(int j = 0; j < V; j++){
				if(i==j){
					continue;
				}
				if(arr[i][j] != INF && arr[j][i] != INF){
					result = Math.min(result, arr[i][j]+arr[j][i]);
				}
				
			}
		}
		
		result = (result == INF) ?  -1 : result;
		
		System.out.println(result);
		
	}

}
