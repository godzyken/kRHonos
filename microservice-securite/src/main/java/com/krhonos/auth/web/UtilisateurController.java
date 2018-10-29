package com.krhonos.auth.web;

import com.krhonos.auth.model.Utilisateur;
import com.krhonos.auth.service.SecuriteService;
import com.krhonos.auth.service.UtilisateurService;
import com.krhonos.auth.validator.UtilisateurValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("utilisateurs")
@CrossOrigin
public class UtilisateurController {

  @Autowired private UtilisateurService utilisateurService;

  @Autowired private SecuriteService securiteService;

  @Autowired private UtilisateurValidator utilisateurValidator;

  @RequestMapping(value = "/enregistrement", method = RequestMethod.POST)
  public String enregistrement(
      @ModelAttribute("userForm") Utilisateur userForm, BindingResult bindingResult, Model model) {

    utilisateurValidator.validate(userForm, bindingResult);

    if (bindingResult.hasErrors()) {
      return "enregistrement";
    }

    utilisateurService.save(userForm);

    securiteService.autologin(userForm.getUtilisateurnom(), userForm.getPasswordConfirme());

    return "redirect:/bienvenue";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login(Model model, String error, String logout) {
    if (error != null)
      model.addAttribute("error", "Votre pseudo e/ou votre mot de passe est invalide!");

    if (logout != null) model.addAttribute("message", "Vous etes a présent déconnecté");

    return "login";
  }

  @RequestMapping(
      value = {"/", "/bienvenue"},
      method = RequestMethod.GET)
  public String bienvenue(Model model) {
    return "bienvenue";
  }


}
