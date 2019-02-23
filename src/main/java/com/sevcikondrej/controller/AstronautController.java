package com.sevcikondrej.controller;

import com.sevcikondrej.service.AstronautService;
import com.sevcikondrej.entity.Astronaut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/astronaut")
public class AstronautController {

    //need to inject astronaut service
    @Autowired
    private AstronautService astronautService;

    @GetMapping("list")
    public String listAstronauts(Model theModel){

        //get astronauts from the service
         List<Astronaut> theAstronauts = astronautService.getAstronauts();

        //add the astronauts to the model
        theModel.addAttribute("astronauts", theAstronauts);

        return "list-astronauts";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        //create model attribute to bind data
        Astronaut theAstronaut = new Astronaut();
        theModel.addAttribute("astronaut", theAstronaut);

        return "astronaut-form";
    }

    @PostMapping("/addAstronaut")
    public String addAstronaut(@Valid @ModelAttribute("astronaut") Astronaut theAstronaut, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "astronaut-form";
        }
        else{
            //save the astronaut using service
            astronautService.addAstronaut(theAstronaut);

            return "redirect:/astronaut/list";

        }
        }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("astronautId") int theId, Model theModel){
        //get astronaut from the database
        Astronaut theAstronaut = astronautService.getAstronaut(theId);
        //add astroonaut as a model attribute to pre-populate
        theModel.addAttribute("astronaut", theAstronaut);

        return "astronaut-form";
    }

    @GetMapping("/delete")
    public String deleteAstronaut(@RequestParam("astronautId") int theId){
        //delete the astronaut
        astronautService.deleteAstronaut(theId);

        return "redirect:/astronaut/list";
    }
    @GetMapping("/search")
    public String searchAstronauts(@RequestParam("theSearchName") String theSearchName, Model theModel){

        //search for astronauts from the service
        List<Astronaut> theAstronauts = astronautService.searchAstronaut(theSearchName);

        //add the astronauts to the model
        theModel.addAttribute("astronauts", theAstronauts);

        return "list-astronauts";

    }


}
