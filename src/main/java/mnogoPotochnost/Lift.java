package mnogoPotochnost;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Lift {
    int floorIn = 1; //забирают
    int floorOut; // высаживают
    ArrayBlockingQueue<int[][]> queue = new ArrayBlockingQueue<>(10); // здесь очередь из этажей на которых вызывают лифт

    public Lift(){
        (new Thread(new Producer())).start();
        (new Thread(new Consumer())).start();
    }
    // имитирует людей
    class Producer implements Runnable{
        public void run(){
            int[][] array = new int[10][2];
            Random r = new Random();
            for (int i = 0; i < 10; i++) {
                array[i][0] = r.nextInt(15) + 1;
                array[i][1] = r.nextInt(15) + 1;
                if (array[i][0] == array[i][1]){
                    array[i][1] = (array[i][1] + 1) % 15;
                }
                try {
                    queue.put(array);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // лифт
    class Consumer implements Runnable{
        public void run(){
            try {
                int i = 0;
                while (!queue.isEmpty()) {
                    int[][] floors;
                    try {
                        floors = queue.take();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    floorIn = floors[i][0];
                    floorOut = floors[i][1];
                    i++;
                    System.out.println("вызван лифт на " + floorIn + " этаже");
                    System.out.println("лифт " + Thread.currentThread().getId() + " забрал пассажира на " + floorIn + " этаже и высадил на " + floorOut + " этаже");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


