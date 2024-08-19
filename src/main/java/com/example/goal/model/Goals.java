package com.example.goal.model;

import java.util.Date;
public class Goals {
    private int goal_id;
    private String goal_name;
    private String goal_description;
    private Date target_date;
    public Goals() {
        super();
    }
    public Goals(int goal_id, String goal_name, String goal_description, Date target_date) {
        super();
        this.goal_id = goal_id;
        this.goal_name = goal_name;
        this.goal_description = goal_description;
        this.target_date = target_date;
    }
    public int getGoal_id() {
        return goal_id;
    }
    public void setGoal_id(int goal_id) {
        this.goal_id = goal_id;
    }
    public String getGoal_name() {
        return goal_name;
    }
    public void setGoal_name(String goal_name) {
        this.goal_name = goal_name;
    }
    public String getGoal_description() {
        return goal_description;
    }
    public void setGoal_description(String goal_description) {
        this.goal_description = goal_description;
    }
    public Date getTarget_date() {
        return target_date;
    }
    public void setTarget_date(Date target_date) {
        this.target_date = target_date;
    }

}