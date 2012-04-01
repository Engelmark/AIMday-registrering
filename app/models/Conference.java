package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Conference extends Model {
 
    public String name;
    public Date conferenceDate;
	public String location;

	@OneToMany(mappedBy="conference", cascade=CascadeType.ALL)
	public List<Question> questions;
	 

    
    public Conference(String name, Date conferenceDate, String location) {
        this.questions = new ArrayList<Question>();
    	this.name = name;
        this.conferenceDate = conferenceDate;
        this.location = location;

    }
    public Conference addQuestion(BusinessAttendant author, String background, String title) {
        Question newQuestion = new Question(author, title, background, this).save();
        this.questions.add(newQuestion);
        this.save();
        return this;
    }
}