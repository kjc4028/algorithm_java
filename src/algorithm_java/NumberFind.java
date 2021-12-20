package algorithm_java;

import java.util.Arrays;
import java.util.Scanner;

/*
https://www.acmicpc.net/problem/1920

문제
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

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
		scan = new Scanner(System.in);
		
		int[] A = new int[N];
		
		for(int i =0; i<N; i++){
			A[i] = scan.nextInt();
		}
		
		scan = new Scanner(System.in);
		int M = scan.nextInt();
		
		int[] B = new int[M];
		
		for(int i =0; i<M; i++){
			B[i] = scan.nextInt();
		}
		
		scan.close();
		
		int rs[] = new int[231];
		int frs[] = new int[M];
		
		//A 값
		for(int i = 0; i<A.length; i++){
			rs[A[i]] = 1;
		}

		//B 값
		for(int i = 0; i<B.length; i++){
			rs[B[i]] += 1;
		}

		//frs 값
		for(int i = 0; i<frs.length; i++){
			if(rs[B[i]] == 2){
				frs[i] = 1;
			} else {
				frs[i] = 0;
			}
		}
		
		System.out.println(Arrays.toString(frs));
		
		
	}
}

