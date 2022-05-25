package algorithm_java;

import java.util.Scanner;

/*
문제
재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 
크기 N의 패턴은 N×N 정사각형 모양이다.

크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.

***
* *
***
N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 
둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.

입력
첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.

출력
첫째 줄부터 N번째 줄까지 별을 출력한다.

27

***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
*********         *********
* ** ** *         * ** ** *
*********         *********
***   ***         ***   ***
* *   * *         * *   * *
***   ***         ***   ***
*********         *********
* ** ** *         * ** ** *
*********         *********
***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
 */
public class Z2447 {

	static char[][] arr; 
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		arr = new char[N][N];
		
		draw(0,0,N,false);
		
		// for (int i = 0; i < N; i++) {
		// 	System.out.println();
		// 	for (int j = 0; j < N; j++) {
		// 		System.out.print(arr[i][j]);
		// 	}
		// }

        StringBuffer bf = new StringBuffer();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bf.append(arr[i][j]);
			}
			bf.append("\n");
		}
		
		System.out.println(bf.toString());
		
	}
	
	
	//9 > 3(1번째) > 1(9개)
	//9 > 3(2번쨰) > 1(9개)
	//...
	//...
	//...
	//9 > 3(9번쨰) > 1(9개)
	//순서
	public static void draw(int x, int y, int N, boolean spaceYn){
		
		//System.out.println("x : " + x + " y : " + y + " n : " + N + " space : " + spaceYn);
		
		if(spaceYn){
			for (int i = x; i < x+N; i++) {
				for (int j = y; j < y+N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		
		if(N == 1){
			arr[x][y] = '*';
			return;
		};
		
		int size = N/3; //3의 배수 나눔
		int spaceStart = 0;
		
		for (int i = x; i < (x+N); i=i+size) {
			for (int j = y; j < (y+N); j=j+size) {
				spaceStart++;
				
				if(spaceStart == 5){ //5번쨰 패턴이 가운데 이기때문
					draw(i,j,size,true); //공백
				}else{
					draw(i,j,size,false); //*
				}
			}
		}
		
		
		
	}
}

