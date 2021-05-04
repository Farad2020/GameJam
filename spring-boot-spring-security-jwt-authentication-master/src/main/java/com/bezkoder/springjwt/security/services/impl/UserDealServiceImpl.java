package com.bezkoder.springjwt.security.services.impl;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.UserDeal;
import com.bezkoder.springjwt.repository.UserDealRepository;
import com.bezkoder.springjwt.security.services.UserDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDealServiceImpl implements UserDealService {

    @Autowired
    private UserDealRepository userDealRepository;

    @Override
    public UserDeal addUserDeal(UserDeal userDeal) {
        return userDealRepository.save(userDeal);
    }

    @Override
    public List<UserDeal> getAllDealsOfUser(User user) {
        return userDealRepository.findAllByUser(user);
    }

    @Override
    public List<UserDeal> getAllUserDeals() {
        return userDealRepository.findAll();
    }

    @Override
    public void deleteUserDealById(Long id) {
        userDealRepository.deleteById(id);
    }

    @Override
    public void deleteUserDeal(UserDeal userDeal) {
        userDealRepository.delete(userDeal);
    }

    @Override
    public UserDeal getUserDealById(Long id) {
        return userDealRepository.getOne(id);
    }
}
