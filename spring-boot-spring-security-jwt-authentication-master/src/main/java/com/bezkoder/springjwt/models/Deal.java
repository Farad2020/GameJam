package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "deals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "title")
    public String title;

    @Column(name = "worth")
    public String worth;

    @Column(name = "thumbnail")
    public String thumbnail;

    @Column(name = "image")
    public String image;

    @Column(name = "description")
    public String description;

    @Column(name = "instructions")
    public String instructions;

    @Column(name = "open_giveaway_url")
    public String open_giveaway_url;

    @Column(name = "published_date")
    public String published_date;

    @Column(name = "type")
    public String type;

    @Column(name = "platforms")
    public String platforms;

    @Column(name = "end_date")
    public String end_date;

    @Column(name = "users")
    public int users;

    @Column(name = "status")
    public String status;

    @Column(name = "gamerpower_url")
    public String gamerpower_url;

    @Column(name = "open_giveaway")
    public String open_giveaway;
}