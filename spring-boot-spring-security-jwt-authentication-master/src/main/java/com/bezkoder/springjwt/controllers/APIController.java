package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Deal;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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

//    @RequestMapping("/search")
//    public Deal[] getDealsBySearch(
//            @RequestParam(defaultValue = "empty") String text
//    ){
//        if(text != null && !text.isEmpty()){
//            ResponseEntity<Deal[]> responseEntity = restTemplate.getForEntity(
//                    "https://www.gamerpower.com/api/giveaways",
//                    Deal[].class
//            );
//
//            Deal[] deals = responseEntity.getBody();
//
//            return filterDealsByName(deals, text);
//        }
//        return new Deal[0];
//    }

    @RequestMapping("/search")
    public Deal[] getDealsBySearchWithParams(
            @RequestParam(defaultValue = "empty") String text,
            @RequestParam(defaultValue = "empty") String platform,
            @RequestParam(defaultValue = "empty")  String type
    ){
        String reqParams = "";
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
        try{
            if(text != null && !text.isEmpty()){
                ResponseEntity<Deal[]> responseEntity = restTemplate.getForEntity(
                        "https://www.gamerpower.com/api/giveaways" + reqParams,
                        Deal[].class
                );

                Deal[] deals = responseEntity.getBody();

                return filterDealsByName(deals, text);
            }
        }catch (Exception e){

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
}
