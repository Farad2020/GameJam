package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users_deals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="deal_id")
    private Long dealId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
