package edu.ib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ErrorController  {

        @FXML
        private Button btnOK;

        @FXML
        void btnOKClick(ActionEvent event) {
            ((Stage) btnOK.getScene().getWindow()).close();
        }
}
