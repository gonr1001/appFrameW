/*
 * BasicApp.java
 *
 * Copyright 2007 Sun Microsystems, Inc. ALL RIGHTS RESERVED Use of 
 * this software is authorized pursuant to the terms of the license 
 * found at http://developers.sun.com/berkeley_license.html.
 *
 */

package ca.sixs;
/**
*
* @author John O'Conner (John.OConner@sun.com)
* modified by @author Rgr
*/
import org.jdesktop.application.Application;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


public class BasicFrameworkApp extends Application {
    JFrame _mainFrame;
    private JLabel label;
    
    protected void startup() {
        _mainFrame = new JFrame("BasicFrameworkApp");
        _mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        _mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                _mainFrame.setVisible(false);
                // perform any other operations you might need
                // before exit
                exit();
            }
        });
        label = new JLabel("Hello, world!");
        label.setFont(new Font("SansSerif", Font.PLAIN, 22));
        _mainFrame.add(label);
        _mainFrame.pack();
        _mainFrame.setVisible(true);
    }
    
    /*
     * Launch your application by passing its Class
     * to the Application.launch method.
     */
    public static void main(String[] args) {
        Application.launch(BasicFrameworkApp.class, args);
    }
}
