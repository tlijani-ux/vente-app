package com.java.vente.app.services;

import com.java.vente.app.DTO.ItemsDTO;
import com.java.vente.app.models.Items;
import com.java.vente.app.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    public ItemsDTO createItem(ItemsDTO itemsDTO) {
        Items item = convertToEntity(itemsDTO);

        if (item.getStock().equals("0")) {
            item.setIs_available(false);
        }

        return convertToDTO(itemsRepository.save(item));
    }

    public List<Items> getAllItems() {
        return itemsRepository.findAll();
    }

    public Optional<Items> getItemById(Long id) {
        return itemsRepository.findById(id);
    }

    public ItemsDTO updateItems(Long id, ItemsDTO itemsDTO) {
        return itemsRepository.findById(id).map(i -> {
            i.setIs_available(itemsDTO.getIs_available());
            i.setItem_name(itemsDTO.getItem_name());
            i.setItem_code(itemsDTO.getItem_code());
            i.setLast_re_stock(itemsDTO.getLast_re_stock());
            i.setPrice(itemsDTO.getPrice());
            i.setStock(itemsDTO.getStock());

            if (i.getStock().equals("0")) {
                i.setIs_available(false);
            }

            return convertToDTO(itemsRepository.save(i));
        }).orElseThrow(() -> new RuntimeException("Item not found with id " + id));
    }

    private ItemsDTO convertToDTO(Items items) {
        ItemsDTO itemDTO = new ItemsDTO();
        itemDTO.setIs_available(Boolean.valueOf(String.valueOf(items.isIs_available())));
        itemDTO.setItem_name(items.getItem_name());
        itemDTO.setItem_code(items.getItem_code());
        itemDTO.setLast_re_stock(items.getLast_re_stock() != null ? Double.valueOf(String.valueOf(items.getLast_re_stock())) : null);
        itemDTO.setPrice(Double.valueOf(items.getPrice()));
        itemDTO.setStock(Double.valueOf(items.getStock()));
        return itemDTO;
    }




    public Items convertToEntity(ItemsDTO itemsDTO) {
        Items item = new Items();
        item.setIs_available(itemsDTO.getIs_available());
        item.setItem_name(itemsDTO.getItem_name());
        item.setItem_code(itemsDTO.getItem_code());
        item.setLast_re_stock(itemsDTO.getLast_re_stock());
        item.setPrice(itemsDTO.getPrice());
        item.setStock(itemsDTO.getStock());
        return item;
    }

    public void deleteItem(Long id) {
        itemsRepository.deleteById(id);
    }
}
