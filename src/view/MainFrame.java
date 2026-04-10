package view;

import view.ProjectPanel;
import view.TaskPanel;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import model.Project;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class MainFrame extends JFrame{
    public MainFrame(){
        super("Sistem Manajement Proyek");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // try {
        //     BufferedImage icon = ImageIO.read(new File("assets/icon/LogicGate.png"));

        //     this.setIconImage(icon);
        // } catch (IOException e) {
        //     // TODO: handle exception
        //     System.out.println("ERROR : " + e.getMessage());
        // }

        try {
            BufferedImage icon = ImageIO.read(new File("assets/icon/LogicGate.png"));

            this.setIconImage(icon);
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("ERROR : " + e.getMessage());
        }

        setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("SISTEM MANAJEMENT PROYEK", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));

        
        // Panel Tasks di sebelah kanan
        TaskPanel taskPanel = new TaskPanel();
        
        // Panel Proyek di sebelah kiri 
        ProjectPanel projectPanel = new ProjectPanel(taskPanel);
        
        // Split Pane (Proyek dan Tasks)
        JSplitPane splitPane = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT,
            projectPanel,
            taskPanel
        );

        splitPane.setDividerLocation(250);

        this.add(splitPane, BorderLayout.CENTER);


        this.add(lblTitle, BorderLayout.NORTH);

        this.setVisible(true);
    }
}
