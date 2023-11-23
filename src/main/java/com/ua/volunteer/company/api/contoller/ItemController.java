package com.ua.volunteer.company.api.contoller;

import com.ua.volunteer.company.DTO.RequestItemDTO;
import com.ua.volunteer.company.entity.Item;
import com.ua.volunteer.company.entity.Photo;
import com.ua.volunteer.company.entity.RequestItem;
import com.ua.volunteer.company.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/volunteers/item")
    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

    @GetMapping("/volunteers/item/{id}")
    public Item getItem(@PathVariable("id") Integer id) {
        return itemRepository.getItem(id);
    }

    @PutMapping("/volunteers/item/{id}")
    public Item updateItem(@RequestBody Item item, @PathVariable("id") Integer id) {
        item.setId(id);
        return itemRepository.updateItem(item);
    }

    @PostMapping("/volunteers/item")
    public Item createItem(@RequestBody Item item) {
        return itemRepository.createItem(item);
    }

    @DeleteMapping("/volunteers/item/{id}")
    public void deleteItem(@PathVariable("id") Integer id) {
        itemRepository.deleteItem(id);
    }

    @GetMapping("/volunteers/item/{id}/photo")
    public List <Photo> getPhotos(@PathVariable("id") Integer id){
        return itemRepository.getItemPhotos(id);
    }

    @PostMapping("/volunteers/item/{id}/photo")
    public void createPhoto(@RequestParam("photo") MultipartFile photo,@PathVariable("id") Integer id) {
        try {
            byte[] photoBytes = photo.getBytes();
            itemRepository.createPhoto(id,photoBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
