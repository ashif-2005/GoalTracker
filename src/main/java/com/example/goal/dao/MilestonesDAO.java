package com.example.goal.dao;

import com.example.goal.model.Goals;
import com.example.goal.model.Milestones;
import com.example.goal.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MilestonesDAO {

    public void FixMilestones(Milestones milestones) throws SQLException{
        String query = "INSERT INTO milestones(goal_id,milestone_description,due_date,is_completed) VALUES(?,?,?,?)";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query))
        {
            ps.setInt(1, milestones.getGoal_id());
            ps.setString(2, milestones.getMilestone_description());
            ps.setTimestamp(3,new Timestamp(milestones.getDue_date().getTime()));
            ps.setString(4, milestones.getIs_completed());
            ps.executeUpdate();
        }

    }

    public void updateMilestone(Milestones milestones) throws SQLException {
        String query = "update milestones set milestone_description=?,due_date =?,is_completed=? where milestone_id=?";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query))
        {
            System.out.println(milestones.getMilestone_id());
            ps.setString(1, milestones.getMilestone_description());
            ps.setTimestamp(2, new Timestamp(milestones.getDue_date().getTime()));
            ps.setString(3, milestones.getIs_completed());
            ps.setInt(4, milestones.getMilestone_id());
            ps.executeUpdate();
        }
    }

    public List<Milestones> getAllMilestones() throws SQLException{
        List<Milestones> milestones = new ArrayList<>();
        /*
         * String query =
         * "SELECT b.milestone_description, b.is_completed FROM milestones b join goals c on b.goal_id=c.goal_id"
         * ;
         */
        String query ="SELECT * FROM milestones";
        try(Connection con = DBConnection.getConnection();
            Statement s = con.createStatement();
            ResultSet result = s.executeQuery(query))
        {
            while(result.next())
            {
                Milestones obj= new Milestones();
                obj.setMilestone_id(result.getInt("milestone_id"));
				obj.setGoal_id(result.getInt("goal_id"));
				obj.setMilestone_description(result.getString("milestone_description"));
				obj.setDue_date(result.getTimestamp("due_date"));
                obj.setIs_completed(result.getString("is_completed"));
                milestones.add(obj);
            }
        }
        return milestones;
    }

    public void deleteMilestone(int deleteMilestoneId)throws SQLException {
        String query = "delete from milestones where milestone_id =?;";
        try {
            Connection co = DBConnection.getConnection();
            PreparedStatement p = co.prepareStatement(query);
            p.setInt(1, deleteMilestoneId);
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}