package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;


public class BOJ11779 {

	static class City implements Comparable<City>{
		
		int nextCityNum;
		
		int cost;
		
		public City() {

		}
		
		public City(int cityNum, int weight) {
			this.nextCityNum = cityNum;
			this.cost = weight;
		}

		@Override
		public int compareTo(City o) {
			return this.cost - o.cost;
		}
	}
	
	static List<ArrayList<City>> cityList = new ArrayList<>();
	static int[] costArr;
	static int[] preCityNum;
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		costArr = new int[N+1];
		preCityNum = new int[N+1];

		Arrays.fill(costArr, Integer.MAX_VALUE);
		
		
		for (int i = 0; i < N+1; i++) {
			cityList.add(new ArrayList<City>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int moveCost = Integer.parseInt(st.nextToken());
			cityList.get(from).add(new City(to, moveCost));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		
		dijkstra(start);
		
		System.out.println(costArr[end]);
		
		Stack<Integer> stack = new Stack<>(); 
		stack.push(end);
		int cnt = 0;
		while(preCityNum[end] != 0){
			stack.push(preCityNum[end]);
			end = preCityNum[end];
			cnt += 1;
		}
		
		System.out.println(cnt+1);
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
		
		
		
	}
	
	public static void dijkstra(int start){
		PriorityQueue<City> pq = new PriorityQueue<>();
		pq.add(new City(start, 0));
		costArr[start] = 0;
		
		while(!pq.isEmpty()){
			City currCity = pq.poll();
			int curCityNum = currCity.nextCityNum;
			if(costArr[curCityNum] < currCity.cost){
				continue;
			}
			
			for (City city : cityList.get(curCityNum)) {
				if(costArr[city.nextCityNum] > costArr[curCityNum] + city.cost){
					costArr[city.nextCityNum] = costArr[curCityNum] + city.cost;
					preCityNum[city.nextCityNum] = curCityNum;
					pq.offer(new City(city.nextCityNum, costArr[city.nextCityNum]));
				}
			}
		}
		
		
		
	}
}
