package dk.kea;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    Queue<Integer> duckQueue;

    public MyQueue(){
        duckQueue = new LinkedList<>();
    }

    public void add(int number){
        duckQueue.add(number);
    }

    public void remove(){
        duckQueue.remove();
    }

    public int size(){
        return duckQueue.size();
    }
}
