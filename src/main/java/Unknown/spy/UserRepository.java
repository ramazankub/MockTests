package Unknown.spy;

public class UserRepository {
    public String findUserNameById(int id) {
        return "Real ser from DB";
    }

    public boolean exists(int id) {
        return id > 0;
    }
}
