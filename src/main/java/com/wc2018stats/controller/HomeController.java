package com.wc2018stats.controller;

import com.wc2018stats.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// annotations handle URI requests
@Controller
@ComponentScan()
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
  //  @ResponseBody
    public String listTeams(String teamCode, ModelMap modelMap) throws IOException {
        Map<String, List<Team>> perGroupTeams = new Teams().getTeamsByGroup();
        modelMap.addAttribute("perGroupTeams", perGroupTeams);
        System.out.println(modelMap);
        return "home";
    }


}
