package com.online.store.storage;


import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class FileManager {



    public static void writeFile(
            String path,
            List<String> data) {



        try {


            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(path)
                    );



            for(String line : data){

                writer.write(line);

                writer.newLine();

            }


            writer.close();



        }
        catch(IOException e){

            System.out.println(
                    "File write error"
            );

        }

    }







    public static List<String> readFile(
            String path) {



        List<String> data =
                new ArrayList<>();



        try {


            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(path)
                    );



            String line;



            while(
                    (line = reader.readLine())
                            != null
            ){

                data.add(line);

            }



            reader.close();


        }
        catch(IOException e){

            System.out.println(
                    "File not found"
            );

        }



        return data;

    }



}