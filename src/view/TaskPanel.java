package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

public class TaskPanel extends JPanel{
    private JList<String> taskList;
    private DefaultListModel<String> listModel;

    public TaskPanel(){
        setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("Tasks");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(taskList);

        JButton btnAddTask = new JButton("Add Task");

        this.add(lblTitle, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(btnAddTask, BorderLayout.SOUTH);
    }
}
