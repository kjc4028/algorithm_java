import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Z10845 {
 
	public static void main(String[] args) throws Exception{
		Deque<String> dq = new ArrayDeque<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push")){
				String pushNum = st.nextToken();
				dq.addFirst(pushNum);
			} else if(cmd.equals("pop")){
				if(dq.isEmpty()){
					sb.append("-1").append("\n");
				} else {
					sb.append(dq.pollLast()).append("\n");
				}
			} else if(cmd.equals("size")){
				sb.append(dq.size()).append("\n");
			} else if(cmd.equals("empty")){
				if(dq.isEmpty()){
					sb.append("1").append("\n");
				} else { 
					sb.append("0").append("\n");
				}
			} else if(cmd.equals("front")){
				if(dq.isEmpty()){
					sb.append("-1").append("\n");
				} else {
					sb.append(dq.peekLast()).append("\n");
				}
			} else if(cmd.equals("back")){
				if(dq.isEmpty()){
					sb.append("-1").append("\n");
				} else {
					sb.append(dq.peekFirst()).append("\n");
				}								
			}
		}
		
		
	System.out.println(sb.toString());	
	}
	
}
