package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TaskPanel2 extends JPanel{

    public TaskPanel2(){
        this.setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("Task Project");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setHorizontalAlignment(lblTitle.CENTER);

        this.add(lblTitle, BorderLayout.NORTH);
    }
}
