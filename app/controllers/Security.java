package controllers;
 
import models.*;
 
public class Security extends Secure.Security {
	
    static boolean authenticate(String username, String password) {
    	return Conference.connect(username, password) != null;
    }
    
    static boolean check(String profile) {
        if("admin".equals(profile)) {        	
            return Conference.find("byUsername", connected()).<Conference>first().isAdmin;
            
        }
        return false;        
    }
    
    static void onDisconnected() {
        Admin.index();
    }
    
    static void onAuthenticated() {
        Admin.index();
    }
    
}