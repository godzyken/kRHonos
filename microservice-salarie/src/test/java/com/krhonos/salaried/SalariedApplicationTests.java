package com.krhonos.salaried;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalariedApplicationTests {

  /**
   * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b> <br/>
   * <br/>
   * Les fonctionnalites d'ecriture de messages de log dans la console.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(SalariedApplicationTests.class);


	@Test
    public void contextLoads() {
      LOGGER.info("CLASS : SalariedApplicationTests -- METHOD : contextLoads -- BEGIN");
      LOGGER.info("CLASS : SalariedApplicationTests -- METHOD : contextLoads -- END");

    }

}
