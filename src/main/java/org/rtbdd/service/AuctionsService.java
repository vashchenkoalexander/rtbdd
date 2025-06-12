package org.rtbdd.service;

import org.rtbdd.dto.ItemDto;

import java.util.List;

public interface AuctionsService {
    List<ItemDto> getActiveAuctions();
}
