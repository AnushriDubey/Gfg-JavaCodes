import java.util.Stack;

public class ReverseStack {
    static Stack<Integer> stk;

    static void reverseStack() {
        if(stk.isEmpty()) return;
        int prev = stk.peek();
        stk.pop();
        reverseStack();
        stk.push(prev);
    }

    public static void main(String args[]) {
        stk = new Stack<>();
        stk.push(1);stk.push(2);stk.push(3);
        reverseStack();
        System.out.println(stk);
    }
}
