package Stack;

public class UndoBuffer {
    private String[] data;
    private int top;
    public UndoBuffer(int maxDepth) {
        data = new String[maxDepth];
        top = -1;
    }
    public boolean push(String edit) {
        if (top == data.length - 1) {
            System.out.println("Undo buffer is full.");
            return false;
        }

        data[++top] = edit;
        return true;
    }
    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Nothing to undo.");
        }

        return data[top--];
    }
    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Undo buffer is empty.");
        }

        return data[top];
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Undo buffer is empty.");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(data[i]);
        }
    }
    public static void main(String[] args) {
        UndoBuffer buffer = new UndoBuffer(5);
        buffer.push("Typed Hello");
        buffer.push("Typed World");
        buffer.push("Deleted World");
        buffer.display();
        System.out.println("Latest Edit: " + buffer.peek());
        System.out.println("Undo: " + buffer.pop());
        buffer.display();
    }
}