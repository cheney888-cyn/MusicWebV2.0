package com.cheney.pojo;

public class Singer {
   private Integer id;
   private String singerName;
   private String type;
   private String imgURL;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getSingerName() {
      return singerName;
   }

   public void setSingerName(String singerName) {
      this.singerName = singerName;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getImgURL() {
      return imgURL;
   }

   public void setImgURL(String imgURL) {
      this.imgURL = imgURL;
   }

   @Override
   public String toString() {
      return "Singer{" +
              "id=" + id +
              ", singerName='" + singerName + '\'' +
              ", type='" + type + '\'' +
              ", imgURL='" + imgURL + '\'' +
              '}';
   }
}
