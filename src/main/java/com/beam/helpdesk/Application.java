/*
 * Author.......: Greg Beam
 * Date ........: 7/1/2018
 * Description..: Helpdesk Spring Boot Test Applicaiton
 * 
 */
package com.beam.helpdesk;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}