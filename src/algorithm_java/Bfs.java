package algorithm_java;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {

	static String arrbase[][] = new String[7][7];
	static int arr[][] = new int[7][7];
	static boolean[][] vchk = new boolean[7][7];
	
	static class Node{
		int num;
		int x;
		int y;
		
		Node(int num, int x, int y){
			this.num = num;
			this.y = y;
			this.x = x;
		}

		Node(int x, int y){
			this.y = y;
			this.x = x;
		}
	}
	
	static void bfs(int start, int end){
		Queue q = new LinkedList();
		
		q.add(new Node(start, end));
		int i = 1;
		while(!q.isEmpty()){
				Node node = (Node) q.poll();
				vchk[node.x][node.y] = true;
				//vchk[node.y][node.x] = true;
				arrbase[node.x][node.y] = ""+i;
				i++;
				//arrbase[node.y][node.x] = "*";
				if(node.x+1 >= 0 && node.x+1 < 7 && arr[node.x+1][node.y] == 1 && !vchk[node.x+1][node.y]){
					q.add(new Node(node.x+1, node.y));
				}
				if(node.x-1 >= 0 && node.x-1 < 7 && arr[node.x-1][node.y] == 1 && !vchk[node.x-1][node.y]){
					q.add(new Node(node.x-1, node.y));
				}
				if(node.y+1 >= 0 && node.y+1 < 7 && arr[node.x][node.y+1] == 1 && !vchk[node.x][node.y+1]){
					q.add(new Node(node.x, node.y+1));
				}
				if(node.y-1 >= 0 && node.y-1 < 7 && arr[node.x][node.y-1] == 1 && !vchk[node.x][node.y-1]){
					q.add(new Node(node.x, node.y-1));
				}
		}
	}
	
	public static void main(String[] args) {
		
		//초기화
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				//arrbase[i][j] = ""+i+j;
				arrbase[i][j] = "0";
				arr[i][j] = 0;
				vchk[i][j] = false;
			}
		}
		
		//값 셋팅
		arr[0][1] = 1;
		arr[0][2] = 1;
		
		arr[1][0] = 1;
		arr[1][2] = 1;
		arr[1][3] = 1;
		arr[1][4] = 1;

		arr[2][0] = 1;
		arr[2][1] = 1;
		//arr[2][4] = 1;
		arr[2][5] = 1;
		arr[2][6] = 1;

		arr[3][1] = 1;

		arr[4][1] = 1;
		//arr[4][2] = 1;

		arr[5][2] = 1;
		
		arr[6][2] = 1;
		
		//상태 확인
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		vchk[0][0] = true;
		bfs(0,0);

		System.out.println();
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				System.out.print(arrbase[i][j] + " ");
			}
			System.out.println();
		}
	}
}
