package hu.elte.shoppinglist.repositories;

import hu.elte.shoppinglist.entities.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer>{
    
}