package edu.ib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.*;

import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import edu.ib.Integrator.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.codehaus.commons.compiler.CompileException;

import javax.script.ScriptException;

public class TVDemoController {

    private ODEIntegrator integrator;
    private ConsoleHandler consoleHandler;
    private Grapher grapher;
    private ObservableList<PointTX> list = FXCollections.observableArrayList();
    private ObservableList<String> choiceList = FXCollections.observableArrayList();
    private ObservableList<Integer> data = FXCollections.observableArrayList();
    private int n = 0;

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private ChoiceBox<Integer> changeData;

    @FXML
    private LineChart<Double, Double> graph;

    @FXML
    private TableView<PointTX> table;

    @FXML
    private TextField tfMin;

    @FXML
    private TextField function;

    @FXML
    private TextField tfMax;

    @FXML
    private TextField xZero;

    @FXML
    private TextField step;

    @FXML
    private TableColumn<PointTX, Double> x;

    @FXML
    private Button btnCalculate;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnSave;

    @FXML
    private CheckBox chooseChart;

    @FXML
    private TableColumn<PointTX, Double> time;

    @FXML
    void btnCalculateClicked(ActionEvent event) throws ScriptException, CompileException, InvocationTargetException, UnparsableExpressionException, UnknownFunctionException, IOException {
        table.getItems().clear();
        consoleHandler.clear();

        if((function.getText().isEmpty() && function.getText().isBlank()) || (tfMax.getText().isEmpty() && tfMax.getText().isBlank())
                || (tfMin.getText().isEmpty() && tfMin.getText().isBlank()) || (xZero.getText().isEmpty() && xZero.getText().isBlank())
                || (step.getText().isEmpty() && step.getText().isBlank())) {
            FXMLLoader fxmlLoader = new FXMLLoader(TVDemo.class.getResource("/edu.ib/error-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initOwner(btnSave.getScene().getWindow());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            return;
        }

        Function func = new Function(function.getText());

        switch (MethodName.fromName(choice.getValue())) {
            case EULER_MODIFIED -> integrator = new ODEIntegrator(Double.parseDouble(tfMin.getText()),
                    Double.parseDouble(tfMax.getText()), Double.parseDouble(xZero.getText()),
                    func, new EulerModified(), consoleHandler);
            default -> integrator = new ODEIntegrator(Double.parseDouble(tfMin.getText()),
                    Double.parseDouble(tfMax.getText()), Double.parseDouble(xZero.getText()),
                    func, new Euler(), consoleHandler);
        }

        integrator.integrate(Double.parseDouble(step.getText()));
        list.addAll(PointTX.getPoints(consoleHandler.gettList(), consoleHandler.getxList()));
        consoleHandler.save(consoleHandler.getxList(), consoleHandler.gettList(), n);
        data.add(n);
        changeData.setValue(n);
        changeData.setItems(data);
        n += 1;
    }

    @FXML
    void btnClearClicked(ActionEvent event) {
        table.getItems().clear();
        consoleHandler.clear();
        consoleHandler.clearPermanent();
        grapher.clear();
        n = 0;
        data.clear();
    }

    @FXML
    void btnSaveClicked(ActionEvent event) throws FileNotFoundException {
        Stage stage = new Stage();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            consoleHandler.saveToFile(file, changeData.getValue());
        }
    }

    @FXML
    void initialize() {
        assert tfMin != null : "fx:id=\"tfMin\" was not injected: check your FXML file 'tvdemo.fxml'.";
        assert tfMax != null : "fx:id=\"tfMax\" was not injected: check your FXML file 'tvdemo.fxml'.";
        assert step != null : "fx:id=\"step\" was not injected: check your FXML file 'tvdemo.fxml'.";
        assert function != null : "fx:id=\"function\" was not injected: check your FXML file 'tvdemo.fxml'.";
        assert x != null : "fx:id=\"x\" was not injected: check your FXML file 'tvdemo.fxml'.";
        assert btnCalculate != null : "fx:id=\"btnCalculate\" was not injected: check your FXML file 'tvdemo.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'tvdemo.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'tvdemo.fxml'.";
        assert time != null : "fx:id=\"time\" was not injected: check your FXML file 'tvdemo.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'tvdemo.fxml'.";
        assert graph != null : "fx:id=\"graph\" was not injected: check your FXML file 'tvdemo.fxml'.";
        assert xZero != null : "fx:id=\"xZero\" was not injected: check your FXML file 'tvdemo.fxml'.";

        grapher = new Grapher(graph);
        consoleHandler = new ConsoleHandler();

        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        x.setCellValueFactory(new PropertyValueFactory<>("x"));
        table.setItems(list);

        for (MethodName mn: MethodName.values()) {
            choiceList.add(mn.name);
        }

        choice.setValue(choiceList.get(0));
        choice.setItems(choiceList);

        changeData.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                if((Integer) number2 >= 0) {
                    table.getItems().clear();
                    consoleHandler.clear();
                    list.addAll(PointTX.getPoints(consoleHandler.getAlltList().get((Integer) number2), consoleHandler.getAllxList().get((Integer) number2)));
                    if (!chooseChart.isSelected()) grapher.clear();
                    grapher.makePlot(consoleHandler.getAlltList().get((Integer) number2), consoleHandler.getAllxList().get((Integer) number2), (Integer) number2);
                }
            }
        });
    }
}