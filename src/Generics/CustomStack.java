package Generics;

public class CustomStack<E> {

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public CustomStack() {
//        elements = (E[]) new Object[][DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }

    public void pop(){
        if (size == 0){
            throw new IllegalStateException("Stack is empty");
        }
        elements[--size] = null;
    }

    private void ensureCapacity(){
        if (elements.length == size){
            Object[] newElements = new Object[2 * size + 1];
            System.arraycopy(elements, 0, newElements, 0, size);
//            elements = newElements;
        }
    }


}
