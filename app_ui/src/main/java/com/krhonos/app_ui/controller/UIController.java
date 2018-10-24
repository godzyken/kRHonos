package com.krhonos.app_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {

  @RequestMapping("/")
  public String accueil(Model model) {
    return "Accueil";
  }
}
