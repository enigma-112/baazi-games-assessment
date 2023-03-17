package assessment.games.baazi;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop()); // prints 3
        System.out.println(stack.pop()); // prints 2
        System.out.println(stack.peek()); // prints 1
        System.out.println(stack.isEmpty()); // prints true
    }
}
