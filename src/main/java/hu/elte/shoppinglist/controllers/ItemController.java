package hu.elte.shoppinglist.controllers;

import hu.elte.shoppinglist.entities.Item;
import hu.elte.shoppinglist.entities.Message;
import hu.elte.shoppinglist.repositories.ItemRepository;
import hu.elte.shoppinglist.repositories.MessageRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Item>> getAll() {
        return ResponseEntity.ok(itemRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> get(@PathVariable Integer id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            return ResponseEntity.ok(item.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Item> post(@RequestBody Item item) {
        Item savedItem = itemRepository.save(item);
        return ResponseEntity.ok(savedItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Integer id,
            @RequestBody Item item) {
        Optional<Item> oItem = itemRepository.findById(id);
        if (oItem.isPresent()) {
            item.setId(id);
            return ResponseEntity.ok(itemRepository.save(item));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/message")
    public ResponseEntity<Iterable<Message>> message
            (@PathVariable Integer id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            return ResponseEntity.ok(item.get().getMessages());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/message")
    public ResponseEntity<Message> insertMessage
            (@PathVariable Integer id,
             @RequestBody Message message) {
        Optional<Item> oItem = itemRepository.findById(id);
        if (oItem.isPresent()) {
            Item item = oItem.get();
            message.setItem(item);
            return ResponseEntity.ok(
                messageRepository.save(message));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> delete(@PathVariable Integer id) {
        Optional<Item> oItem = itemRepository.findById(id);
        if (oItem.isPresent()) {
            itemRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
