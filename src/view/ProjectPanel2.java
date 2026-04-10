package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProjectPanel2 extends JPanel{

    public ProjectPanel2(){
        this.setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("Projects");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setHorizontalAlignment(lblTitle.CENTER);

        this.add(lblTitle, BorderLayout.NORTH);
    }
}
