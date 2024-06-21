package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
3
0 40
15 30
5 10

2
---
2
10 20
5 10

1
 */
 /*
PQ 활용한 스위핑 방식
PQ 사용
Comparable<MeetTime> implements
 */
public class BOJ19598 {
    
    static class MeetTime implements Comparable<MeetTime>{
		int start;
		int end;

		public MeetTime(int x, int y) {
			this.start = x;
			this.end = y;
		}
		
        public int getEnd() {
            return end;
        }
        
        public int getStart() {
            return start;
        }
        
		@Override
		public String toString() {
			return start + " : " + end;
		}

        @Override
        public int compareTo(MeetTime o) {
            if(this.start == o.start){
                return this.end -o.end;
            } else {
                return this.start-o.start;
            }         
        }
	}
    
    public static void main(String[] args) throws Exception {
		
		int N;
		
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
        PriorityQueue<MeetTime> pqTime = new PriorityQueue<MeetTime>();
        PriorityQueue<Integer> pqRoom = new PriorityQueue<Integer>(); //종료시간을 기준으로 오름차순 정렬을 위해 Integer type 선언
        
        
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
            pqTime.add(new MeetTime(x,y));
		}
        
        pqRoom.add(pqTime.poll().getEnd());
        
        //종료시간이 긴 경우 다음 회의시간이 범위 내에 여부를 판단할수 있어야함
        while(!pqTime.isEmpty()){
            MeetTime currTime = (MeetTime) pqTime.poll();
            if(pqRoom.peek() <= currTime.getStart()){
                pqRoom.poll();
            }
            pqRoom.add(currTime.getEnd());
        }
        
        System.out.println(pqRoom.size());
        
		
    }
}
