import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
6 6
...#..
.##v#.
#v.#.#
#.k#.#
.###.#
...###

9 12 
.###.#####.. 
#.kk#...#v#. 
#..k#.#.#.#. 
#..##k#...#. 
#.#v#k###.#. 
#..#v#....#. 
#...v#v####. 
.####.#vv.k# 
.......####. 
3 5

 8 8 
.######. 
#..k...# 
#.####.# 
#.#v.#.# 
#.#.k#k# 
#k.##..# 
#.v..v.# 
.######.
3 1

 */
public class Z3187 {

	
	static int totalV = 0; //전체 늑대 수
	static int totalK = 0; //전체 양 수
	static char[][] arr;
	static boolean[][] visit;
	static int[] moveX = {0,1,0,-1}; //상 우 하 좌 시계방향으로 검증
	static int[] moveY = {1,0,-1,0};
	static int R = 0;
	static int C = 0;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken()); //가로
		C = Integer.parseInt(st.nextToken()); //세로
		
		arr = new char[R][C];
		visit = new boolean[R][C];
		
		
		//입력값 셋팅
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < st.countTokens(); j++) {
				arr[i] = st.nextToken().toCharArray();
				visit[i][j] = false;
			}
		}
		
		//검증로직구현 BFS 큐 활용
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				//검증 패스 : 이미 방문한 경우, 울타리인 경우
				//검증 진행 : 방문하지 않았거나 울타리가 아닌경우
				if(!visit[i][j] && arr[i][j] != '#'){
					valid(i,j);
				}
			}
			
		}
		
		System.out.println(totalK  + " " +  totalV);
		
	}
	
	//검증로직
	public static void valid(int x, int y){
		//한번의 bfs는 하나의 울타리 범위에서 진행 하고 울타리안에 방문하지 않은곳이 없다면 
		//양과 늑대의 숫자를 비교하여 저장하고 다음 울타리를 찾는다
		Queue<Node> que = new LinkedList<>();
		visit[x][y] = true; //방문처리
		Node node = new Node(x, y);
		que.add(node);
		
		int tempVcnt = 0; //임시 늑대 건수
		int tempKcnt = 0; //임시 양 건수
		
		while(!que.isEmpty()){
			//현재 위치에서 상 하 좌 우 검증을 해야한다면 큐에 추가
			//다음 이동 부분이 이동 가능한지 검증, 울타리가 아니어야함, 방문하지 않은 곳
			Node node2 = que.poll();
			int curx = node2.x;
			int cury = node2.y;
			
			if(arr[curx][cury] == 'v'){
				tempVcnt++;
			}
			if(arr[curx][cury] == 'k'){
				tempKcnt++;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = curx + moveX[i];
				int ny = cury + moveY[i];
				if(nx >= 0 && nx < R && ny >= 0 && ny < C && !visit[nx][ny] && arr[nx][ny] != '#'){
					visit[nx][ny] = true;
					
					if(arr[nx][ny] == '.'){
						que.add(new Node(nx, ny));
					}
					if(arr[nx][ny] == '#'){
						continue;
					}
					if(arr[nx][ny] == 'v'){
						que.add(new Node(nx, ny));
					}
					if(arr[nx][ny] == 'k'){
						que.add(new Node(nx, ny));
					}
					
				}
			}
		}
		
		
		//양 늑대 값 비교하여 저장
		if(tempKcnt > tempVcnt){
			totalK += tempKcnt;
		} else {
			totalV += tempVcnt;
		}
	}
	
	//좌표
	public static class Node{
		int x;
		int y;
		
		public Node() {
		}

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
}
