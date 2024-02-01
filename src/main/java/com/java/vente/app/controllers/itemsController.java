package com.java.vente.app.controllers;


import com.java.vente.app.DTO.ItemsDTO;
import com.java.vente.app.models.Items;
import com.java.vente.app.services.ItemsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/vente/items")
public class itemsController {

    @Autowired
    ItemsService itemsService;

    @GetMapping
    public ResponseEntity<List<Items>> getAllItems(){
        return ResponseEntity.ok(itemsService.getAllItems());
    }
    @PostMapping
    public ItemsDTO createItem(@Valid @RequestBody ItemsDTO itemsDTO){
        return itemsService.createItem(itemsDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ItemsDTO> updateItems(@PathVariable Long id , @Valid @RequestBody ItemsDTO itemDTO){
        return ResponseEntity.ok(itemsService.updateItems(id,itemDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItems(@PathVariable Long id){
        itemsService.deleteItem(id);
        return ResponseEntity.ok().build();
    }
}
