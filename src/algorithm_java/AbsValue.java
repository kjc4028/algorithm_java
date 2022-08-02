package algorithm_java;

import java.util.*;
/*
 * https://www.acmicpc.net/problem/11286
 */
class AbsValue {

	public static class ObjNum implements Comparable<ObjNum>{
		public ObjNum(){
			
		}

		public ObjNum(int num){
			setOriNum(num);
			setAbsNum(Math.abs(num));
		}
		
		private int oriNum;
		private int absNum;
		
		public void setOriNum(int oriNum){
			this.oriNum = oriNum;
		}
		
		public int getOriNum() {
			return this.oriNum;
		}

		public void setAbsNum(int absNum){
			this.absNum = absNum;
		}
		
		public int getAbsNum() {
			return this.absNum;
		}

		@Override
		public int compareTo(ObjNum o) {
			int rs = 0;
			rs = this.absNum - o.absNum; //절대값에 대하여 오름차순
			if(rs == 0) {				 //절대값이 같은 경우
				rs = this.oriNum - o.oriNum; //원래 값에 대하여 오름차순
			}
			return rs;
		}
	}
	
	public static void main(String[] args){
		//입력단 start
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt(); // 입력받을 N 값
		
		PriorityQueue<ObjNum> pQ = new PriorityQueue<ObjNum>();
		
		int inputNum = 0;
		
		for(int i =0; i<N; i++) {
			inputNum = scan.nextInt();
			if(inputNum == 0) {
				if(!pQ.isEmpty()) {
					System.out.println(pQ.poll().getOriNum());
				} else {
					System.out.println(0);
				}
			} else {
				pQ.offer(new ObjNum(inputNum));
			}
			
		}
		scan.close();
	}

}
