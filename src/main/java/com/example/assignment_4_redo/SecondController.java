package com.example.assignment_4_redo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondController {
    @FXML
    private TextField txtName;

    @FXML
    private Button btnSave;
    @FXML
    private Label updateLbl;

    private horror_character character;
    private Controller mainController;

    @FXML
    public void initData(horror_character hc, Controller controller)
    {
        this.character = hc;
        this.mainController = controller;
        if (hc != null)
        {
            txtName.setText(hc.getName());

        }
    }
    @FXML
    private void onSave() {
        if (character != null) {
            String newName = txtName.getText();
            if (newName != null && !newName.trim().isEmpty()) {
                character.setName(newName.trim());

                if (mainController != null) mainController.refreshList();
            }
        }

        Stage stage = (Stage) btnSave.getScene().getWindow();
        stage.close();
    }
}