package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import java.util.HashMap;
import java.util.ArrayList;

public class TaskPanel extends JPanel{
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private String curruentProject;
    private HashMap<String, ArrayList<String>> projectTasks;

    public TaskPanel(){
        setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("Tasks");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(taskList);

        JButton btnAddTask = new JButton("Add Task");

        // Inisialisasi HashMap
        projectTasks = new HashMap<>();

        // ADD EVENT LISTENER
        btnAddTask.addActionListener(e -> addTasks());

        this.add(lblTitle, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(btnAddTask, BorderLayout.SOUTH);
    }

    public void setTasks(String projectName){
        this.curruentProject = projectName;
        listModel.clear();

        // Ambil Task dari Map
        ArrayList<String> tasks = projectTasks.get(projectName);

        if (tasks != null) {
            for (String task : tasks) {
                listModel.addElement(task);
            }
        }
    }

    public void addTasks(){
        if (curruentProject == null) {
            JOptionPane.showMessageDialog(this,"Pilih Project Dulu!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String taskName = JOptionPane.showInputDialog(this, "Masukan Nama Task: ", "Tambah Task", JOptionPane.PLAIN_MESSAGE);

        if (taskName != null && !taskName.trim().isEmpty()) {

            // Ambil List Task Project
            ArrayList<String> tasks = projectTasks.get(curruentProject);

            // validasi jika tidak ada 
            if (tasks == null) {
                tasks = new ArrayList<>();
                projectTasks.put(curruentProject, tasks);
            }

            // Tambah Task
            tasks.add(taskName);

            //  Update UI
            listModel.addElement(taskName);
        }
    }


}
