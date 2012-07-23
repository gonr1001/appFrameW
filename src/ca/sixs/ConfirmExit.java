/*
 * ConfirmExit.java
 *
 * Copyright 2007 Sun Microsystems, Inc. ALL RIGHTS RESERVED Use of 
 * this software is authorized pursuant to the terms of the license 
 * found at http://developers.sun.com/berkeley_license.html.
 * 
 *
 */
package ca.sixs;
/**
*
* @author John O'Conner (John.OConner@sun.com)
* modified by @author Rgr
*/
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;


public class ConfirmExit extends SingleFrameApplication {
    private JButton exitButton;
    
    @Override
    protected void startup() {
        getMainFrame().setTitle("ConfirmExit");
        exitButton = new JButton("Exit Application");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exit(e);
            }
            
        });
        // ExitListeners receive notification when the 
        // framework attempts to terminate the application
        addExitListener(new ExitListener() {
            public boolean canExit(EventObject e) {
                boolean bOkToExit = false;
                Component source = (Component) e.getSource();
                bOkToExit = JOptionPane.showConfirmDialog(source, "Do you really want to exit?") ==
                        JOptionPane.YES_OPTION;
                return bOkToExit;
            }
            public void willExit(EventObject event) {
               // to be commented 
            }
        });
        show(exitButton);
    }
    
    @Override
    protected void shutdown() {
        // the default shutdown saves session window state
        super.shutdown();
        // now perform any other shutdown tasks you need
        // ...
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(ConfirmExit.class, args);
    }
    
}
