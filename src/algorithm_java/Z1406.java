import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//삽입 삭제 시 LinkedList의 기본 동작 방식으로 처리 속도가 다소 느림 
public class Z1406 {
	public static void main(String[] args) throws Exception{
		LinkedList<String> ll = new LinkedList<>();
		int cursor = 0;
		int cmdN = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
			
		String[] baseStr = br.readLine().split(""); //java7버전은 배열 가장 앞에 빈값이 존재
		
		for (int i = 1; i < baseStr.length; i++) {
			ll.add(baseStr[i]);
		}
		
		cursor = ll.size();
		
		
		cmdN = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < cmdN; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("L")){
				if(cursor-1 >= 0){
					cursor -= 1;
				}
			} else if (cmd.equals("D")){
				if(cursor+1<=ll.size()){
					cursor += 1;
				}
			} else if (cmd.equals("B")){
				if(cursor-1 >= 0){
					ll.remove(cursor-1);
					cursor -= 1;
				}
			} else if (cmd.equals("P")){
				ll.add(cursor, st.nextToken());
				cursor += 1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ll.size(); i++) {
			sb.append(ll.get(i));
		}

		System.out.println(sb.toString());

		
	}
	
}

