package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Question extends Model {
 
    public String title;
    public Date postedAt;
    
    @Lob
    public String background;
    
    @ManyToOne
    public BusinessAttendant author;
    @ManyToOne
    public Conference conference;
    
    public Question(BusinessAttendant author, String title, String background, Conference conference) {
        this.author = author;
        this.title = title;
        this.background = background;
        this.conference = conference;
        this.postedAt = new Date();
    }
 
}