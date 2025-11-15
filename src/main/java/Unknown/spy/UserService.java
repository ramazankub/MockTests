package Unknown.spy;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getGreeting(int id) {
        if(!userRepository.exists(id)) {
            return "User not found";
        }

        String name = userRepository.findUserNameById(id);
        return "Hello " + name;
    }
}
