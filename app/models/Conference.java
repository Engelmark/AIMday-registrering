 package models;
 
import java.util.*;

import javax.persistence.*;

import play.data.validation.*;  
import play.db.jpa.*;
 
@Entity
public class Conference extends Model {
	@Required
    public String Namn;
	@Required
	public String urlEnding;
	@Required
    public String Datum;
	@Required
    public String Plats;

	public String username;
	public String password;
	public boolean isAdmin;
	
	public String MaxAntalFragor;
	public String DeadlineForetag;
	public String RegistreringsoppningForskare;
	public String DeadlineForskare;
	
	@OneToMany(mappedBy="conference", cascade=CascadeType.ALL)
	public List<BusinessAttendant> businessAttendants;
	@OneToMany(mappedBy="conference", cascade=CascadeType.ALL) // Question är av samma typ som businessattendat
	public List<Question> questions;							// Frågan är om vi ska ha BusinessAttendant och Question	
	 															// som en Arraylist överhuvudtaget?
	
    
    public Conference(String password, String username, String Namn, String Datum, String Plats,String MaxAntalFragor, 
    		String DeadlineForetag, String RegistreringsoppningForskare, String DeadlineForskare, String urlEnding) {
        this.password = password;
    	this.username = username;
    	this.Namn = Namn;
        this.Datum = Datum;
        this.Plats = Plats;
        this.MaxAntalFragor = MaxAntalFragor;
    	this.DeadlineForetag = DeadlineForetag;
    	this.RegistreringsoppningForskare = RegistreringsoppningForskare;
    	this.DeadlineForskare = DeadlineForskare;
    	this.businessAttendants = new ArrayList<BusinessAttendant>();
    	this.questions = new ArrayList<Question>();
    	this.urlEnding = urlEnding;
        
		
        
        
    }
    public Conference addBusinessAttendant(String fullname, String email, String phonenumber, String company,boolean acceptEnglish) {
        BusinessAttendant newBusinessAttendant = new BusinessAttendant(fullname, email, phonenumber, company, this, acceptEnglish).save();
        this.businessAttendants.add(newBusinessAttendant);
        this.save();
        return this;
    }
   public Conference addQuestion(String background, String title, String question, BusinessAttendant author, boolean openToOthers) { 
	   Question newQuestion = new Question(background,title,question,author,this,openToOthers).save();					
	   this.questions.add(newQuestion);															
	   this.save();																				
	   return this;
   }
    public String toString() {
        return Namn;
    }
    
    public static Conference connect(String username, String password) {
        return find("byUsernameAndPassword", username, password).first();
    }
 
}