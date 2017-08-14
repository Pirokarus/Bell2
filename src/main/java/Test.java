import model.dao.jdbc.JdbcGroupDAO;
import model.dao.xml.jackson.JacksonGroupDAO;
import model.dao.xml.sax.SAXGroupDAO;
import model.data.Group;
import model.services.GroupService;
import threads.View2Thread;
import threads.ViewThread;

public class Test {
    public static void main(String[] args) throws Exception {

        View2Thread view2Thread = new View2Thread();
        View2Thread view2Thread1 = new View2Thread();
        ViewThread viewThread = new ViewThread();

        Thread thread1 = new Thread(view2Thread);
        Thread thread2 = new Thread(view2Thread1);
        Thread thread3 = new Thread(viewThread);

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
