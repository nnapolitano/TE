package com.techelevator.ssg.controller;

import com.techelevator.ssg.model.alien.Planet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlienController {

    @RequestMapping("/alienWeight")
    public String showAlienWeightPage() {

        return "alienWeight";
    }

    @RequestMapping ("/alienWeightResult")
    public String showALienWeightResults(@RequestParam int earthWeight,
                                         @RequestParam String planet, ModelMap modelMap){
        double weight = Planet.calculateAlienWeight(earthWeight,planet);
        modelMap.put("alienWeight", weight);
        return "alienWeightResult";

    }

    @RequestMapping("/alienAge")
    public String showAlienAgePage() {

        return "alienAge";
    }



    @RequestMapping ("/alienAgeResult")
    public String showALienAgeResults(@RequestParam int earthAge,
                                         @RequestParam String planet, ModelMap modelMap){
        double age = Planet.calculateAlienAge(earthAge,planet);
        modelMap.put("alienAge", age);
        return "alienAgeResult";

    }

    @RequestMapping("/alienTravel")
    public String showAlienTravelPage() {

        return "alienTravel";
    }



    @RequestMapping ("/alienTravelResult")
    public String showALienTravelResults(@RequestParam int earthAge,
                                      @RequestParam String planet, String transport, ModelMap modelMap){
        long travelTime = Planet.calculateAlienTravelTime(planet, transport);
        modelMap.put("alienTravel", travelTime);
        return "alienTravelResult";

    }

}
