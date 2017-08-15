package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingView extends JFrame {
    private JButton logButton = new JButton("Login");
    private JLabel logLabel = new JLabel("login:");
    private JTextField logTextField = new JTextField();
    private JLabel passLabel = new JLabel("password:");
    private JTextField pasTextField = new JTextField();

    public SwingView(){
        super("Contacts");
        this.setBounds(100,100,500, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Container container = this.getContentPane();

        final JPanel logPanel = new JPanel();
        logPanel.setLayout(new GridLayout(3,2,10,10));

        logPanel.add(logLabel);
        logPanel.add(logTextField);
        logPanel.add(passLabel);
        logPanel.add(pasTextField);
        logPanel.add(logButton);

        container.add(logPanel);

        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.remove(logPanel);

                JPanel mainPanel = new JPanel();
                container.add(mainPanel);
                mainPanel.setLayout(new FlowLayout());
            }
        });

    }
}
