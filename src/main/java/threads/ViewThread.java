package threads;

import model.services.ContactService;
import model.services.GroupService;
import view.View;

public class ViewThread implements Runnable {
    @Override
    public void run() {

        View view = new View();
        ContactService contactService = ContactService.getInstance();
        GroupService groupService = GroupService.getInstance();

        contactService.register(view);

        groupService.register(view);

        view.update(contactService,true);
    }
}
