import io.cucumber.java.After;

public class hooks {
    @After
    public void tearDown() {
        // Code to delete or clean up resources goes here
        // 	We can delete files, close connections, etc.
        System.out.println("Executing @After hook to clean up resources");
    }
}
