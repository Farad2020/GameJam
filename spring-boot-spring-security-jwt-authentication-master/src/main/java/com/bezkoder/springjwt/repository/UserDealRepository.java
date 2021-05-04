package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.UserDeal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDealRepository extends JpaRepository<UserDeal, Long> {
    List<UserDeal> findAllByUser(User user);
}
