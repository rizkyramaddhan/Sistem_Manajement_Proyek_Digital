package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

public class MainFrame2 extends JFrame{
    
    public MainFrame2(){
        // Setting JFrame
        super("Sistem Manajement Proyek 2");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        // Menambahkan Icon
        try {
            BufferedImage icon = ImageIO.read(new File("assets/icon/LogicGate.png"));

            this.setIconImage(icon);
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("ERROR : " + e.getMessage());
        }

        // Menambahkan Komponen
        JLabel lblTitle = new JLabel("SISTEM MANAJEMENT PROYEK 2");
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(lblTitle, BorderLayout.NORTH);

        // inisialisasi Task Project Panel
        TaskPanel2 taskProjectPanel = new TaskPanel2();
        this.add(taskProjectPanel);

        // Inisialisasi Project Panel
        ProjectPanel2 projectPanel2 = new ProjectPanel2();
        this.add(projectPanel2);

        // Splite Panel
        JSplitPane splitePane = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT,
            projectPanel2,
            taskProjectPanel
        );
        splitePane.setDividerLocation(200);
        splitePane.setDividerSize(10);
        splitePane.setOneTouchExpandable(true);
        this.add(splitePane);




        this.setVisible(true);
    }
}
