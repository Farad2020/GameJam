package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.DealUser;
import com.bezkoder.springjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealUserRepository extends JpaRepository<DealUser, Long> {
    List<DealUser> findAllByUser(User user);
}
