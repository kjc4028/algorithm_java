package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
입력
5
3 4
1 1
1 -1
2 2
3 3

출력
1 -1
1 1
2 2
3 3
3 4 


6
3 4
1 1
1 -1
2 2
3 3
3 1

* 테스트 케이스 추가
y가 x 값보다 작은 케이스
 */

class Pair{
    int x,y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return this.x+" "+this.y;
    }

}

public class BOJ11650_Comparator_Lamda {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        ArrayList<Pair> pairList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int ix = Integer.parseInt(st.nextToken());
            int iy = Integer.parseInt(st.nextToken());
            pairList.add(new Pair(ix,iy));
        }

        pairList.sort((a,b) -> {
            if(a.x == b.x){
                return Integer.compare(a.y, b.y);    
            } else {
                return Integer.compare(a.x, b.x);
            }
        });

        for (Pair pair : pairList) {
            System.out.println(pair.toString());
        }

    }
}
