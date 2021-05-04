package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Deal;
import com.bezkoder.springjwt.models.DealUser;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.services.DealUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Transactional
@RequestMapping("/api/test")
public class TestController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}

	@Autowired
	DealUserService dealUserService;

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content. And here's the data to show that." + usernameGetter();
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}

	//Add a request, when absent, delete the user deal and if deal is null
	@RequestMapping("/linkGiveaway")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public boolean createUserDeal(
			@RequestParam(defaultValue = "0") Long giveawayId
	){
		User user = getCurrentUser();
		if(user != null && giveawayId != 0){
			if(dealUserService.getIfExistsByUserAndId(user, giveawayId) == null){
				dealUserService.addDealUser(new DealUser(null, giveawayId, user));
			}else{
				dealUserService.deleteDealUserByUserAndDealId(user, giveawayId);
			}
		}
		return dealUserService.getIfExistsByUserAndId(user, giveawayId) == null;
	}

	@RequestMapping("/checkUserDeal")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public boolean checkUserDeal(
			@RequestParam(defaultValue = "0") Long giveawayId
	){
		User user = getCurrentUser();
		return dealUserService.getIfExistsByUserAndId(user, giveawayId) == null;
	}

	@RequestMapping("/userDeals")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ArrayList<Deal> getUserDeals(
	){
		User user = getCurrentUser();
		List<DealUser> dealUsers = dealUserService.getAllDealsOfUser(user);
		ArrayList<Deal> deals = new ArrayList<>();
		for (int i = 0; i < dealUsers.size(); i++){
			deals.add(
					restTemplate.getForObject(
					"https://www.gamerpower.com/api/giveaway?id=" + dealUsers.get(i).getDealId(),
					Deal.class
					)
			);
		}
		return deals;
	}

	private User getCurrentUser(){
		if (userRepository.findByUsername(getCurrentUsername()).isPresent()){
			return userRepository.findByUsername(getCurrentUsername()).get();
		}
		return null;
	}

	private String getCurrentUsername(){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return userDetails.getUsername();
	}

	private String usernameGetter(){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return userDetails.getUsername();
	}
}
