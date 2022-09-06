package net.edwardsonthe.common;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Proxy {

   static final ObjectMapper objectMapper = new ObjectMapper();

   static final String GREETING_BASE_URL = "http://localhost:8080/greeting";

   public Greeting greeting(String name) throws IOException {

      Greeting greeting = null;

      StringBuilder builder = new StringBuilder();
      builder.append(GREETING_BASE_URL);
      if (null != name) builder.append("?name=").append(name);
      String url = builder.toString();
      log.info("proxy call to url {}", url);

      CloseableHttpClient httpClient = HttpClients.createDefault();

      try {

         HttpGet request = new HttpGet(url);
         CloseableHttpResponse response = httpClient.execute(request);

         try {

            log.info("" + response.getProtocolVersion()); // HTTP/1.1
            log.info("" + response.getStatusLine().getStatusCode()); // 200
            log.info("" + response.getStatusLine().getReasonPhrase()); // OK
            log.info("" + response.getStatusLine().toString()); // HTTP/1.1 200 OK

            HttpEntity entity = response.getEntity();
            if (entity != null) {
               // return it as a String
               String result = EntityUtils.toString(entity);
               log.info("result: {}", result);
               greeting = objectMapper.readValue(result, Greeting.class);
            }

         } finally {
            response.close();
         }

      } finally {
         httpClient.close();
      }

      log.info("returning: {}", greeting);
      return greeting;

   }

}
