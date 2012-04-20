package models;
 
import java.util.*;
import javax.persistence.*;
import java.io.File;
 
import play.db.jpa.*;
 
@Entity
public class Question extends Model {
	public String question;
    public String title;
    public Date postedAt;
    public boolean openToOthers;
    //public Document doc;
    
    //@ManyToOne
    @Column(name="author",length=1000)
    public BusinessAttendant author;
    @Lob
    public String background;
    
    @ManyToOne
    public Conference conference;
    
    

    
    public Question(String background, String title, String question, BusinessAttendant author, Conference conference, boolean openToOthers) {
        this.conference = conference;
    	this.author = author;
        this.title = title;
        this.background = background;
        this.question = question;
        this.postedAt = new Date();
        this.openToOthers = openToOthers;
    }
 
}