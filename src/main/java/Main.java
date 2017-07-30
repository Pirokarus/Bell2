
import model.services.ContactService;
import model.services.GroupService;
import view.View;
import view.View2;

public class Main {

    public static void main(String[] args) {                //Основная main функция

        View view = new View();
        View2 view2 = new View2();
        ContactService contactService = ContactService.getInstance();
        GroupService groupService = GroupService.getInstance();

        contactService.register(view2);
        contactService.register(view);

        groupService.register(view2);
        groupService.register(view);

        view.update(contactService,true);
        
    }
}
