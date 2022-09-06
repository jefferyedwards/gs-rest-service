package net.edwardsonthe.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.edwardsonthe.common.Greeting;

@RestController
@Slf4j
public class Controller {

   private static final String template = "Hello, %s!";
   private final AtomicLong counter = new AtomicLong();

   @GetMapping("/greeting")
   public Greeting greeting(@RequestParam(value = "name") String name) {
      if (null == name) throw new RuntimeException("name cannot be null!");
      log.info("name: {}", name);
      return new Greeting(counter.incrementAndGet(), String.format(template, name));
   }
}