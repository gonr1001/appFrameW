/*
 * ActionApp.java
 *
 * Copyright 2007 Sun Microsystems, Inc. ALL RIGHTS RESERVED Use of 
 * this software is authorized pursuant to the terms of the license 
 * found at http://developers.sun.com/berkeley_license.html.
 */

package ca.sixs;
/**
*
* @author John O'Conner (John.OConner@sun.com)
* modified by @author Rgr
*/


import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;

import org.jdesktop.application.Application;
import org.jdesktop.application.ApplicationActionMap;
import org.jdesktop.application.ApplicationContext;
import org.jdesktop.application.SingleFrameApplication;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class ActionApp implements Runnable { //extends Runnable { //SingleFrameApplication {
    ResizeFontPanel panel;
    JMenuBar menuBar;
    JMenu menuFont;
    JMenuItem miIncreaseSize;
    JMenuItem miDecreaseSize;
    
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
    
//    @Override
//    protected void startup() {
//        ApplicationContext ctxt = getContext();
//        panel = new ResizeFontPanel(ctxt);
//        Application app = Application.getInstance(ActionApp.class);
//         ApplicationActionMap map = ctxt.getActionMap(panel);
//        
//        menuBar = new JMenuBar();
//        menuFont = new JMenu();
//        menuFont.setName("menuFont");
//
//        miIncreaseSize = new JMenuItem(map.get("makeLarger"));
//        miDecreaseSize = new JMenuItem(map.get("makeSmaller"));
//
//        menuFont.add(miIncreaseSize);
//        menuFont.add(miDecreaseSize);
//        menuBar.add(menuFont);
//
//        getMainFrame().setJMenuBar(menuBar);
//        
//        show(panel);
//    }
    
    
    /*
     * Applications should never interact with the GUI
     * components from outside the event dispatch thread.
     */
    public static void main(String[] args) {
        //Application.launch(ActionApp.class, args);
    	Runnable app = new ActionApp();
        try {
            SwingUtilities.invokeAndWait(app);
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
        	 ex.printStackTrace();
        }
    }
}




