package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ2666
 * 
 *
테스트 입력
7
2 5
4
3
1
6
5
출력 (문의 최소 이동횟수)
5

첫 번째 줄에 벽장의 개수를 나타내는 3보다 크고 20보다 작거나 같은 하나의 정수, 
두 번째 줄에 초기에 열려있는 두 개의 벽장을 나타내는 두 개의 정수, 
그리고 세 번째 줄에는 사용할 벽장들의 순서의 길이(최대 20), 
그리고 그 다음줄부터 사용할 벽장의 번호가 한줄에 하나씩 순서대로 주어진다.

DFS
 */
public class BOJ2666 {

    // 사용할 문의 개수
    static int useDoorCnt;
    // 사용할 문의 목록
    static int[] useDoorRoor;
    
    public static void main(String[] args) throws Exception{
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 문의 개수
        int N = Integer.parseInt( br.readLine());
                
        // 열린 문의 순서 (2개로 고정)
        int[] openDoor = new int[2];
        
        st = new StringTokenizer(br.readLine(), " ");
        
        openDoor[0] = Integer.parseInt(st.nextToken());
        openDoor[1] = Integer.parseInt(st.nextToken());
        
        // 사용할 문의 개수
        useDoorCnt = Integer.parseInt( br.readLine());
        
        // 사용할 문의 목록
        useDoorRoor = new int[useDoorCnt];
        
        // 문을 열어야하는 순번 입력
        for (int i = 0; i < useDoorCnt; i++) {
            useDoorRoor[i] = Integer.parseInt( br.readLine());
        }
        
        System.out.println(dfs(0, openDoor[0], openDoor[1]));
        
    }
    
    public static int dfs(int index, int openDoorFirst, int openDoorSecond){
        
        // 전부 확인 끝난 경우
        if(index == useDoorCnt){
            return 0;
        }
        
        // 첫번째 열린문 선택한 경우
        int caseFisrtSelectLength = Math.abs(openDoorFirst - useDoorRoor[index]);
        
        //두번째 열린문 선택한 경우
        int caseSecondSelectLength = Math.abs(openDoorSecond - useDoorRoor[index]);
        
        //현재 문에 대하여 첫번째 열린문 선택한 경우 이동길이 + 다음 문에 대하여 두번째 열린문(지금 선택하지 않았기 때문)과 현재문(지금 열린상태이기때문)의 길이를 구함
        //현재 문에 대하여 두번째 열린문 선택한 경우 이동길이 + 다음 문에 대하여 첫번째 열린문(지금 선택하지 않았기 때문)과 현재문(지금 열린상태이기때문)의 길이를 구함
        return Math.min(
            caseFisrtSelectLength + dfs(index+1,openDoorSecond,useDoorRoor[index]),
            caseSecondSelectLength + dfs(index+1, openDoorFirst, useDoorRoor[index])
        );
    }
    
}