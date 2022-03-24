package Mogacko.Heap;

// 2개의 다른 데이터를 저장하기 위해 QueueNode라는 클래스에서 객체를 생성해
// 우선순위와 작업내용을 저장한 방식
public class HeapQuiz2 {
    public static void main(String[] args) {
        PriorityQueue2 priorityQueue = new PriorityQueue2();
        priorityQueue.insert(new QueueNode(9, "JAVA 익히기"));
        priorityQueue.insert(new QueueNode(6, "파이썬 프로젝트 시작하기"));
        priorityQueue.insert(new QueueNode(10, "파이썬 챗봇과정 학습"));
        priorityQueue.insert(new QueueNode(1, "코드메이트에 포스트 작성"));
        priorityQueue.insert(new QueueNode(5, "자료구조 학습"));
        priorityQueue.insert(new QueueNode(2, "모각코 출석"));

        for (int i = 1; i < priorityQueue.queue_count+1; i++) {
            System.out.println("우선 순위 : " + priorityQueue.arr[i].priority + ", 작업 종료 : " + priorityQueue.arr[i].data);
        }

        System.out.println("POP : " + priorityQueue.pop());
        System.out.println("POP : " + priorityQueue.pop());
        System.out.println("POP : " + priorityQueue.pop());

        for (int i = 1; i < priorityQueue.queue_count+1; i++) {
            System.out.println("우선 순위 : " + priorityQueue.arr[i].priority + ", 작업 종료 : " + priorityQueue.arr[i].data);
        }
    }
}
