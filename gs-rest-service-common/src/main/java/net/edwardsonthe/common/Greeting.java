package net.edwardsonthe.common;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Greeting {

   private long id;
   private String content;

   public Greeting() { }
   
   public Greeting(long id, String content) {
      this.id = id;
      this.content = content;
   }

   public String getContent() {
      return content;
   }

   public long getId() {
      return id;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public void setId(long id) {
      this.id = id;
   }

}