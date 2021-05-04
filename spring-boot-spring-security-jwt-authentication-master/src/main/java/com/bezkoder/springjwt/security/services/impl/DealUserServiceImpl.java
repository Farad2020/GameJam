package com.bezkoder.springjwt.security.services.impl;

import com.bezkoder.springjwt.models.DealUser;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.DealUserRepository;
import com.bezkoder.springjwt.security.services.DealUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealUserServiceImpl implements DealUserService {
    @Autowired
    private DealUserRepository dealUserRepository;


    @Override
    public DealUser getDealUserById(Long id) {
        return dealUserRepository.findById(id).get();
    }

    @Override
    public DealUser addDealUser(DealUser dealUser) {
        return dealUserRepository.save(dealUser);
    }

    @Override
    public List<DealUser> getAllDealsOfUser(User user) {
        return dealUserRepository.findAllByUser(user);
    }

    @Override
    public void deleteDealUserById(Long id) {
        dealUserRepository.deleteById(id);
    }

    @Override
    public void deleteDealUser(DealUser dealUser) {
        dealUserRepository.delete(dealUser);
    }

    @Override
    public List<DealUser> getAllDealUsers() {
        return dealUserRepository.findAll();
    }
}
