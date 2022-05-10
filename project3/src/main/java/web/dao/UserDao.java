package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUser();
    void delete(Long id);
    void update(User user);
    User get(Long id);
}