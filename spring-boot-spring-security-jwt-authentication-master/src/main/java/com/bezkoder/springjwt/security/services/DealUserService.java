package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.models.DealUser;
import com.bezkoder.springjwt.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DealUserService {
    DealUser getDealUserById(Long id);
    DealUser addDealUser(DealUser dealUser);
    List<DealUser> getAllDealsOfUser(User user);
    void deleteDealUserById(Long id);
    void deleteDealUser(DealUser dealUser);
    List<DealUser> getAllDealUsers();
    DealUser getIfExistsByUserAndId(User user, Long id);
    void deleteDealUserByUserAndDealId(User user, Long id);
}
