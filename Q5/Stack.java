package assessment.games.baazi;

import java.util.LinkedList;
import java.util.Queue;


// Note to the baazi-games Reviewer: To make the Stack thread safe, I can just add synchronized keyword in front of each method 
// i.e syncronized keyword in front of push, pop, peek, isEmpty, and size

public class Stack<T> {

    private Queue<T> queue1;
    private Queue<T> queue2;
    Stack() {
        queue1 = new LinkedList<T>();
        queue2 = new LinkedList<T>();
    }

    public void push(T item) {
        queue1.add(item);
    }

    public T pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        while (queue1.size() > 1) {
            T item = queue1.remove();
            queue2.add(item);
        }

        T item = queue1.remove();

        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return item;
    }

    public T peek() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        while (queue1.size() > 1) {
            T item = queue1.remove();
            queue2.add(item);
        }

        T item = queue1.remove();

        queue1.add(item);

        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return item;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public int size() {
        return queue1.size();
    }
}