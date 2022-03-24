package Mogacko.Heap;

// 2차원 배열을 이용하기 위해 작업내용을 int 형태로 바꿈
public class HeapQuiz3 {
    public static void main(String[] args) {
        PriorityQueue3 priorityQueue = new PriorityQueue3();
//        priorityQueue.insert(9, "JAVA 익히기");
//        priorityQueue.insert(6, "파이썬 프로젝트 시작하기");
//        priorityQueue.insert(10, "파이썬 챗봇과정 학습");
//        priorityQueue.insert(1, "코드메이트에 포스트 작성");
//        priorityQueue.insert(5, "자료구조 학습");
//        priorityQueue.insert(2, "모각코 출석");

        priorityQueue.insert(9, 900);
        priorityQueue.insert(6, 600);
        priorityQueue.insert(10, 1000);
        priorityQueue.insert(1, 100);
        priorityQueue.insert(5, 500);
        priorityQueue.insert(2, 200);

        for (int i = 1; i < priorityQueue.queue_count+1; i++) {
            System.out.println("우선 순위 : " + priorityQueue.arr[i][0] + ", 작업 종료 : " + priorityQueue.arr[i][1]);
        }

        System.out.println("POP : " + priorityQueue.pop());
        System.out.println("POP : " + priorityQueue.pop());
        System.out.println("POP : " + priorityQueue.pop());

        for (int i = 1; i < priorityQueue.queue_count+1; i++) {
            System.out.println("우선 순위 : " + priorityQueue.arr[i][0] + ", 작업 종료 : " + priorityQueue.arr[i][1]);
        }
    }
}
