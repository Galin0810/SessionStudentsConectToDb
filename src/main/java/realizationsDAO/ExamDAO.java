package realizationsDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class ExamDAO implements SessionDAO{
    Connection connection = new  ConnectionFactory().getConnection();

    private Exam extractExamFromResultSet(ResultSet rs) throws SQLException {

        Exam exam = new Exam();

       /* exam.setId(rs.getInt("id"));
        exam.setType(rs.getString("type"));
        exam.setTeacher(rs.getString("teacher"));
        exam.setStudent(rs.getString("student"));
        exam.setEduction(rs.getInt("eduction"));*/


        return exam;
    }

    public List<Exam> getUser(int id) {

        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM exam WHERE id="+ id);
            List<Exam> ex = new ArrayList<Exam>();
            while (rs.next())

            {

                Exam exam = new Exam();

                exam.setId( rs.getInt("id") );
                exam.setType( rs.getString("type") );
                exam.setTeacher( rs.getString("teacher") );
                exam.setStudent( rs.getString("student") );
                exam.setEduction( rs.getInt("eduction") );
                ex.add(exam);
                return ex;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();}
        return null;


    }

    public List<Exam> getAllUser(){

        try {

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM exam");

            List <Exam> exam = new ArrayList<Exam>();

            while (rs.next())

            {

                Exam exam1 = extractExamFromResultSet(rs);

                exam.add(exam1);

            }

            return  exam;



        } catch (SQLException e) {

            e.printStackTrace();

        } return null;}


    public boolean insert(Exam exam) {

        try {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO exam VALUES (NULL, ?, ?, ?, ?)");

            ps.setString(1, exam.getType());
            ps.setString(2, exam.getTeacher());
            ps.setString(3, exam.getStudent());
            ps.setInt(4, exam.getEduction());


            int i = ps.executeUpdate();

            if(i == 1) {

                return true;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return false;

    }

    public boolean update(Exam exam) {



        try {

            PreparedStatement ps = connection.prepareStatement("UPDATE exam SET type=?, teacher=?, student=?, eduction=? WHERE id=?");

            ps.setString(1, exam.getType());
            ps.setString(2, exam.getTeacher());
            ps.setString(3, exam.getStudent());
            ps.setInt(4, exam.getEduction());


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

            int i = stmt.executeUpdate("DELETE FROM exam WHERE id=" + id);

            if(i == 1) {

                return true;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return false;

    }
}