package com.techelevator.controller;

import model.ProduceItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductDetailsController {

    @RequestMapping("/carrotsDetail")
    public String displayCarrotsDetail(ModelMap modelMap) {

        ProduceItem carrots = new ProduceItem("carrots", 4.00);

        modelMap.put("carrotsDetail", carrots) ;
            return "carrotsDetail";
}
    @RequestMapping("/cucumbersDetail")
    public String displayCucumbersDetail() {
        return "cucumbersDetail";
    }
    @RequestMapping("/peppersDetail")
    public String displayPeppersDetail() {
        return "peppersDetail";
    }
    @RequestMapping("/radishesDetail")
    public String displayRadishesDetail() {
        return "radishesDetail";
    }
    @RequestMapping("/tomatoesDetail")
    public String displayTomatoesDetail() {
        return "tomatoesDetail";
    }






}



