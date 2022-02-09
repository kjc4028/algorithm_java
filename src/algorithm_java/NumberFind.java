package algorithm_java;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/1920

문제
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 
다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 
다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 
다음 줄에는 M개의 수들이 주어지는데,
이 수들이 A안에 존재하는지 알아내면 된다. 
모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

출력
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.

5
4 1 5 2 3
5
1 3 7 9 5

1
1
0
0
1

 */
public class NumberFind {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		
		int[] A = new int[N];
		int arrA = 0;
		String arrAa = "";
		scan.nextLine();
		arrAa = scan.nextLine();
		
		StringTokenizer stA = new StringTokenizer(arrAa);
		
		
		  while(stA.hasMoreTokens()){ 
			  A[arrA] = Integer.parseInt(stA.nextToken());
			  arrA++; 
		  }
		 
		
		int M = scan.nextInt();
		
		int[] B = new int[M];
	
		int arrB = 0;
		
		scan.nextLine();		//scanner 초기화
		String arrBb = scan.nextLine();
		
		StringTokenizer stB = new StringTokenizer(arrBb);
		
		while(stB.hasMoreTokens()){
			B[arrB] = Integer.parseInt(stB.nextToken());
		    arrB++;
		}
		
		int frs[] = new int[M];

		//TODO 이진검색으로 확인해야 할 것 같음...
		for(int i = 0; i<B.length; i++){
			frs[i] = 0;
			for(int j = 0; j<A.length; j++){
				if(B[i] == A[j]) {
					frs[i] = 1;
					break;
				}
			}
			System.out.println(frs[i]);
		}
		
		
		//System.out.println(Arrays.toString(frs));
	}
}

