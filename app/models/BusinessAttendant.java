package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.db.jpa.Blob;
import play.db.jpa.Model;
 
import javax.persistence.Entity;

@Entity

public class BusinessAttendant extends Model {
 
    public String email;
    public String fullname;
    public String phonenumber;
    public String company;
    public boolean acceptEnglish;
    
    
    @ManyToOne
    public Conference conference;
    
    public BusinessAttendant(String fullname, String email, String phonenumber, String company, Conference conference, boolean acceptEnglish) {
        this.conference = conference;
    	this.email = email;
        this.fullname = fullname;
        this.phonenumber = phonenumber;
        this.company = company;
        this.acceptEnglish = acceptEnglish;
    }
    
}