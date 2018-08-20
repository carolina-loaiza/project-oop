/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Persistencia {

    private String file;

    public Persistencia(String file) {
        this.file = file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setData(String data) throws IOException {

        try {
            FileWriter writer = new FileWriter(this.file, true);
            BufferedWriter buffer = new BufferedWriter(writer);

            buffer.write(data);
            buffer.newLine();
            buffer.close();

        } catch (IOException e) {
            System.out.println("---------- "+e.getMessage()+" ----------");
            throw e;
        }

    }

    public ArrayList<String> getData() throws IOException {

        ArrayList<String> data = new ArrayList<>();

        try {
            FileReader reader = new FileReader(this.file);
            BufferedReader buffer = new BufferedReader(reader);
            String datos;

            while ((datos = buffer.readLine()) != null) {
                data.add(datos);

            }
            reader.close();
            return data;
        } catch (IOException e) {
            throw e;
        }

    }

}