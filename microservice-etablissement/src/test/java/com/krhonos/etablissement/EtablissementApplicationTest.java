package com.krhonos.etablissement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EtablissementApplicationTest {

  /**
   * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b> <br/>
   * <br/>
   * Les fonctionnalites d'ecriture de messages de log dans la console.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(EtablissementApplicationTest.class);


  @Test
  public void contextLoads() {
    LOGGER.info("CLASS : EtablissementApplicationTest -- METHOD : contextLoads -- BEGIN");
    LOGGER.info("CLASS : EtablissementApplicationTest -- METHOD : contextLoads -- END");
  }
}
