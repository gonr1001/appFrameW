/*
 * ShowTimeApp.java
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;


public class ShowTimeApp extends SingleFrameApplication {
    JPanel timePanel;
    JButton btnShowTime;
    JTextField txtShowTime;
    
    @Override
    protected void startup() {
        timePanel = new JPanel();
        btnShowTime = new JButton();
        txtShowTime = new JTextField();
        
        // Set UI component names so that the 
        // framework can inject resources automatically into
        // these components. Resources come from similarly
        // named keys in resources/ShowTimeApp.properties
        btnShowTime.setName("btnShowTime");
        txtShowTime.setName("txtShowTime");
        
        btnShowTime.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                txtShowTime.setText(now.toString());
            }
            
        });
        
        timePanel.add(btnShowTime);
        timePanel.add(txtShowTime);
        
        show(timePanel);
    } 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(ShowTimeApp.class, args);
    }
    
    
}
