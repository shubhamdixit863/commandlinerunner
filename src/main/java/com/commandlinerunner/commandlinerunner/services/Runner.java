package com.commandlinerunner.commandlinerunner.services;

import com.commandlinerunner.commandlinerunner.models.Response;
import org.apache.logging.log4j.Level;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.EntryMessage;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.util.MessageSupplier;
import org.apache.logging.log4j.util.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;


@Component
public class Runner implements CommandLineRunner {

    @Qualifier("getWebClientBuilder")
    @Autowired
    private WebClient.Builder clientbuilder;

    private final String Url="http://localhost:4000/formsubmit";


  Logger log= LoggerFactory.getLogger(Runner.class);

    // All the code written inside this method will be run just after the application gets started
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Argument length"+args.length);
      if(args.length==1)
      {


          try {
              Response result=   clientbuilder.build()
                      .post()
                      .uri(Url)
                      .body(BodyInserters.fromFormData("data", args[0]))
                      .retrieve()
                      .bodyToMono(Response.class)
                      .block();  // waiting for the data to retireve from asynchronous call

              System.out.println(result);

          }
          catch (Exception e)
          {
              log.error(e.toString());
          }
      }

      else{
          throw  new Exception("Too many args");
      }




    }



}
