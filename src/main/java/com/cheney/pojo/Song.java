package com.cheney.pojo;

public class Song {
    private Integer id;
    private String songName;
    private String singer;
    private String fileURL;
    private Integer hits;
    private String type;
    private Integer status;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getSongName() {
      return songName;
   }

   public void setSongName(String songName) {
      this.songName = songName;
   }

   public String getSinger() {
      return singer;
   }

   public void setSinger(String singer) {
      this.singer = singer;
   }

   public String getFileURL() {
      return fileURL;
   }

   public void setFileURL(String fileURL) {
      this.fileURL = fileURL;
   }

   public Integer getHits() {
      return hits;
   }

   public void setHits(Integer hits) {
      this.hits = hits;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public Integer getStatus() {
      return status;
   }

   public void setStatus(Integer status) {
      this.status = status;
   }

   @Override
   public String toString() {
      return "Song{" +
              "id=" + id +
              ", songName='" + songName + '\'' +
              ", singer='" + singer + '\'' +
              ", fileURL='" + fileURL + '\'' +
              ", hits=" + hits +
              ", type='" + type + '\'' +
              ", status=" + status +
              '}';
   }
}
