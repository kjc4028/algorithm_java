package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
4 5
5 8 7 7
5 2 1 5
7 1 7 1
8 9 6 9
9 8 9 9
 */
public class BOJ2276 {

	static int[][] arr;
	static int[][] maxArr;
	static boolean[][] visitArr;
	static 	int N;
	static 	int M;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static int totalWater;
	
	
	//상하좌우
	static int[] moveX = {0,0,-1,1};
	static int[] moveY = {-1,1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken()); // 자연수 개수
		N = Integer.parseInt(st.nextToken()); //줄
		
		arr = new int[N][M];
		maxArr = new int[N][M];
		visitArr = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0 || j == 0 || i == N-1 || j == M-1){
					visitArr[i][j] = true;
					pq.add(new Node(i,j, arr[i][j]));
				}
				
			}
		}
		
		waterSend();
		
		System.out.println(totalWater);
		
	}
	
	static public void waterSend(){
		while(!pq.isEmpty()){
			Node curNode = pq.poll();
			int curX = curNode.x; 
			int curY = curNode.y; 
			int curW = curNode.w;
			
			for (int i = 0; i < 4; i++) {
				int nx = curX + moveX[i];
				int ny = curY + moveY[i];
				
				if((nx >=0 && nx < N) && (ny >=0 && ny < M) && !visitArr[nx][ny]){
					visitArr[nx][ny] = true;
					if(curW >= arr[nx][ny]){ //현재위치가 주변 높이 보다 낮거나 같은경우 물을 채움
						totalWater += curW - arr[nx][ny];
						pq.add(new Node(nx,ny,curW)); //다음 위치의 높이를 현재 높이로 대입
					} else { //현재위치가 주편보다 높이가 낮은 경우
						pq.add(new Node(nx,ny,arr[nx][ny]));
					}
				}
			}
		}
	}
	
	public static class Node implements Comparable<Node>{
		int x;
		int y;
		int w;
		
		public Node() {
		
		}
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
		
		
	}
	
}

