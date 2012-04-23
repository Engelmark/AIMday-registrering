package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.db.jpa.Blob;
import play.db.jpa.Model;
 
import javax.persistence.Entity;
import java.io.File;
import java.util.*;



import models.*;

public class Application extends Controller {

	
    public static void index() {

  //  	Question frontQuestion = Question.find("order by postedAt desc").first();
  //      List<Question> olderQuestions = Question.find(
  //          "order by postedAt desc"
  //      ).from(0).fetch(10);
    	//List<Question> frontQuestion = Question.find(
    //	"order by postedAt desc"       
    //	).from(0).fetch(1000);
    //	render(frontQuestion);
        //render(frontQuestion, olderQuestions);
    	List<Conference> conferences = Conference.find("order by Datum").from(0).fetch(100);
    	System.out.println(conferences.size());	
    	render(conferences);
    	
    }
    
    public static void registration() {
    	//List<Conference> conferences = Conference.find("order by Datum").from(0).fetch(100);
    	//System.out.println(conferences.size());	
    	String urlEnding = params.get("urlEnding");
    	System.out.println(urlEnding);
    	List<Conference> conferences = Conference.find("byUrlEnding", urlEnding).fetch();
    	System.out.println(conferences.get(0).Namn);
//    	if (conferences.size == 1){
 		Conference conference = conferences.get(0); 
   		render(conference);
    	//}
    	
    	
    }
    
    public static void show(Long id) {
        Conference conference = Conference.findById(id);
        render(conference);
    //	List<Conference> conferences = Conference.find("order by conferenceDate").from(0).fetch(100);
		
    //	render(conferences);
    
    }
    public static void page(Long id) {					//Metoden som tar oss till sidan för frågor
       Conference conference = Conference.findById(id); // kanske vore bättre att skriva en generell
        render(conference);								// metod som routar till sidor oberoende av vilken sida det är?
    }													// Just nu har vi en metod för varje sida. Har även lagt in page i
    													// routes filen.
    public static void terminate(Long id) {
    	Conference conference = Conference.findById(id);  // Avsluta registreringsmetod
    		render(conference);
    		
    }		
    public static void postBusinessAttendant(Long conferenceId,   	
    	String fullname,
    	String email,
    	String phonenumber, 
    	String company,
    	boolean acceptEnglish){
    	
    	
        Conference conference = Conference.findById(conferenceId);
        conference.addBusinessAttendant(fullname, email, phonenumber, company, acceptEnglish);
        //System.out.println(conference.businessAttendants);
        System.out.println(conference.Namn);
        show(conferenceId);
        
    }
    public static void uploadFile(String title, File file) { // Skelettmetod för att ladda upp fil
    	   
    	}
    
    public static void postQuestion(Long conferenceId,String background, String title, String question,
    		BusinessAttendant author, boolean openToOthers){
	   Conference conference = Conference.findById(conferenceId);
	   conference.addQuestion(background,title,question,author,openToOthers);
	   System.out.println(conference.questions);
	  
	   page(conferenceId);
	   
   }
   public static void finishRegistration(Long conferenceId, String background, String title, String question, BusinessAttendant author, boolean openToOthers){
   		Conference conference = Conference.findById(conferenceId);
   		conference.addQuestion(background,title,question,author,openToOthers);
   		terminate(conferenceId);
   }
   public static void questionuploadFile(Question question) {
	   question.save();
	   System.out.println(question.file);
	   
	  
	}

}