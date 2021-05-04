package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "users_deals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Deal deal;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}