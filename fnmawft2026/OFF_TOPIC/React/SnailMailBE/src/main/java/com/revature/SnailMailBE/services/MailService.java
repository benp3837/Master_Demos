package com.revature.SnailMailBE.services;

import com.revature.SnailMailBE.daos.MailDAO;
import com.revature.SnailMailBE.models.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

//The service layer is responsible for business logic
//Business logic includes stuff like data validation, and data formatting.
//The service makes calls to the database layer and makes sure inputs are valid
@Service //Make this class a bean so we can inject it in the controller
public class MailService {

    //Autowire the DAO so we can use it's methods
    private MailDAO mailDAO;

    @Autowired
    public MailService(MailDAO mailDAO) {
        this.mailDAO = mailDAO;
    }

    public List<Mail> getInbox(){

        //Imagine we sent a request to the database to get this info
//        List<Mail> inbox = List.of(
//                new Mail("snail@snailmail.com", "Hey", "me@snailmail.com", "I am a snail"),
//                new Mail("snail@snailmail.com", "Hey", "me@snailmail.com", "I have a shell"),
//                new Mail("slug@snailmail.com", "Hey", "me@snailmail.com", "I am a slug"),
//                new Mail("clam@snailmail.com", "Hey", "me@snailmail.com", "...")
//        );

        //Now instead of hardcoding, we'll call directly to the DAO
        List<Mail> inbox = mailDAO.findAll();

        //Imagine we either get a list of mail or an empty list
        if(inbox.isEmpty()){
            return null; //emulates an empty inbox
        } else {
            return inbox;
        }

    }

    public Mail sendMail(Mail mail){

        //Some basic checks to make sure the mail is valid
        if(mail.getRecipient() == null || mail.getRecipient().isBlank()){
            //throw an Exception if Recipient is null or blank
            throw new IllegalArgumentException("Recipient cannot be empty!");
        }
        //TODO: check the other fields, and stuff like is the email address is valid

        //Another check to make sure the subject is > 20 characters
        if(mail.getSubject().length() > 20){
            //throw an Exception is Subject is too long
            throw new IllegalArgumentException("Save it for the message body, buddy");
        }

        //Imagine we send a request to the database here to "send" the mail
        return mailDAO.save(mail); //save() also returns the saved object

    }

}
