package tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack {

    List<Integer> stack;

    MinMaxStackImpl() {
        this.stack = new ArrayList<>();
    }

    @Override
    public void push(int value) {
        this.stack.add(value);
    }

    @Override
    public int pop() {
        checkEmptyStack(this.stack);
        return this.stack.removeLast();
    }

    @Override
    public int peek() {
        checkEmptyStack(this.stack);
        return this.stack.get(this.stack.size() - 1);
    }

    @Override
    public int getMin() {
        checkEmptyStack(this.stack);
        int min = this.stack.get(this.stack.size() - 1);
        for(Integer getValue : this.stack){
            if(getValue < min)
                min = getValue;
        }
        return min;
    }

    @Override
    public int getMax() {
        checkEmptyStack(this.stack);
        int max = this.stack.get(this.stack.size() - 1);
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
        return this.stack.size();
    }

    private void checkEmptyStack(List<Integer> stack){
        if(stack.isEmpty())
            throw new IllegalStateException("Stack is empty");
    }

}
