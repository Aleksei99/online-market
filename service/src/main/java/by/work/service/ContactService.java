package by.work.service;

import by.work.database.entity.Address;
import by.work.database.entity.Contact;
import by.work.database.entity.User;

public interface ContactService {
    void saveHomeAddress(Address homeAddress, String telephone, String email);
    void saveAnotherAddress(Address anotherAddress);
    void changeAddress();

    Contact findByUser(User user);

    Contact findUserContact();

    Contact getEmptyContact();
}
