/*
 * BasicApp.java
 *
 * Copyright 2007 Sun Microsystems, Inc. ALL RIGHTS RESERVED Use of 
 * this software is authorized pursuant to the terms of the license 
 * found at http://developers.sun.com/berkeley_license.html.
 *
 */

package ca.sixs;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author John O'Conner (John.OConner@sun.com)
 * modified by @author Rgr
 */
public class BasicApp implements Runnable {
    
    JFrame mainFrame;
    JLabel label;
    
    public void run() {
        mainFrame = new JFrame("BasicApp");
        label = new JLabel("Hello, world!");
        label.setFont(new Font("SansSerif", Font.PLAIN, 22));
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(false);
                // perform any other operations you might need
                // before exit
                System.exit(0);
            }
        });
        mainFrame.add(label);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    /*
     * Applications should never interact with the GUI
     * components from outside the event dispatch thread.
     */
    public static void main(String[] args) {
        Runnable app = new BasicApp();
        try {
            SwingUtilities.invokeAndWait(app);
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
