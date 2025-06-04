package org.rtbdd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Bids {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "items_id", referencedColumnName = "id")
    private Item item_id;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User bidder_id;

    private Float bid_amount;

    private Date bid_time;
}
