package Stack;

public class CallStack {
    private static class Frame {
        String functionName;
        Frame next;

        Frame(String functionName, Frame next) {
            this.functionName = functionName;
            this.next = next;
        }
    }
    private Frame top;
    public CallStack() {
        top = null;
    }
    public void push(String functionName) {
        top = new Frame(functionName, top);
    }
    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("No active function.");
        }
        String name = top.functionName;
        top = top.next;
        return name;
    }
    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Call stack is empty.");
        }
        return top.functionName;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Call stack is empty.");
            return;
        }
        Frame temp = top;
        while (temp != null) {
            System.out.println(temp.functionName);
            temp = temp.next;
        }
    }
    public static void main(String[] args){
        CallStack stack = oew CallStack();
        stack.push("main()");
        stack.push("login()");
        stack.push("validateUser()");
        stack.display();
        System.out.println("Current Function: " + stack.peek());
        System.out.println("Returned From: " + stack.pop());
        stack.display();
    }
}
