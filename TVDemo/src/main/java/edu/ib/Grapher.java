package edu.ib;

import javafx.scene.chart.XYChart;

import java.util.ArrayList;

public class Grapher {

    private XYChart graph;

    public Grapher(XYChart graph) {
        this.graph = graph;
    }

    public void makePlot(ArrayList<Double> xList, ArrayList<Double> yList, int n){
        XYChart.Series series = new XYChart.Series<>();
        for(int i = 0 ; i < xList.size(); i++) plotPoint(xList.get(i), yList.get(i), series, n);
        graph.getData().add(series);
    }

    private  void plotPoint(double  x, double y, XYChart.Series series, int n){
        series.getData().add(new XYChart.Data(x,y));
        series.setName(String.valueOf(n));
    }

    public void clear(){
        graph.getData().clear();
    }
}
