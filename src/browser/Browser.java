package browser;

import javax.swing.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.awt.event.*;
import java.awt.*;

public class Browser extends JFrame implements Runnable , ActionListener{

    private WebEngine webEngine;
    private JFXPanel panel;
    JButton b1,b2;
    
    public void run() {
        setTitle("Web Brower");
        setVisible(true);
        setBounds(0,0,1950, 1080);
        
        panel = new JFXPanel();
        add(panel);
       
        Platform.runLater(() -> {
            WebView view = new WebView();
            view.getEngine().load("http://www.google.com");

            panel.setScene(new Scene(view));
        });
        
         b1=new JButton("Exit");
        b1.addActionListener(this);
        b1.setBounds(1150,14,90,34);
        b1.setForeground(Color.white);
        b1.setBackground(Color.blue);
        b1.setFont(new Font("Tohoma",Font.BOLD,15));
        panel.add(b1);
        
        b2=new JButton("New Tab");
        b2.addActionListener(this);
        b2.setBounds(1000,14,120,34);
        b2.setForeground(Color.white);
        b2.setBackground(Color.blue);
        b2.setFont(new Font("Tohoma",Font.BOLD,15));
        panel.add(b2);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            this.setVisible(false);
        }else if(ae.getSource() == b2){
              SwingUtilities.invokeLater(new Browser());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Browser());
    }

}
