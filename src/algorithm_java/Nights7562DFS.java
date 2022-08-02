package algorithm_java;

import java.util.*;
/**
 * https://www.acmicpc.net/problem/7562
 * DFS 방식은 체스판 길이가 커짐에 따라서 StackOverflowError 발생하는 것 확인
 */
class Nights7562DFS {


	static int[] moveX = {2,2,-2,-2,1,-1,1,-1};
	static int[] moveY = {1,-1,1,-1,2,2,-2,-2};
	
	static int cnt = 0;
	
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); //테스트 진행 횟수
		
		for(int exCnt = 0; exCnt <N; exCnt++){
			
			int I = scan.nextInt(); //체스판 길이
			int[][] arrVChk = new int[I][I];
			
			for(int i = 0; i < I; i++){
				for(int j = 0; j < I; j++){
					arrVChk[i][j] = -1;
				}
			}
			
			int startX = scan.nextInt(); //출발Y
			int startY = scan.nextInt(); //출발Y
			int endX = scan.nextInt(); //도착X
			int endY = scan.nextInt(); //도착Y
			
			arrVChk[startX][startY] += 1;
			
			dfs(startX, startY, endX, endY, I, arrVChk);
			
			System.out.println(arrVChk[endX][endY]);
						
		}
		scan.close();
	}
	
	public static void dfs(int x, int y, int eX, int eY, int maxN, int[][] visitChk){
		System.out.println(cnt++);
			int nx = 0;
			int ny = 0;
			
			for(int i = 0; i < moveX.length; i++){
				nx = x+moveX[i];
				ny = y+moveY[i];
				if(nx >= 0 && ny >= 0 && nx < maxN && ny < maxN && (visitChk[nx][ny] == -1 || visitChk[nx][ny] > visitChk[x][y]+1)){
					visitChk[nx][ny] = visitChk[x][y]+1;
					dfs(nx, ny, eX, eY, maxN, visitChk);
				}
		}
	}

}
