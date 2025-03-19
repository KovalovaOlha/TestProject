package Lesson4;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminServiceImpl implements AdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Override
    public void promoteToAdmin(String userId) {
        System.out.println("Користувач " + userId + " підвищений до адміністратора.");
    }

    @Override
    public void blockUser(int userId) {
        System.out.println("Користувач з ID " + userId + " заблокований.");
    }
}
