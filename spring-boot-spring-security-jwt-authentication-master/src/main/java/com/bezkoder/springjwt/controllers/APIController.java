package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Deal;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.UserDeal;
import com.bezkoder.springjwt.repository.UserDealRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.services.UserDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/giveaways")
public class APIController {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDealService userDealService;

    @RequestMapping("/id/{giveawayId}")
    public Deal getDealById(@PathVariable("giveawayId") int giveawayId){
        Deal deal = restTemplate.getForObject(
                "https://www.gamerpower.com/api/giveaway?id=" + giveawayId,
                Deal.class
        );
        return deal;
    }

    // pc, steam, epic-games-store, ubisoft, gog, itchio, ps4, xbox-one, switch, android, ios, vr, battlenet, origin, drm-free
    @RequestMapping("/platform/{platformName}")
    public Deal[] getDealsByPlatform(@PathVariable("platformName") String platformName){
        ResponseEntity<Deal[]> responseEntity = restTemplate.getForEntity(
                "https://www.gamerpower.com/api/giveaways?platform=" + platformName,
                Deal[].class
        );

        Deal[] deals = responseEntity.getBody();

//        System.out.println(deals.toString());
        return deals;
    }

    //game, loot, beta
    @RequestMapping("/type/{typeName}")
    public Deal[] getDealsByType(@PathVariable("typeName") String typeName){
        ResponseEntity<Deal[]> responseEntity = restTemplate.getForEntity(
                "https://www.gamerpower.com/api/giveaways?type=" + typeName,
                Deal[].class
        );

        Deal[] deals = responseEntity.getBody();

//        System.out.println(deals.toString());
        return deals;
    }

    @RequestMapping("/all")
    public Deal[] getAllDeals(){
        ResponseEntity<Deal[]> responseEntity = restTemplate.getForEntity(
                "https://www.gamerpower.com/api/giveaways",
                Deal[].class
        );

        Deal[] deals = responseEntity.getBody();

//        System.out.println(deals.toString());
        return deals;
    }

    @RequestMapping("/top")
    public Deal[] getTopDeals(
            @RequestParam(defaultValue = "8") int number
    ){
        ResponseEntity<Deal[]> responseEntity = restTemplate.getForEntity(
                "https://www.gamerpower.com/api/giveaways?sort-by=popularity",
                Deal[].class
        );

        Deal[] deals = responseEntity.getBody();

        System.out.println(number);
        if(deals != null){
            return getSubArrayOfDeals(deals, number);
        }
        else{
            return new Deal[0];
        }
    }

    private Deal[] getSubArrayOfDeals(Deal[] originalArr, int minNumOfElem){
        if (originalArr == null) {
            return new Deal[0];
        }

        if( !(originalArr.length > minNumOfElem) ){
            return originalArr;
        }
        Deal[] deals = new Deal[minNumOfElem];
        for( int i = 0; i < minNumOfElem; i++){
            deals[i] = originalArr[i];
        }
        return deals;
    }

    @RequestMapping("/params")
    public Deal[] getAllDealsWithParams(
            @RequestParam(defaultValue = "empty") String platform,
            @RequestParam(defaultValue = "empty")  String type,
            @RequestParam(defaultValue = "empty") String sort_by,
            @RequestParam(defaultValue = "0") int number
    ){
        String reqParams = "";
        if (!platform.equals("empty") || !type.equals("empty") || !sort_by.equals("empty")){
            if(!platform.equals("empty")){
                reqParams+= "?platform=" + platform;
            }

            if(!type.equals("empty")){
                if(reqParams.isEmpty()){
                    reqParams+= "?type=" + type;
                }else{
                    reqParams+= "&type=" + type;
                }
            }

            if(!sort_by.equals("empty")){
                if(reqParams.isEmpty()){
                    reqParams+= "?sort-by=" + sort_by;
                }else{
                    reqParams+= "&sort-by=" + sort_by;
                }
            }

        }

        ResponseEntity<Deal[]> responseEntity = restTemplate.getForEntity(
                "https://www.gamerpower.com/api/giveaways" + reqParams,
                Deal[].class
        );

        Deal[] deals = responseEntity.getBody();

//        System.out.println(deals.toString());
        if (number > 0){
          return getSubArrayOfDeals(deals, number);
        }
        return deals;
    }

    @RequestMapping("/search")
    public Deal[] getDealsBySearch(
            @RequestParam(defaultValue = "empty") String text
    ){
        if(text != null && !text.isEmpty()){
            ResponseEntity<Deal[]> responseEntity = restTemplate.getForEntity(
                    "https://www.gamerpower.com/api/giveaways",
                    Deal[].class
            );

            Deal[] deals = responseEntity.getBody();

            return filterDealsByName(deals, text);
        }
        return new Deal[0];
    }

    private Deal[] filterDealsByName(Deal[] originalArr, String  text){
        if (originalArr == null) {
            return new Deal[0];
        }

        ArrayList<Deal> filteredDeals = new ArrayList<>();

        for (Deal deal: originalArr) {
            if(deal.title.toLowerCase().contains(text.toLowerCase())){
                filteredDeals.add(deal);
            }
        }

        return filteredDeals.toArray(new Deal[0]);
    }


    //Add a request, when absent, delete the user deal and if deal is null
    @RequestMapping("/linkGiveaway")
    public Deal[] createUserDeal(
            @RequestParam(defaultValue = "0") Long giveawayId
    ){
        User user = getCurrentUser();
        if(user != null && giveawayId != 0){
            Deal deal = restTemplate.getForObject(
                    "https://www.gamerpower.com/api/giveaway?id=" + giveawayId,
                    Deal.class
            );

            userDealService.addUserDeal(new UserDeal(null, deal, user));
        }
        return new Deal[0];
    }

    private User getCurrentUser(){
        if (userRepository.findByUsername(getCurrentUsername()).isPresent()){
            return userRepository.findByUsername(getCurrentUsername()).get();
        }
        return null;
    }

    private String getCurrentUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userDetails.getUsername();
        }
        return null;
    }
}
