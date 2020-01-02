package fr.formation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ImportResource("CLasspath:application-context.xml")//Je sais pas 
@ComponentScan("fr.formation")
public class AppConfig {
	

}
