package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class BusinessAttendant extends Model {
 
    public String email;
    public String fullname;
    public String phonenumber;
    public String company;
    
    public BusinessAttendant(String email, String phonenumber, String fullname, String company) {
        
    	this.email = email;
        this.fullname = fullname;
        this.phonenumber = phonenumber;
        this.company = company;
    }
// SLUTA TRAMSA STINA MM
}