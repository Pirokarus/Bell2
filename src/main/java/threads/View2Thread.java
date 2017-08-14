package threads;

import model.services.ContactService;
import model.services.GroupService;
import view.View;
import view.View2;

public class View2Thread implements Runnable {
    @Override
    public void run() {
        View2 view2 = new View2();
        ContactService contactService = ContactService.getInstance();
        GroupService groupService = GroupService.getInstance();

        contactService.register(view2);

        groupService.register(view2);

    }
}
