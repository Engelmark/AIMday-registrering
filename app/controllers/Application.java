package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {

  //  	Question frontQuestion = Question.find("order by postedAt desc").first();
  //      List<Question> olderQuestions = Question.find(
  //          "order by postedAt desc"
  //      ).from(0).fetch(10);
    	List<Question> frontQuestion = Question.find(
    	"order by postedAt desc"      
    	).from(0).fetch(1000);
    	render(frontQuestion);
        //render(frontQuestion, olderQuestions);
    }

    public static void show(Long id) {
        Question question = Question.findById(id);
        render(question);
    }
    public static void postQuestion(Long conferenceId, BusinessAttendant author, String background, String title) {
        Conference conference = Conference.findById(conferenceId);
        conference.addQuestion(author, background, title);
        show(conferenceId);
    }
}