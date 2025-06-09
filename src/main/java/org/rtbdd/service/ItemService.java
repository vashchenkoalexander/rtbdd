package org.rtbdd.service;

import org.rtbdd.dto.ItemDto;
import org.rtbdd.dto.ItemMapper;
import org.rtbdd.exception.ItemNotExistException;
import org.rtbdd.model.Item;
import org.rtbdd.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final UserService userService;

    public ItemService(ItemRepository itemRepository, UserService userService) {
        this.itemRepository = itemRepository;
        this.userService = userService;
    }

    public ItemDto save(Item item) {
        item.setStartTime(LocalDateTime.now());
        item.setUser(userService.getCurrentUser());
        itemRepository.save(item);
        return ItemMapper.toDto(item);
    }

    public List<ItemDto> getAllItems(){
        return itemRepository.findAll().stream().map(ItemMapper::toDto).toList();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotExistException("Item not found by id:" + id));
    }

}
