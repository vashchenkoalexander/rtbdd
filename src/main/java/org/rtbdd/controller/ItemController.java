package org.rtbdd.controller;

import jakarta.annotation.security.RolesAllowed;
import org.rtbdd.dto.ItemDto;
import org.rtbdd.model.Item;
import org.rtbdd.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ItemController.API_VERSION)
public class ItemController {

    public static final String API_VERSION = "${api.version}" + "item";

    private final ItemService itemService;
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/save")
    @RolesAllowed("USER")
    public ItemDto save(@RequestBody Item item) {
        return itemService.save(item);
    }

    @GetMapping("/all")
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems();
    }
}
