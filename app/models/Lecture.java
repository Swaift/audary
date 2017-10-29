package models;

import org.bson.types.ObjectId;

public final class Lecture {
  private ObjectId id;
  private String date;
  private String text;

  public Lecture() {
  }

  public ObjectId getId() {
    return id;
  }

  public void setId(final ObjectId id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }
  
  public void setDate(final String date) {
    this.date = date;
  }

  public String getText() {
    return text;
  }
  
  public void setText(final String text) {
    this.text = text;
  }
}
