package com.krhonos.securite.controller;

import com.krhonos.securite.beans.PersonneBean;
import com.krhonos.securite.proxies.MPersonneProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {

  @RequestMapping("/")
  public String accueil(Model model) {
    return "Accueil";
  }

  @RequestMapping("/details-personne/{id}")
  public String fichePersonne(@PathVariable int id, Model model){

    PersonneBean personneBean = MPersonneProxy.recupererUnPersonne(id);

    model.addAttribute("personne", personneBean);

    return "FichePersonne";
  }
}
