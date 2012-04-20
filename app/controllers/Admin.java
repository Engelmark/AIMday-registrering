package controllers;
 
import play.*;
import play.db.jpa.GenericModel.JPAQuery;
import play.mvc.*;
 
import java.util.*;
 
import models.*;
 
@With(Secure.class)
public class Admin extends Controller {
    
	
	
    @Before
    static void setConnectedUser() {
        if(Security.isConnected()) {
            Conference conference = Conference.find("byUsername", Security.connected()).first();
            renderArgs.put("conference", conference);
            System.out.println(conference.id);
            
            
        }
    }
    
    public static void index() {
    	render();
    }
    
    public static void showConference(){
    	Conference conference = Conference.find("byUsername", Security.connected()).first();
    	render(conference);
    }
    
    //public static void myConference(){
    //	List<Conference> conference = Conference.find("username", Security.connected()).fetch();
    //    render(conference);
    //}
      
          
}