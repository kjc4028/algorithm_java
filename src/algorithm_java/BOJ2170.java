package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2170 {

	 static class Line{
		int x;
		int y;

		public Line(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return x + " : " + y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		int N;
		
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		Line[] arr = new Line[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Line(x,y);
		}
		
/*		Arrays.sort(arr, new Comparator<Line>() {
			@Override
			public int compare(Line o1, Line o2) {
				if (o1.x == o2.x) {
					return o1.y - o2.y;
				} else {
					return o1.x - o2.x;
				}
			}
		});*/
		
		Arrays.sort(arr, (o1,o2) -> {
				if(o1.x == o2.x){
					return o1.y - o2.y;
				} else {
					return o1.x - o2.x;
				}
			}
		);

//		for (Line line : arr) {
//			System.out.println(line.toString());
//		}
		
		int prevStart = arr[0].x;
		int prevEnd = arr[0].y;
		
		int lineLen = prevEnd-prevStart;
		
		for (int i = 0; i < arr.length; i++) {
			int currStart = arr[i].x;
			int currEnd = arr[i].y;
			
			//이전라인 끝이 현재 라인보다 큰 경우
			if(prevEnd >= currEnd){
				continue;
			//이전라인 끝이 현재라인 내에 포함되는 경우 
			} else if(prevEnd > currStart && prevEnd < currEnd){
				lineLen += currEnd - prevEnd;
				prevEnd = currEnd;
			//이전 라인의 끝이 현재 라인보다 이전에 있는 경우 (안겹침)
			} else {
				lineLen += currEnd - currStart;
				prevEnd = currEnd;
			}
		}
		
		System.out.println(lineLen);
		
	}
}