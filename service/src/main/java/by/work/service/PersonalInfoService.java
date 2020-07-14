package by.work.service;

import by.work.database.entity.PersonalInfo;

public interface PersonalInfoService  {
    void save(PersonalInfo personalInfo);
    PersonalInfo findPersonalInfo(String username);
}
