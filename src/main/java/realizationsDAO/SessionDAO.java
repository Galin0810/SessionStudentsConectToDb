package realizationsDAO;


import java.util.List;


public interface SessionDAO {

    public List<?> getUser();
    public List<? extends Object> getAllUser();
    public boolean insert();
    public boolean update();
    public boolean delete();
}
