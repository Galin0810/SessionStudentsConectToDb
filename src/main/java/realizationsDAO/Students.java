package realizationsDAO;

import java.util.Set;

public class Students  {
    int id;
    String name;
    int age;
    String groups;
    int rating;
    int levelOfLaziness;
    Students(int id, String name, int age, String groups, int rating, int levelOfLaziness){
        this.id = id;
        this.name = name;
        this.age = age;
        this.groups = groups;
        this.rating = rating;
        this.levelOfLaziness = levelOfLaziness;
    }
Students(){}
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

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getLevelOfLaziness() {
        return levelOfLaziness;
    }

    public void setLevelOfLaziness(int levelOfLaziness) {
        this.levelOfLaziness = levelOfLaziness;
    }
}
