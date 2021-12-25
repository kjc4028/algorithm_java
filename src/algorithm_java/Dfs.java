package algorithm_java;

import java.util.ArrayList;

public class Dfs {

	static String arrbase[] = new String[7];
	static int arr[][] = new int[7][7];
	static boolean[] vchk = new boolean[7];	
	static int rs =0;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
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
	
	static void dfs(int start){
		
		vchk[start] = true;
		arrbase[start] = rs+"";
		rs++;
		list.add(start);
		for(int i=0; i< 7; i++){
			if(arr[start][i] == 1 && vchk[i] == false){
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) {
		//초기화
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				//arrbase[i][j] = ""+i+j;
				//arrbase[i][j] = "0";
				arr[i][j] = 0;
				vchk[i] = false;
			}
		}
/* 그래프		
			0
	1				2
3		4		5		6
*/		
		//값 셋팅
		arr[0][1] = 1;
		arr[0][2] = 1;
		
		//arr[1][2] = 1;
		arr[1][3] = 1;
		arr[1][4] = 1;

		arr[2][5] = 1;
		arr[2][6] = 1;

		//상태 확인
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		dfs(0);
		
		System.out.println();
		
		System.out.println(list.toString());
		//System.out.println(Arrays.toString(arrbase) );
		
	}
}
