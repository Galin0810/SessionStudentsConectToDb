package realizationsDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class TeachersDAO  implements SessionDAO{
    Connection connection = new  ConnectionFactory().getConnection();

    private Teachers extractTeacherFromResultSet(ResultSet rs) throws SQLException {

        Teachers teachers = new Teachers();

        teachers.setId(rs.getInt("id"));
        teachers.setName(rs.getString("name"));
        teachers.setAge(rs.getInt("age"));
        teachers.setProfession(rs.getString("profession"));
        teachers.setLevelOfSeverity(rs.getInt("levelOfSeverity"));

        return teachers;
    }


    public List<Teachers> getUser(int id) {

        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM teachers WHERE id="+ id);
            List<Teachers> tech= new ArrayList<Teachers>();
            if(rs.next()) {

                Teachers teachers = new Teachers();
                teachers.setId( rs.getInt("id") );
                teachers.setName( rs.getString("name") );
                teachers.setAge( rs.getInt("age") );
                teachers.setProfession(rs.getString("profession"));
                teachers.setLevelOfSeverity(rs.getInt("levelOfSeverity"));;
                tech.add(teachers);
                return tech;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();}
        return null;


    }

    public List<Teachers> getAllUser(){

        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM techers");
            List<Teachers> teachers = new ArrayList<Teachers>();

            while (rs.next()) {

                Teachers teacher = extractTeacherFromResultSet(rs);
                teachers.add(teacher);

            }

            return  teachers;



        } catch (SQLException e) {

            e.printStackTrace();

        } return null;}


    public boolean insert(Teachers teachers) {

        try {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO teahers VALUES (NULL, ?, ?, ?, ?)");

            ps.setString(1, teachers.getName());
            ps.setInt(2, teachers.getAge());
            ps.setString(3, teachers.getProfession());
            ps.setInt(4, teachers.getLevelOfSeverity());


            int i = ps.executeUpdate();

            if(i == 1) {

                return true;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return false;

    }

    public boolean update(Teachers teachers) {
        try {

            PreparedStatement ps = connection.prepareStatement("UPDATE teachers SET name=?, age=?, profession=?, levelOfSeverity=? WHERE id=?");

            ps.setString(1, teachers.getName());
            ps.setInt(2, teachers.getAge());
            ps.setString(3, teachers.getProfession());
            ps.setInt(4, teachers.getLevelOfSeverity());


            int i = ps.executeUpdate();

            if(i == 1) {

                return true;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return false;

    }

    public boolean delete(int id) {
        try {

            Statement stmt = connection.createStatement();

            int i = stmt.executeUpdate("DELETE FROM teachers WHERE id=" + id);

            if(i == 1) {

                return true;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return false;

    }
}