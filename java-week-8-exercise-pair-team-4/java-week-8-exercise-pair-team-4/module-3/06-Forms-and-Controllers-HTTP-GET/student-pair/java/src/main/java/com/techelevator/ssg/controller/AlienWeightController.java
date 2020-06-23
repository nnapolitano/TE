package com.techelevator.ssg.controller;

import com.techelevator.ssg.model.AlienWeightCalculation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlienWeightController {

    @RequestMapping("/alienWeight")
    public String showAlienWeightPage() {

        return "alienWeight";
    }

    @RequestMapping("/alienWeightResult")
    public String showALienWeightResults(@RequestParam double earthWeight, @RequestParam String planet, ModelMap modelMap){

        AlienWeightCalculation alienWeight = new AlienWeightCalculation(earthWeight, planet);
        alienWeight.calculateWeight(earthWeight, planet);
        modelMap.put("alienWeight", alienWeight);


        return "alienWeightResult";


}

}
