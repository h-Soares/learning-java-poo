package models.entities;

import java.util.ArrayList;
import java.util.List;
import models.exceptions.ContactDoesntExistException;

public class Schedule {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void consultContact(String name) throws ContactDoesntExistException {
        boolean hasContact = false;

        for(Contact contact : contacts) {
            if(contact.getName().equalsIgnoreCase(name)) {
                hasContact = true;
                System.out.println(contact);
            }   
        }
        if(!hasContact)
          throw new ContactDoesntExistException("This contact doesn't exist");
    }
}