package net.edwardsonthe.common;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Ignore
public class ProxyTest {

   @Test
   public void test() throws IOException {
      Proxy proxy = new Proxy();
      Greeting greeting = proxy.greeting(null);
      log.info("{}", greeting);
   }

}
