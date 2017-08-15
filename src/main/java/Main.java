
import model.services.ContactService;
import model.services.GroupService;
import threads.View2Thread;
import threads.ViewThread;
import view.View;
import view.View2;

public class Main {

    public static void main(String[] args) {                //Основная main функция

        ViewThread viewThread2 = new ViewThread();
        ViewThread viewThread1 = new ViewThread();
        ViewThread viewThread = new ViewThread();

        Thread thread1 = new Thread(viewThread);
        Thread thread2 = new Thread(viewThread1);
        Thread thread3 = new Thread(viewThread);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
