package by.work.service;

import by.work.database.entity.Address;
import by.work.database.entity.Contact;

public interface ContactService {
    void saveHomeAddress(Address homeAddress, String telephone, String email);

    Contact findUserContact();

    Contact getEmptyContact();
}
