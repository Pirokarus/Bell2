package view;

import model.Model;

import java.util.Observable;
import java.util.Observer;

public class View2 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(Model.getInstance().getContactSet());
        System.out.println(Model.getInstance().getGroupSet());
    }
}
