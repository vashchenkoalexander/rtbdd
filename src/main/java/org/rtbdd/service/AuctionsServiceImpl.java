package org.rtbdd.service;

import org.rtbdd.dto.ItemDto;
import org.rtbdd.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionsServiceImpl implements AuctionsService {

    private final ItemService itemService;

    public AuctionsServiceImpl(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public List<ItemDto> getActiveAuctions() {
        return itemService.getAllActiveItems();
    }
}
