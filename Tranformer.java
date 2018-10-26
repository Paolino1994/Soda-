package com.company;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by Colo on 26/10/2018.
 */
public class Tranformer {
    private static LinkedList<String> lineas;
    private static TSP tsp=new TSP();

    public static TSP tranform(File file) {
        readFile(file);
        for(int i=2;i<lineas.size();i++){
            String linea=lineas.get(i);
            String[] parts = linea.split(" ");
            /*double street=passFromStreetToVertex(parts[0]);
            double altura= Double.parseDouble(parts[1]);
            if(streetIsX(parts[0])){
                tsp.add(street,altura);
            }else{
                tsp.add(altura,street);
            }*/
        }

        return tsp;
    }

    private static void readFile(File file) {
        String fileName=file.getAbsolutePath();
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                lineas.add(line);
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
}
