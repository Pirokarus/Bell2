import model.Model;
import view.View;
import view.View2;

public class Main {

    public static void main(String[] args) {                //Основная main функция

        View view = new View();
        View2 view2 = new View2();
        Model model = Model.getInstance();
        model.register(view2);
        model.register(view);
        view.start();
        
    }
}
