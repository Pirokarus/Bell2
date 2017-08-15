import model.dao.jdbc.JdbcGroupDAO;
import model.dao.xml.jackson.JacksonGroupDAO;
import model.dao.xml.sax.SAXGroupDAO;
import model.data.Group;
import model.services.GroupService;
import threads.View2Thread;
import threads.ViewThread;
import view.SwingView;

public class Test {
    public static void main(String[] args) throws Exception {

        SwingView swingView = new SwingView();
        swingView.setVisible(true);
    }

}
