package dk.kea;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class DuckRace {

    ArrayList<Queue<Integer>> myList;

    public DuckRace(int number) {
        myList = makeList(number);
        myList = makeDucks(number);
        while (myList.size() > 1) {
            myList = addDucks(myList);
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
        for (Queue<Integer> a : duckList) {
            System.out.println(a);
        }
        System.out.println();
        return duckList;
    }

    public ArrayList<Queue<Integer>> addDucks(ArrayList<Queue<Integer>> duckList) {
        ArrayList<Queue<Integer>> newDuckList = makeList(duckList.size() - 1);
        Random random = new Random();
        for (int i = 0; i < newDuckList.size() * newDuckList.size(); i++) {
            int randomNumber = random.nextInt(duckList.size());
            while (duckList.get(randomNumber).peek() == null) {
                if (duckList.get(randomNumber).peek() == null){
                    duckList.remove(randomNumber);
                }
                randomNumber = random.nextInt(duckList.size());
            }
            int randomNumber2 = random.nextInt(newDuckList.size());
            while (newDuckList.get(randomNumber2).size() >= newDuckList.size()) {
                randomNumber2 = random.nextInt(newDuckList.size());
            }
            newDuckList.get(randomNumber2).add(duckList.get(randomNumber).poll());
        }
        for (Queue<Integer> a : newDuckList) {
            System.out.println(a);
        }
        System.out.println();
        return newDuckList;
    }
}