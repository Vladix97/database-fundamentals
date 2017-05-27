package app.serviceImpls;

import app.daos.UserDao;
import app.entities.User;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void persist(User user) {
        this.userDao.save(user);
    }
}
