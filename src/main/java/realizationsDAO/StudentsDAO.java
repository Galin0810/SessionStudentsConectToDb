package realizationsDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class StudentsDAO implements SessionDAO {
    static Connection connection = new  ConnectionFactory().getConnection();

    private Students extractStudentFromResultSet(ResultSet rs) throws SQLException {

        Students students = new Students();

       /* students.setId(rs.getInt("id"));
        students.setName(rs.getString("name"));
        students.setAge(rs.getInt("age"));
        students.setGroups(rs.getString("groups"));
        students.setRating(rs.getInt("rating"));
        students.setLevelOfLaziness(rs.getInt("levelOfLaziness"));*/

        return students;
    }


    public static List<Students> getUser(int id) {

        try{
            Statement stmt = connection.createStatement();
            System.out.println("dao");
            ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE id="+ id);

            List <Students>list= new ArrayList<Students>();
            while (rs.next()) {

                Students students = new Students();

                students.setId( rs.getInt("id") );
                students.setName( rs.getString("name") );
                students.setAge( rs.getInt("age") );
                students.setGroups( rs.getString("groups") );
                students.setRating( rs.getInt("rating") );
                students.setLevelOfLaziness( rs.getInt("levelOfLaziness") );
                System.out.print("dao<");

                list.add(students);


            }return  list;

        } catch (SQLException ex) {
            System.out.println("!");
            ex.printStackTrace();
        System.out.print("errrroor");}
            return null;


        }

    public  List<Students> getAllUser(){

            try {

                    Statement stmt = connection.createStatement();

                    ResultSet rs = stmt.executeQuery("SELECT * FROM students");

                    List<Students> students = new ArrayList<Students>();

                    while (rs.next())

                    {

                        Students student = extractStudentFromResultSet(rs);

                        students.add(student);

                    }

                    return  students;



                } catch (SQLException e) {

                    e.printStackTrace();

                } return null;}


    public boolean insert(Students students) {

        try {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO students VALUES (NULL, ?, ?, ?, ?, ?)");

            ps.setString(1, students.getName());
            ps.setInt(2, students.getAge());
            ps.setString(3, students.getGroups());
            ps.setInt(4, students.getRating());
            ps.setInt(5, students.getLevelOfLaziness());

            int i = ps.executeUpdate();

            if(i == 1) {

                return true;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return false;

    }

    public boolean update(Students students) {



        try {

            PreparedStatement ps = connection.prepareStatement("UPDATE students SET name=?, age=?, groups=?, rating=?, leveleOfLaziness=? WHERE id=?");

            ps.setString(1, students.getName());
            ps.setInt(2, students.getAge());
            ps.setString(3, students.getGroups());
            ps.setInt(4, students.getRating());
            ps.setInt(5, students.getLevelOfLaziness());

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

            int i = stmt.executeUpdate("DELETE FROM students WHERE id=" + id);

            if(i == 1) {

                return true;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return false;

    }
}
