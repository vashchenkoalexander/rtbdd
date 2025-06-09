package org.rtbdd.service;

import org.rtbdd.dto.BidDto;
import org.rtbdd.dto.BidMapper;
import org.rtbdd.exception.UserBiddingItemException;
import org.rtbdd.model.Bid;
import org.rtbdd.model.Item;
import org.rtbdd.model.ItemStatus;
import org.rtbdd.model.User;
import org.rtbdd.repository.BidRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BidService {

    private final BidRepository bidRepository;
    private final UserService userService;
    private final ItemService itemService;

    public BidService(BidRepository bidRepository, UserService userService, ItemService itemService) {
        this.bidRepository = bidRepository;
        this.userService = userService;
        this.itemService = itemService;
    }

    public BidDto createBid(Bid bid, Long itemId) {

        User currentUser = userService.getCurrentUser();
        Item item = itemService.getItemById(itemId);

        validateBid(currentUser, item, bid.getBidAmount());

        item.setCurrentPrice(bid.getBidAmount());
        itemService.save(item);

        bid.setItem(item);
        bid.setBidder(currentUser);
        bid.setBidTime(LocalDateTime.now());

        bidRepository.save(bid);
        return BidMapper.toDto(bid);
    }

    private void validateBid(User currentUser, Item item, double bidAmount) {

        if (!item.getStatus().equals(ItemStatus.OPEN)) {
            throw new UserBiddingItemException("Item status is not OPEN. Bidding failed.");
        }

        if (currentUser.getId().equals(item.getUser().getId())) {
            throw new UserBiddingItemException("Users cannot bid on their own items.");
        }

        if (bidAmount <= item.getCurrentPrice()) {
            throw new UserBiddingItemException("Bid amount must be higher than the current price.");
        }
    }


}
