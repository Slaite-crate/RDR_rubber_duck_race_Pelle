package dk.kea;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class DuckRace {

    ArrayList<Queue<Integer>> myList;
    ArrayList<Queue<Integer>> myList2;

    public DuckRace(int number) {
        myList = makeDucks(number);
        while (myList.size() > 1) {
            myList = addDucks(myList);
            System.out.println(this);
        }
    }

    public ArrayList<Queue<Integer>> makeList(int rows) {
        ArrayList<Queue<Integer>> duckList = new ArrayList<>();
        while (duckList.size() < rows) {
            duckList.add(new LinkedList<>());
        }
        return duckList;
    }

    public ArrayList<Queue<Integer>> makeDucks(int ducks) {
        ArrayList<Queue<Integer>> duckList = new ArrayList<>();
        int count;
        for (int i = 1; i <= ducks; i++) {
            count = i;
            Queue<Integer> myQueue = new LinkedList<>();
            for (int j = 1; j <= ducks; j++) {
                myQueue.add(count);
                count += 10;
            }
            duckList.add(myQueue);
        }
        return duckList;
    }

    public ArrayList<Queue<Integer>> addDucks(ArrayList<Queue<Integer>> duckList) {
        myList2 = makeList(duckList.size() - 1);
        Random random = new Random();
        for (int i = 0; i < myList2.size() * myList2.size(); i++) {
            int randomNumber = random.nextInt(duckList.size());
            while (duckList.get(randomNumber).peek() == null) {
                if (duckList.get(randomNumber).peek() == null){
                    duckList.remove(randomNumber);
                }
                randomNumber = random.nextInt(duckList.size());
            }
            int randomNumber2 = random.nextInt(myList2.size());
            while (myList2.get(randomNumber2).size() >= myList2.size()) {
                randomNumber2 = random.nextInt(myList2.size());
            }
            myList2.get(randomNumber2).add(duckList.get(randomNumber).poll());
        }
        return myList2;
    }

    public String getMyList2() {
        StringBuilder string = new StringBuilder();
        for (Queue<Integer> a : myList2) {
            string.append(a).append("\n");
        }
        return string.toString();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Queue<Integer> a : myList) {
            string.append(a).append("\n");
        }
        return string.toString();
    }
}