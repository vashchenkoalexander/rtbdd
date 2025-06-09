package org.rtbdd.dto;

import org.rtbdd.model.Item;
import org.rtbdd.model.User;

public class ItemMapper {

    public static ItemDto toDto(Item item) {
        if (item == null) return null;

        ItemDto dto = new ItemDto();
        dto.setId(item.getId());
        dto.setUserId(item.getUser() != null ? item.getUser().getId() : null);
        dto.setTitle(item.getTitle());
        dto.setDescription(item.getDescription());
        dto.setCurrentPrice(item.getCurrentPrice());
        dto.setStartPrice(item.getStartPrice());
        dto.setStartTime(item.getStartTime());
        dto.setEndTime(item.getEndTime());
        dto.setStatus(item.getStatus());
        return dto;
    }

    public static Item fromDto(ItemDto dto, User user) {
        if (dto == null) return null;

        Item item = new Item();
        item.setId(dto.getId());
        item.setUser(user); // Injected externally or loaded by ID
        item.setTitle(dto.getTitle());
        item.setDescription(dto.getDescription());
        item.setStartPrice(dto.getStartPrice());
        item.setStartTime(dto.getStartTime());
        item.setEndTime(dto.getEndTime());
        item.setStatus(dto.getStatus());
        return item;
    }
}

