package realizationsDAO;

public class Teachers {
    int id;
    String name;
    int age;
    String profession;
    int levelOfSeverity;
Teachers(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getLevelOfSeverity() {
        return levelOfSeverity;
    }

    public void setLevelOfSeverity(int levelOfSeverity) {
        this.levelOfSeverity = levelOfSeverity;
    }

    Teachers(int id, String name, int age, String profession, int levelOfSeverity){
        this.id = id;
        this.name = name;
        this.age = age;
        this.profession = profession;

        this. levelOfSeverity = levelOfSeverity;
    }
}
