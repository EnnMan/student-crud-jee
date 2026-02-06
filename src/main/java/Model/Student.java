package Model;

import java.io.Serializable;

public class Student implements Serializable {

  private int id;
  private String fullName;
  private String cne;
  private String Adresse;

  public Student() {
  }

  public Student(int id, String fullName, String cne, String adresse) {
    this.id = id;
    this.fullName = fullName;
    this.cne = cne;
    this.Adresse = adresse;
  }

  public Student(String fullName, String cne, String adresse) {
    this.fullName = fullName;
    this.cne = cne;
    this.Adresse = adresse;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getCne() {
    return cne;
  }

  public void setCne(String cne) {
    this.cne = cne;
  }

  public String getAdresse() {
    return Adresse;
  }

  public void setAdresse(String adresse) {
    Adresse = adresse;
  }

}
