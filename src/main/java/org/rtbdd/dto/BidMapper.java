package org.rtbdd.dto;

import org.rtbdd.model.Bid;

public class BidMapper {
    public static BidDto toDto(Bid bid) {
        if (bid == null) return null;

        BidDto dto = new BidDto();
        dto.setId(bid.getId());
        dto.setBidAmount(bid.getBidAmount());
        dto.setBidTime(bid.getBidTime());
        dto.setBidderId(bid.getBidder().getId());
        dto.setItemId(bid.getItem().getId());
        return dto;
    }

    public static Bid fromDto(BidDto dto) {
        return null;
    }
}
