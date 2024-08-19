package com.example.goal.controller;

import com.example.goal.dao.GoalsDAO;
import com.example.goal.dao.MilestonesDAO;
import com.example.goal.model.Goals;
import com.example.goal.model.Milestones;

import java.sql.SQLException;
import java.util.List;

public class GoalTrackingController {
    private final GoalsDAO goalsDAO;
    private final MilestonesDAO milestonesDAO;
    public GoalTrackingController() {
        super();
        this.goalsDAO = new GoalsDAO();
        this.milestonesDAO= new MilestonesDAO();
    }
    public void addGoal(Goals goals) throws SQLException{
        goalsDAO.addGoal(goals);

    }
    public void updateGoals(Goals goals)throws SQLException {
        goalsDAO.updateGoals(goals);

    }
    public List<Goals> getAllGoals() throws SQLException {
        return goalsDAO.getAllGoals();
    }
    public void deleteGoal(int deleteGoalId)throws SQLException {
        goalsDAO.deleteGoal(deleteGoalId);
    }
    public void FixMilestones(Milestones milestones) throws SQLException{
        milestonesDAO.FixMilestones(milestones);
    }

    public void UpdateMilestones(Milestones milestones) throws SQLException{
        milestonesDAO.updateMilestone(milestones);
    }

    public List<Milestones> getAllMilestones()throws SQLException {
        return milestonesDAO.getAllMilestones();
    }

    public void deleteMilestones(int deleteMilestoneId)throws SQLException {
        milestonesDAO.deleteMilestone(deleteMilestoneId);
    }

}