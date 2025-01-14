package work.icu007.day05.datastructure.stack;

public class StackDemo01<E> {
    private E[] items;
    private int top;
    private int capacity;

    public StackDemo01() {
    }

    public StackDemo01(int capacity) {
        this.capacity = capacity;
        this.items = (E[]) new Object[this.capacity];
        this.top = 0;
    }

    public void push(E e) throws Exception {
        if (!isFull()) {
            items[top++] = e;
            resize();
        } else {
            throw new Exception();
        }
    }

    public E pop() throws Exception {
        if (top == 0) {
            throw new Exception();
        } else {
            E ret = items[--top];
            items[top] = null;
            System.out.println(ret + " 出栈");
            return ret;
        }
    }

    public void resize() {
        if (isFull()) {
            System.out.println("stack[top = " + capacity + "]: " + items[top - 1] + " 已满");
            this.capacity = this.capacity * 2;
            System.out.println("扩容为" + this.capacity);
        }
        // 迁移数据
        E[] newItems = (E[]) new Object[this.capacity];
        if (top >= 0) System.arraycopy(items, 0, newItems, 0, top);
        items = newItems;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == capacity;
    }

    public int size() {
        return top;
    }

    public static void main(String[] args) throws Exception {
        StackDemo01<Integer> stack = new StackDemo01<>(2);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.pop();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.pop();
    }
}
