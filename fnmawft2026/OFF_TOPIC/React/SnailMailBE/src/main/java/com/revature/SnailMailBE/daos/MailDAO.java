package com.revature.SnailMailBE.daos;


import com.revature.SnailMailBE.models.Mail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//DAO == Data Access Object. This Interface will allow us to access the database!

//This DAO interface extends the MongoRepository interface
//This gives us access to a BUNCH of CRUD methods that we don't have to write ourselves
//Stuff like findAll(), findById(), save(), delete(), etc.
@Repository
public interface MailDAO extends MongoRepository<Mail, String> {

    //TODO: could create our custom methods if findAll, save(), etc aren't enough
    //public List<Mail> findBySender(String sender);
        //it knows because of the naming convention findByFieldName

    //remember, save() works for inserts AND updates.

    /* This is actually all we need to do for the DAO... HOW?

     It's all in the two <generics> in the Interface declaration
     We're telling Spring this Interface deals with Mail data, which has a String id
     We just need to inject this DAO into the service and we can use its methods!
     Spring will implement all of those built-in methods with our Mail object in mind */

}
