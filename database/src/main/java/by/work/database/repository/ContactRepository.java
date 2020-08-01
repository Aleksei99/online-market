package by.work.database.repository;

import by.work.database.entity.Contact;
import by.work.database.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact,Long> {
    Contact findByUser(User user);
}
