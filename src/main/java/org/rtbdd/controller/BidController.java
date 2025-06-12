package org.rtbdd.controller;

import org.rtbdd.dto.BidDto;
import org.rtbdd.model.Bid;
import org.rtbdd.service.BidService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.version}/bid")
public class BidController {

    private final BidService bidService;

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @PostMapping("/new/{itemId}")
    public BidDto saveBid(@RequestBody Bid bid, @PathVariable Long itemId){
        return bidService.createBid(bid, itemId);
    }
}
