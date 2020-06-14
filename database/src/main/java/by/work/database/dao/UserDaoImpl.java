package by.work.database.dao;

import by.work.database.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDAO {


//    @Override
//    public void update(Long id) {
//
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//
//    @Override
//    public User findById(Long id) {
//        User user  = (User) getSessionFactory().getCurrentSession()
//                .createQuery("select us from User us where us.id= '"+id+"'")
//                .getSingleResult();
//        return user;
//    }
}
