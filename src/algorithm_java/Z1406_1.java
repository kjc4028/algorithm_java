import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Z1406_1 {
	public static void main(String[] args) throws Exception {
		
		LinkedList<String> ll = new LinkedList<>();
		ListIterator<String> iter = ll.listIterator();
		int cmdN = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
			
		String[] baseStr = br.readLine().split(""); //java7버전은 배열 가장 앞에 빈값이 존재
		
		for (int i = 0; i < baseStr.length; i++) {
			iter.add(baseStr[i]); //초기값 셋팅
		}
		
        while(iter.hasNext()){
            iter.next(); //커서 가장 뒤로 초기화
        }

		cmdN = Integer.parseInt(br.readLine());

		for (int i = 0; i < cmdN; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("L")){
				if(iter.hasPrevious()){
					iter.previous();
				}
			} else if (cmd.equals("D")){
				if(iter.hasNext()){
					iter.next();
				}
			} else if (cmd.equals("B")){
				if(iter.hasPrevious()){
					iter.previous();
					iter.remove();
				}
			} else if (cmd.equals("P")){
				iter.add(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();
		
		while(iter.hasPrevious()){ //인덱스 초기화
			iter.previous();
		}
		
		while(iter.hasNext()){
			sb.append(iter.next());
		}
		

		System.out.println(sb.toString());
		
	}
}
