package com.example.goal;

import com.example.goal.controller.GoalTrackingController;
import com.example.goal.model.Milestones;
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

public class milestoneController {

    @FXML
    private TableColumn<?, ?> Description;

    @FXML
    private TableColumn<?, ?> datetime;

    @FXML
    private TextField des;

    @FXML
    private TextField due;

    @FXML
    private TextField gid;

    @FXML
    private TableColumn<?, ?> goalId;

    @FXML
    private TableView<Milestones> milestoneTable;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> status;

    @FXML
    private TextField sts;

    private Milestones selectedUser;

    private final GoalTrackingController goalsTrack;

    public milestoneController() {
        super();
        this.goalsTrack = new GoalTrackingController();
    }

    public void initialize() {
        id.setCellValueFactory(new PropertyValueFactory<>("milestone_id"));
        goalId.setCellValueFactory(new PropertyValueFactory<>("goal_id"));
        Description.setCellValueFactory(new PropertyValueFactory<>("milestone_description"));
        datetime.setCellValueFactory(new PropertyValueFactory<>("due_date"));
        status.setCellValueFactory(new PropertyValueFactory<>("is_completed"));
        loadData();
        milestoneTable.setOnMouseClicked(this::handleRowSelect);
    }

    public void loadData(){
        try {
            List<Milestones> goals = goalsTrack.getAllMilestones();
            ObservableList<Milestones> data = FXCollections.observableArrayList(goals);
            milestoneTable.setItems(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void handleRowSelect(MouseEvent mouseEvent) {
        selectedUser = milestoneTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            gid.setText(String.valueOf(selectedUser.getGoal_id()));
            des.setText(selectedUser.getMilestone_description());
            due.setText(String.valueOf(selectedUser.getDue_date()));
            sts.setText(selectedUser.getIs_completed());
        }
    }

    @FXML
    void handelDelete(ActionEvent event) throws SQLException {
        if(selectedUser != null){
            goalsTrack.deleteMilestones(selectedUser.getMilestone_id());
            loadData();
        }
    }

    @FXML
    void handelInsert(ActionEvent event) throws SQLException {
        int Id = Integer.parseInt(gid.getText());
        String descr = des.getText();
        String dueDate = due.getText();
        String stat = sts.getText();
        Timestamp targetDate1 = dueDate.isEmpty() ? (Timestamp) new Date() : Timestamp.valueOf(dueDate);
        Milestones obj = new Milestones();
        obj.setGoal_id(Id);
        obj.setMilestone_description(descr);
        obj.setDue_date(targetDate1);
        obj.setIs_completed(stat);
        goalsTrack.FixMilestones(obj);
        loadData();
    }

    @FXML
    void handelLogout(ActionEvent event) {
        HelloApplication.stage_var.setScene(HelloApplication.login);
    }

    @FXML
    void handelUpdate(ActionEvent event) throws SQLException {
        String descr = des.getText();
        String dueDate = due.getText();
        String stat = sts.getText();
        Timestamp targetDate1 = dueDate.isEmpty() ? (Timestamp) new Date() : Timestamp.valueOf(dueDate);
        Milestones obj = new Milestones();
        System.out.println(selectedUser.getMilestone_id());
        obj.setMilestone_id(selectedUser.getMilestone_id());
        obj.setMilestone_description(descr);
        obj.setDue_date(targetDate1);
        obj.setIs_completed(stat);
        System.out.println("update");
        goalsTrack.UpdateMilestones(obj);
        loadData();
    }

    @FXML
    void handelUser(ActionEvent event) {
        HelloApplication.stage_var.setScene(HelloApplication.goal);
    }

    @FXML
    void handelWorkout(ActionEvent event) {
        System.out.println("Milestone");
    }

}
