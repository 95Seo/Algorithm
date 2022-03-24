package Mogacko.Heap;

// 우선 순위 큐 구현
// 우선 순위와 작업의 종류가 공백으로 구분되어 주어질 때
// 모든 데이터를 삽입하고,
// 데이터 추출을 3번 진행해 어떤 작업을 먼저 실행해야 하는지 출력
public class HeapQuiz1 {
    public static void main(String[] args) {
        PriorityQueue1 priorityQueue = new PriorityQueue1();
        priorityQueue.insert(9, "JAVA 익히기");
        priorityQueue.insert(6, "파이썬 프로젝트 시작하기");
        priorityQueue.insert(10, "파이썬 챗봇과정 학습");
        priorityQueue.insert(1, "코드메이트에 포스트 작성");
        priorityQueue.insert(5, "자료구조 학습");
        priorityQueue.insert(2, "모각코 출석");

        for (int i = 1; i < priorityQueue.queue_count+1; i++) {
            System.out.println("우선 순위 : " + priorityQueue.priority_arr[i] + ", 작업 종료 : " + priorityQueue.data_arr[i]);
        }

        System.out.println("POP : " + priorityQueue.pop());
        System.out.println("POP : " + priorityQueue.pop());
        System.out.println("POP : " + priorityQueue.pop());
        for (int i = 1; i < priorityQueue.queue_count+1; i++) {
            System.out.println("우선 순위 : " + priorityQueue.priority_arr[i] + ", 작업 종료 : " + priorityQueue.data_arr[i]);
        }
    }
}
