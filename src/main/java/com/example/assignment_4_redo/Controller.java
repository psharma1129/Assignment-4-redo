package com.example.assignment_4_redo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ArrayList<horror_character> characters = new ArrayList<>();
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    public ListView<horror_character> CharacterListView;
    public ObservableList<String> view;
    @FXML
    private Button btnCreate;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private DatePicker DOBid;
    @FXML
    private Label txtDate;
    private Parent root;
    private Stage stage;
    private Scene scene;

    public void getDate(ActionEvent event)
    {
        LocalDate date = DOBid.getValue();
        txtDate.setText(date.toString());
    }
    @FXML
    private TextField txtCharacterName;
    @FXML
    private CheckBox chkTransformation;
    @FXML
    private ComboBox<String> combo1;
    @FXML
    private Spinner<Vulnerability> spinner1;

    @FXML
    public void sendDataToSecond(ActionEvent e) throws IOException
    {
        // Get the currently selected Movie object from the TableView
        horror_character hc = CharacterListView.getSelectionModel().getSelectedItem();

        // Load the FXML file for the secondary scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui2.fxml"));
        root = loader.load();
        SecondController sc = loader.getController();
        sc.initData(hc,this);


        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    ArrayList<String> StringList = new ArrayList<>();
    ObservableList<Vulnerability> vuln = FXCollections.observableArrayList(Vulnerability.values());
    Spinner<Vulnerability> spinnerVuln = new Spinner<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        SpinnerValueFactory.ListSpinnerValueFactory<Vulnerability> factory = new SpinnerValueFactory.ListSpinnerValueFactory<>(vuln);
        spinner1.setValueFactory(factory);
        combo1.setItems(FXCollections.observableArrayList("Zombie", "Vampire", "WereWolf"));
        CharacterListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


    }



    public void addButtonClicked()
    {
        String name = txtCharacterName.getText();
        String type = combo1.getValue();
        Vulnerability selectedVuln = spinner1.getValue();
        String spinnervuln = selectedVuln.name();
        boolean transform = chkTransformation.isSelected();
        LocalDate selected = DOBid.getValue();

        horror_character monsters = switch (type) {
            case "Vampire" -> new Vampire(80, name,selected,transform);
            case "WereWolf" -> new Werewolf(120, name,selected,transform);
            case "Zombie" -> new Zombie(100, name,selected,transform);
            default -> null;
        };

        if ("Zombie".equals(type) && transform) {
            StringList.add(type + " cannot transform");
        } else if (transform) {

            StringList.add(type + " is transformable");
        }
        {

            if (selected == null)
            {
                System.out.println("please pick a date");
            }else
            {
                String dateStr = selected.format(java.time.format.DateTimeFormatter.ISO_LOCAL_DATE);
                txtDate.setText(dateStr);
                StringList.add(dateStr);
            }

        }

            StringList.add(spinnervuln);
        if (monsters != null) {
            characters.add(monsters);
            CharacterListView.getItems().add(monsters);
        }

    }
    public void deleteButtonClicked() {
        horror_character selected = CharacterListView.getSelectionModel().getSelectedItem();

        if (selected != null) {
            CharacterListView.getItems().remove(selected);
            characters.remove(selected);
        }
    }
    public void updateButtonClicked(ActionEvent e) throws IOException
    {
        horror_character selected = CharacterListView.getSelectionModel().getSelectedItem();
        if (selected == null) return; // nothing selected

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Gui2.fxml"));
        root = loader.load();
        SecondController sc = loader.getController();
        sc.initData(selected, this); // pass selected character + reference to main controller

        Stage dialog = new Stage();
        dialog.initOwner(((Node)btnUpdate).getScene().getWindow());
        dialog.initModality(javafx.stage.Modality.WINDOW_MODAL);
        dialog.setTitle("Update Character");
        dialog.setScene(new Scene(root));
        dialog.showAndWait(); // wait until user closes dialog
    }

    public void refreshList() {
        // keep items in sync with underlying list
        CharacterListView.getItems().setAll(characters);
        CharacterListView.refresh();
    }

    }
