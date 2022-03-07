package algorithm_java;

import java.util.*;
/**
 * https://www.acmicpc.net/problem/7562
 */
class Nights7562 {

	public static class Node{
		public Node(){
			
		}
		
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}

		private int x;
		private int y;
		
		public int getX(){
			return this.x;
		}

		public int getY(){
			return this.y;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); //테스트 진행 횟수
		
		int[] moveX = {2,2,-2,-2,1,-1,1,-1};
		int[] moveY = {1,-1,1,-1,2,2,-2,-2};
		
		for(int exCnt = 0; exCnt <N; exCnt++){
			
			int I = scan.nextInt(); //체스판 길이
			int[][] arrVChk = new int[I][I];
			
			for(int i = 0; i < I; i++){
				for(int j = 0; j < I; j++){
					arrVChk[i][j] = -1;
				}
			}
			
			int startInt1 = scan.nextInt(); //출발
			int startInt2 = scan.nextInt(); //출발
			
			int endInt1 = scan.nextInt(); //도착
			int endInt2 = scan.nextInt(); //도착
			
			Queue<Node> que = new LinkedList<Node>();
			
			que.add(new Node(startInt1, startInt2)); //출발지점
			arrVChk[startInt1][startInt2] += 1; //출발지점
			Node targetQue = null;
			
			while(!que.isEmpty()){
				targetQue = que.poll();
				//도착확인
				if(targetQue.getX() == endInt1 && targetQue.getY() == endInt2){
					break;
				}
				
				for(int i =0; i<moveX.length; i++){
					if(targetQue.getX()+moveX[i] < I && targetQue.getY()+moveY[i] < I &&
					   targetQue.getX()+moveX[i] >= 0 && targetQue.getY()+moveY[i] >= 0 &&
						(arrVChk[targetQue.getX()+moveX[i]][targetQue.getY()+moveY[i]] == -1 || 
						 arrVChk[targetQue.getX()][targetQue.getY()]+1 < (arrVChk[targetQue.getX()+moveX[i]][targetQue.getY()+moveY[i]]))){ //아직 방문을 하지 않은 경우 또는 이동 하였을 경우 현재 이동횟수 +1 보다 작은 경우
							que.add(new Node(targetQue.getX()+moveX[i],targetQue.getY()+moveY[i]));
							arrVChk[targetQue.getX()+moveX[i]][targetQue.getY()+moveY[i]] = arrVChk[targetQue.getX()][targetQue.getY()] +1;
						}
				}
			}
			System.out.println(arrVChk[endInt1][endInt2]);			
		}
	}	

}
