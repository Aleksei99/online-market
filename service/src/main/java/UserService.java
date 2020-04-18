import by.work_company.dao.UserDAO;
import by.work_company.entity.User;

public class UserService {
    private static UserService INSTANCE = null;

    private UserService(){}

    public static UserService getInstance(){
        if(INSTANCE==null){
            synchronized (UserService.class){
                if(INSTANCE==null){
                    INSTANCE = new UserService();
                }
            }
        }
        return INSTANCE;
    }
    public User getUser(int id){
        return UserDAO.getInstance().find(id);
    }
}
