package hu.elte.shoppinglist.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hu.elte.shoppinglist.entities.Item;
import hu.elte.shoppinglist.entities.ShoppingList;
import hu.elte.shoppinglist.repositories.ItemRepository;
import hu.elte.shoppinglist.repositories.ShoppingListRepository;

@RestController
@RequestMapping("/shoppinglist")
public class ShoppingListController {
    @Autowired
    private ShoppingListRepository shoppingListRepository;
    
    @Autowired
    private ItemRepository itemRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<ShoppingList>> getAll() {
        return ResponseEntity.ok(shoppingListRepository.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ShoppingList> get(@PathVariable Integer id) {
        Optional<ShoppingList> shoppingList = shoppingListRepository.findById(id);
        if (shoppingList.isPresent()) {
            return ResponseEntity.ok(shoppingList.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("")
    public ResponseEntity<ShoppingList> post(@RequestBody ShoppingList shoppingList) {
        ShoppingList savedShoppingList = shoppingListRepository.save(shoppingList);
        return ResponseEntity.ok(savedShoppingList);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ShoppingList> put(@RequestBody ShoppingList shoppingList, @PathVariable Integer id) {
        Optional<ShoppingList> oShoppingList = shoppingListRepository.findById(id);
        if (oShoppingList.isPresent()) {
            shoppingList.setId(id);
            return ResponseEntity.ok(shoppingListRepository.save(shoppingList));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/{id}/item")
    public ResponseEntity<Iterable<Item>> item
            (@PathVariable Integer id) {
        Optional<ShoppingList> shoppingList = shoppingListRepository.findById(id);
        if (shoppingList.isPresent()) {
            return ResponseEntity.ok(shoppingList.get().getItems());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
            
    @PostMapping("/{id}/item")
    public ResponseEntity<Item> insertItem
            (@PathVariable Integer id,
             @RequestBody Item item) {
        Optional<ShoppingList> oShoppingList = shoppingListRepository.findById(id);
        if (oShoppingList.isPresent()) {
            ShoppingList shoppingList = oShoppingList.get();
            item.setShoppinglist(shoppingList);
            return ResponseEntity.ok(
                itemRepository.save(item));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<ShoppingList> oShoppingList = shoppingListRepository.findById(id);
        if (oShoppingList.isPresent()) {
            shoppingListRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
