package edu.ib.Integrator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class ConsoleHandler implements StepHandler {
    private ArrayList<Double> xList = new ArrayList<>();
    private ArrayList<Double> tList = new ArrayList<>();
    private HashMap<Integer, ArrayList<Double>> allxList = new HashMap<>();
    private HashMap<Integer ,ArrayList<Double>> alltList = new HashMap<>();

    @Override
    public void update(double x, double t) {
        xList.add(x);
        tList.add(t);
    }

    public void print() {
        for (int i = 0; i < xList.size(); i++) {
            System.out.println(tList.get(i) + "\t" + xList.get(i));
        }
    }

    public void saveToFile(File file, int n) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        writer.println("x \t t");
        for (int i = 0; i < getAllxList().get(n).size(); i += 1) {
            writer.println(getAllxList().get(n).get(i) + "\t" + getAlltList().get(n).get(i));
        }
        writer.flush();
        writer.close();
    }

    public ArrayList<Double> getxList() {
        return xList;
    }

    public ArrayList<Double> gettList() {
        return tList;
    }

    public void clear() {
        xList.clear();
        tList.clear();
    }

    public void save(ArrayList<Double> xList, ArrayList<Double> tList, int n) {
        allxList.put(n, new ArrayList<>(xList));
        alltList.put(n, new ArrayList<>(tList));
    }

    public void clearPermanent() {
        allxList.clear();
        alltList.clear();
    }

    public HashMap<Integer, ArrayList<Double>> getAllxList() {
        return allxList;
    }

    public HashMap<Integer, ArrayList<Double>> getAlltList() {
        return alltList;
    }
}
