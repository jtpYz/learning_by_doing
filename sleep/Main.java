package com.mircro.wyatt.sleep;

public class Main {
    public static void main(String[] args) {
        Race.raceGame();
    }
}
class Race {
    public static void raceGame() {
        Turtles turtles = new Turtles("小王八",0);
        Rabbit rabbit = new Rabbit("小兔子",0);
        new Thread(turtles).start();
        new Thread(rabbit).start();
    }
}
class Animal {
    private String name;
    private int distance;
    public static int END = 10;
    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Animal(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }
    public void distanceIncrease() {
        distance++;
    }
    public void distanceIncrease2() {
        distance+=3;
    }
}

class Turtles extends Animal implements Runnable{

    public Turtles(String name, int distance) {
        super(name, distance);
    }


    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            distanceIncrease();
            if (getDistance() == END) {
                System.out.println(getName() + "到终点了，赢了！");
            }
        }
    }
}
class Rabbit extends Animal implements Runnable{

    public Rabbit(String name, int distance) {
        super(name, distance);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            distanceIncrease2();
            if (getDistance() == END) {
                System.out.println(getName() + "到终点了，赢了！");
            }
        }
    }
}