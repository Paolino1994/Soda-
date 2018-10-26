package com.company;


import java.util.Random;

public class Main {
    public static void main(String[] args) {
	    System.out.println("Hola Mundo");
        //AntColony colony=new AntColony(500);
        TSP tsp =new TSP(30, new Random());
        tsp.transform(10.0, 0, 0);
        AntColony antc = new AntColony(tsp, 50, new Random());
        antc.init(0);//initial pheromone
        antc.runAllAnts();
        //System.out.println(tsp.getTour());
        int max=50000;
        int counter=0;
        int epoch2print=1000;
        while(counter<max){
            counter++;
            if(counter % epoch2print==0){
                System.out.print("Gen: "+counter+" ");
                for(int e:antc.getBestTour()){
                    System.out.print(e+" ");
                }
                System.out.println("Largo "+antc.getBestLen());
            }

            //System.out.println(antc.getBestTour().toString());
            antc.runAllAnts();
        }



    }
}
