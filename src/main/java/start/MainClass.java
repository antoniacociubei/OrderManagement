package start;
import java.sql.SQLException;
import java.util.logging.Logger;
import presentation.Controller;
import presentation.View;

/**
 * starting point for the app
 */

public class MainClass {

    protected static final Logger LOGGER = Logger.getLogger(MainClass.class.getName());

    public static void main(String[] args) throws SQLException {

        View v = new View();
        Controller c = new Controller(v);

    }


}
