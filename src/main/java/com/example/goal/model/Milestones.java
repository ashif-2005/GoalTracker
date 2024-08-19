package com.example.goal.model;

import java.util.Date;

public class Milestones {
    private int milestone_id;
    private int goal_id;
    private String milestone_description;
    private Date due_date;
    private String is_completed;

    public Milestones(){
        super();
    }

    public Milestones(int milestone_id, int goal_id, String milestone_description, Date due_date,
                      String is_completed) {
        super();
        this.milestone_id = milestone_id;
        this.goal_id = goal_id;
        this.milestone_description = milestone_description;
        this.due_date = due_date;
        this.is_completed = is_completed;
    }
    public int getMilestone_id() {
        return milestone_id;
    }
    public void setMilestone_id(int milestone_id) {
        this.milestone_id = milestone_id;
    }
    public int getGoal_id() {
        return goal_id;
    }
    public void setGoal_id(int goal_id) {
        this.goal_id = goal_id;
    }
    public String getMilestone_description() {
        return milestone_description;
    }
    public void setMilestone_description(String milestone_description) {
        this.milestone_description = milestone_description;
    }
    public Date getDue_date() {
        return due_date;
    }
    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }
    public String getIs_completed() {
        return is_completed;
    }
    public void setIs_completed(String is_completed) {
        this.is_completed = is_completed;
    }
}