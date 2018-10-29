package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Colo on 26/10/2018.
 */
public class Tranformer {
    private static LinkedList<String> lineas=new LinkedList<String>();
    private static TSP tsp=new TSP();
    static LinkedList<Calle> calles=new LinkedList<Calle>();
    private static int factor=50;
    private static Tranformer instance;
    private final File archivo;

    private Tranformer(File file) {
        this.archivo=file;
    }

    public static TSP tranform(File file) {
        if(instance==null){
            instance=new Tranformer(file);
        }
        return transform(file);

    }

    private static TSP transform(File file) {
        readConfigurations();
        readFile(file);
        for(int i=0;i<lineas.size();i++){
            String linea=lineas.get(i);
            String[] parts = linea.split(",");
            double street=passFromStreetToVertex(parts[0]);
            double altura= Integer.parseInt(parts[1]);
            //tsp.add(50,50);
            if(streetIsX(parts[0])){
                tsp.add(street/factor,altura/factor);
            }else{
                tsp.add(altura/factor,street/factor);
            }
        }
        tsp.makeDists(true);
        return tsp;
    }

    private static double passFromStreetToVertex(String part) {
        for(Calle calle : calles){
            if(calle.getNombre().equals(part)){
                return calle.getAltura();
            }
        }
        return 0;
    }

    private static boolean streetIsX(String part) {
        for(Calle calle : calles){
            if(calle.equals(part)){
                if(calle.hasXOrientation()){
                    return true;
                }
            }
        }
        return false;
    }

    private static void readFile(File file) {
        String fileName=file.getAbsolutePath();
        String line = null;
        try {
            FileReader fileReader =  new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                lineas.add(line);
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");

        }
    }

    private static void readConfigurations() {
        String fileName="C:\\Users\\Colo\\IdeaProjects\\Soda+\\Configuracion.txt";
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                calles.add(new Calle(parts[0],Integer.parseInt(parts[1]),parts[2]));
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
    public static String getStreet(int calle){
        return lineas.get(calle);
    }
}
