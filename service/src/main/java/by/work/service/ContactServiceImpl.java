package by.work.service;

import by.work.database.entity.Address;
import by.work.database.entity.Contact;
import by.work.database.entity.User;
import by.work.database.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final UserService userService;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository, UserService userService) {
        this.contactRepository = contactRepository;
        this.userService = userService;
    }

    @Override
    public void saveHomeAddress(Address homeAddress, String telephone, String email) {
        User user = userService.getCurrentUser();
        Contact contact = getOrCreateContact();
        contact.setUser(user);
        contact.setTelephone(telephone);
        contact.setEmail(email);
        contact.setHomeAddress(homeAddress);
        contactRepository.save(contact);
    }

    @Override
    public void saveAnotherAddress(Address anotherAddress) {
        User user = userService.getCurrentUser();
        Contact contact = getOrCreateContact();
        contact.setUser(user);
        contact.setOtherAddress(anotherAddress);
        contact.setAnotherAddress(true);
        contactRepository.save(contact);
    }

    @Override
    public void changeAddress() {
        User user = userService.getCurrentUser();
        Contact contact = getOrCreateContact();
        contact.setUser(user);
        contact.setAnotherAddress(false);
        contactRepository.save(contact);
    }

    @Override
    public Contact findByUser(User user) {
        return contactRepository.findByUser(user);
    }

    @Override
    public Contact findUserContact() {
        User user = userService.getCurrentUser();
        return contactRepository.findByUser(user);
    }

    private Contact getOrCreateContact() {
        return findUserContact() == null ? new Contact() : findUserContact();
    }

    @Override
    public Contact getEmptyContact() {
        Contact empty = new Contact();
        Address address = new Address();
        address.setCity("");
        address.setHouse("");
        address.setNumber("");
        address.setStreet("");
        empty.setTelephone("");
        empty.setEmail("");
        empty.setHomeAddress(address);
        return empty;
    }

}
