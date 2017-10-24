package realizationsDAO;



public class Exam extends Students {
    int id;
    String type;
    String teacher;
    String student;
    int eduction;
    Exam(int id, String type, String teacher, String student, int eduction){
        this.id = id;
        this.type = type;
        this.student = student;
        this.teacher = teacher;
        this.eduction = eduction;
    }
Exam(){}
//geters and seters methods...
    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void setEduction(int eduction) {
        this.eduction = eduction;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getStudent() {
        return student;
    }

    public int getEduction() {
        return eduction;
    }
}
