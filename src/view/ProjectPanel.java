package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProjectPanel extends JPanel{
    private JList<String> projectList;
    private DefaultListModel<String> listModel;
    private JButton addButton;

    public ProjectPanel(TaskPanel taskPanel){
       setLayout(new BorderLayout());

       JLabel lblTitle = new JLabel("Projects");
       lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
       lblTitle.setHorizontalAlignment(JLabel.CENTER);

       // MODEL DATA
       listModel = new DefaultListModel<>();

       // LIST DATA
       projectList = new JList<>(listModel);
       JScrollPane scrollPane = new JScrollPane(projectList);

       //  BUTTON
       addButton = new JButton("Add Project");

       this.add(lblTitle, BorderLayout.NORTH);
       this.add(scrollPane, BorderLayout.CENTER);
       this.add(addButton, BorderLayout.SOUTH);

       // ADD EVENT LISTENER
       addButton.addActionListener(e -> addProject());

    projectList.addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            String selectedProject = projectList.getSelectedValue();

            if (selectedProject != null) {
                taskPanel.setTasks(selectedProject);
            }
        }
    });
    }

    private void addProject(){
        String namaProject = JOptionPane.showInputDialog(
            this,
            "Masukan Nama Project: ",
            "Tambah Project: ",
            JOptionPane.PLAIN_MESSAGE
        );

        // VALIDASI INPUT
        if (namaProject != null && !namaProject.trim().isEmpty() ) {
            listModel.addElement(namaProject);
        }else{
            JOptionPane.showMessageDialog(this, "Nama Project Tidak Boleh Kosong", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
