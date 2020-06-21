package by.work.database.repository;

import by.work.database.entity.PersonalInfo;
import org.springframework.data.repository.CrudRepository;

public interface PersonalInfoRepository extends CrudRepository<PersonalInfo, Long> {
    PersonalInfo findByLogin(String login);
}
