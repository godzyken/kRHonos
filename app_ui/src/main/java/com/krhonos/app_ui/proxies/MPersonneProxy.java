package com.krhonos.app_ui.proxies;

import com.krhonos.app_ui.beans.PersonneBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-personne", url = "localhost:9001")
public interface MPersonneProxy {

  @GetMapping(value = "/Personnes")
  List<PersonneBean> listeDePersonnes();

  @GetMapping(value = "/Personnes/{id}")
  PersonneBean recupererUnePersonne(@PathVariable("id") int id);


}
