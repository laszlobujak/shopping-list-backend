package hu.elte.shoppinglist.repositories;

import hu.elte.shoppinglist.entities.ShoppingList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList, Integer>{
    
}