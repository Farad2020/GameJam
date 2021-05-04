package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.UserDeal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDealService {
    UserDeal getUserDealById(Long id);
    UserDeal addUserDeal(UserDeal userDeal);
    List<UserDeal> getAllDealsOfUser(User user);
    void deleteUserDealById(Long id);
    void deleteUserDeal(UserDeal userDeal);
    List<UserDeal> getAllUserDeals();


}
