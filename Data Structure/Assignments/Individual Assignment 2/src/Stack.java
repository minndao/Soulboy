public class Stack {
    private CartNode top;

    public void setTop(CartNode top) {
        this.top = top;
    }

    public void push(CartNode node) {
        if (node == null) return;
        node.next = top;
        top = node;
    }

    public CartNode pop() {
        if (top == null) return null;
        
        CartNode temp = top;
        top = top.next;
        return temp;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

