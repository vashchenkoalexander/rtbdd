package org.rtbdd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Item {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user_id;

    private String title;
    private String description;
    private Float start_price;
    private Date start_time;
    private Date end_time;
    private ItemStatus status;
}
