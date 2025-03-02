package tdd;

import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack {

    Stack<Integer> stack;

    MinMaxStackImpl() {
        this.stack = new Stack<>();
    }

    @Override
    public void push(int value) {
        this.stack.push(value);
    }

    @Override
    public int pop() {
        if (this.stack.isEmpty())
            throw new IllegalStateException("Stack is empty");
        return this.stack.pop();
    }

    @Override
    public int peek() {
        if (this.stack.isEmpty())
            throw new IllegalStateException("Stack is empty");
        return this.stack.peek();
    }

    @Override
    public int getMin() {
        if(this.stack.isEmpty())
            throw new IllegalStateException("Stack is empty");
        int min = this.stack.peek();
        for(Integer getValue : this.stack){
            if(getValue < min)
                min = getValue;
        }
        return min;
    }

    @Override
    public int getMax() {
        int max = this.stack.peek();
        for(Integer getValue : this.stack){
            if(getValue > max)
                max = getValue;
        }
        return max;
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
