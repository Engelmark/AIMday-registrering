import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Before
    public void setup() {
        Fixtures.deleteAll();
    }
/*	@Test
	public void createAndRetrieveUser() {
		// Create a new user and save it
		new BusinessAttendant("bob@gmail.com", "0739-12 34 56", "Bob", "Företaget").save();
    
		// Retrieve the user with e-mail address bob@gmail.com
		BusinessAttendant bob = BusinessAttendant.find("byEmail", "bob@gmail.com").first();
    
		// Test 
		assertNotNull(bob);
		assertEquals("Bob", bob.fullname);
	} */
/*	@Test
	public void createQuestion() {
	    // Create a new user and save it
		BusinessAttendant bob = new BusinessAttendant("bob@gmail.com", "0739-12 34 56", "Bob", "Företaget").save();
	    
	    // Create a new post
	    new Question(bob, "My first Question", "Is it me you're looking for?").save();
	    
	    // Test that the post has been created
	    assertEquals(1, Question.count());
	    
	    // Retrieve all posts created by Bob
	    List<Question> bobQuestions = Question.find("byAuthor", bob).fetch();
	    
	    // Tests
	    assertEquals(1, bobQuestions.size());
	    Question firstQuestion = bobQuestions.get(0);
	    assertNotNull(firstQuestion);
	    assertEquals(bob, firstQuestion.author);
	    assertEquals("My first Question", firstQuestion.title);
	    assertEquals("Is it me you're looking for?", firstQuestion.background);
	    assertNotNull(firstQuestion.postedAt);
	} */
	@Test
	public void fullTest() {
	    Fixtures.loadModels("data.yml");

	    // Count things
	    assertEquals(2, BusinessAttendant.count());
	    assertEquals(3, Question.count());
	    assertEquals(1, Conference.count());
	    
	 

	 
	    // Find all of Bob's posts
	    List<Question> bobPosts = Question.find("author.email", "bob@gmail.com").fetch();
	    assertEquals(2, bobPosts.size());

	 
	    // Find the most recent post
	    Question frontPost = Question.find("order by postedAt desc").first();
	    assertNotNull(frontPost);
	    assertEquals("About the model layer", frontPost.title);
	 

	}
}