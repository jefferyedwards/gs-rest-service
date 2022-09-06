package net.edwardsonthe.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.edwardsonthe.common.Greeting;
import net.edwardsonthe.common.LocalTime;

@RestController
@Slf4j
public class Controller {

   private static final String template = "Hello, %s!";
   private final AtomicLong counter = new AtomicLong();

   @GetMapping("/greeting")
   public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
      if (null == name) throw new RuntimeException("name cannot be null!");
      Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
      log.info("returning: {}", greeting);
      return greeting;
   }

   @GetMapping("/localTime")
   public LocalTime localTime() {
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
      LocalDateTime now = LocalDateTime.now();
      LocalTime localTime = new LocalTime(dtf.format(now));
      log.info("returning: {}", localTime);
      return localTime;
   }

}