package dk.kea;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class DuckRace {
    ArrayList<Queue<Integer>> myList;
    ArrayList<Queue<Integer>> myList2;

    public DuckRace(int number){
        myList = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < number; i++){
            Queue<Integer> myQueue = new LinkedList<>();
            for (int j = 0; j < number; j++){
                myQueue.add(count);
                count++;
            }
            myList.add(myQueue);
        }
        for (Queue<Integer> a : myList){
            System.out.println(a);
        }
        System.out.println();
        startRace();
    }

    public void startRace(){
        myList2 = new ArrayList<>();
        for (int i = 0; i < myList.size()-1; i++){
            Queue<Integer> myQueue = new LinkedList<>();
            for (int j = 0; j < myList.size()-1; j++) {
                Random rand = new Random();
                int randNum = rand.nextInt(myList.size());
                while (myList.get(randNum).peek() == null) {
                    randNum = rand.nextInt(myList.size());
                }
                myQueue.add(myList.get(randNum).poll());
            }
            myList2.add(myQueue);
        }
        for (Queue<Integer> a : myList2){
            System.out.println(a);
        }
        System.out.println();
        if (myList.size() != 1){
            myList = myList2;
            startRace();
        }
    }
}
