package com.example.goal;

import com.example.goal.controller.GoalTrackingController;
import com.example.goal.model.Goals;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class goalController {

    @FXML
    private TableColumn<Goals, Date> datetime;

    @FXML
    private TableColumn<Goals, String> Description;

    @FXML
    private TableColumn<Goals, String> Name;

    @FXML
    private TextField date;

    @FXML
    private TextField des;

    @FXML
    private TextField goal;

    @FXML
    private TableView<Goals> goalTable;

    @FXML
    private TableColumn<Goals, Integer> id;

    private Goals selectedUser;

    private final GoalTrackingController goalsTrack;

    public goalController() {
        super();
        this.goalsTrack = new GoalTrackingController();
    }

    public void initialize() {
        id.setCellValueFactory(new PropertyValueFactory<>("goal_id"));
        Name.setCellValueFactory(new PropertyValueFactory<>("goal_name"));
        Description.setCellValueFactory(new PropertyValueFactory<>("goal_description"));
        datetime.setCellValueFactory(new PropertyValueFactory<>("target_date"));
        loadData();
        goalTable.setOnMouseClicked(this::handleRowSelect);
    }

    public void loadData(){
        try {
            List<Goals> goals = goalsTrack.getAllGoals();
            ObservableList<Goals> data = FXCollections.observableArrayList(goals);
            goalTable.setItems(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void handleRowSelect(MouseEvent mouseEvent) {
        selectedUser = goalTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            goal.setText(selectedUser.getGoal_name());
            des.setText(String.valueOf(selectedUser.getGoal_description()));
            date.setText(String.valueOf(selectedUser.getTarget_date()));
        }
    }

    @FXML
    void handelDelete(ActionEvent event) throws SQLException {
        if(selectedUser != null){
            goalsTrack.deleteGoal(selectedUser.getGoal_id());
            loadData();
        }
    }

    @FXML
    void handelInsert(ActionEvent event) throws SQLException {
        String goal_name = goal.getText();
        String goal_desc = des.getText();
        String goal_date = date.getText();
        Timestamp targetDate1 = goal_date.isEmpty() ? (Timestamp) new Date() : Timestamp.valueOf(goal_date);
        Goals obj = new Goals();
        obj.setGoal_name(goal_name);
        obj.setGoal_description(goal_desc);
        obj.setTarget_date(targetDate1);
        goalsTrack.addGoal(obj);
        loadData();
    }

    @FXML
    void handelLogout(ActionEvent event) {
        HelloApplication.stage_var.setTitle("Login");
        HelloApplication.stage_var.setScene(HelloApplication.login);
    }

    @FXML
    void handelUpdate(ActionEvent event) throws SQLException {
        if(selectedUser != null){
            System.out.println("update");
            String goal_name = goal.getText();
            String goal_desc = des.getText();
            String goal_date = date.getText();
            Timestamp targetDate1 = goal_date.isEmpty() ? (Timestamp) new Date() : Timestamp.valueOf(goal_date);
            Goals obj = new Goals();
            obj.setGoal_id(selectedUser.getGoal_id());
            obj.setGoal_name(goal_name);
            obj.setGoal_description(goal_desc);
            obj.setTarget_date(targetDate1);
            goalsTrack.updateGoals(obj);
            loadData();
        }
    }

    @FXML
    void handelUser(ActionEvent event) {
        System.out.println("Goal");
    }

    @FXML
    void handelWorkout(ActionEvent event) {
        HelloApplication.stage_var.setScene(HelloApplication.milestone);
    }

}
