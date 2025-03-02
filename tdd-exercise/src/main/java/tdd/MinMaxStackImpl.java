package tdd;

import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack {

    Stack<Integer> stack;

    MinMaxStackImpl() {
        stack = new Stack<>();
    }

    @Override
    public void push(int value) {
        stack.push(value);
    }

    @Override
    public int pop() {
        if (stack.isEmpty())
            throw new IllegalStateException("Stack is empty");
        return stack.pop();
    }

    @Override
    public int peek() {
        return this.stack.peek();
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return 0;
    }

}
