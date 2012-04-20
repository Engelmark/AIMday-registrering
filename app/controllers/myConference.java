package controllers;
 
import java.util.List;

import play.*;
import play.mvc.*;
import models.Conference;

@With(Secure.class)
@CRUD.For(Conference.class)

public class myConference extends CRUD {

}

