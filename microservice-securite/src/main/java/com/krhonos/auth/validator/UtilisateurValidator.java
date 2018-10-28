package com.krhonos.auth.validator;

import com.krhonos.auth.model.Utilisateur;
import com.krhonos.auth.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UtilisateurValidator implements Validator {

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Utilisateur.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors){
        Utilisateur utilisateur = (Utilisateur) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if(utilisateur.getUtilisateurnom().length() < 6 || utilisateur.getUtilisateurnom().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if(utilisateurService.findByUtilisateurnom(utilisateur.getUtilisateurnom()) != null) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        if(!utilisateur.getPasswordConfirme().equals(utilisateur.getPassword())){
            errors.rejectValue("passwordConfime", "Diff.userForm.passwordConfirme");
        }
    }
}
