package org.rtbdd.controller;

import org.rtbdd.dto.ItemDto;
import org.rtbdd.service.AuctionsServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.version}/auctions")
public class AuctionsController {

    private final AuctionsServiceImpl auctionsService;

    public AuctionsController(AuctionsServiceImpl auctionsService) {
        this.auctionsService = auctionsService;
    }

    @GetMapping("/all")
    public List<ItemDto> getAllActiveAuctions(){
        return auctionsService.getActiveAuctions();
    }
}
