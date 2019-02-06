package hu.elte.shoppinglist.repositories;

import hu.elte.shoppinglist.entities.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer>{
    
}