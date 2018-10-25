package com.krhonos.contrat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratApplicationTest {

  /**
   * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b> <br/>
   * <br/>
   * Les fonctionnalites d'ecriture de messages de log dans la console.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(ContratApplicationTest.class);


  @Test
  public void contextLoads() {
    LOGGER.info("CLASS : ContratApplicationTest -- METHOD : contextLoads -- BEGIN");
    LOGGER.info("CLASS : ContratApplicationTest -- METHOD : contextLoads -- END");
  }
}
