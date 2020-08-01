package by.work.service;

import by.work.database.entity.Address;
import by.work.database.entity.Contact;
import by.work.database.entity.User;
import by.work.database.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{

    private final ContactRepository contactRepository;
    private final UserService userService;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository, UserService userService) {
        this.contactRepository = contactRepository;
        this.userService = userService;
    }

    @Override
    public void saveHomeAddress(Address homeAddress,String telephone,String email) {
        User user = userService.getCurrentUser();
        Contact contact = new Contact();
        contact.setUser(user);
        contact.setTelephone(telephone);
        contact.setEmail(email);
        contact.setHomeAddress(homeAddress);
        contactRepository.save(contact);
    }

    @Override
    public Contact findUserContact() {
        User user = userService.getCurrentUser();
        return contactRepository.findByUser(user);
    }


}
