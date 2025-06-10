package org.rtbdd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AuctionsController.API_VERSION)
public class AuctionsController {
    public static final String API_VERSION = "${api.version}" + "auctions";
}
