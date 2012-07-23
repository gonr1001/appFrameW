/*
 * HelloWorld.java
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

import java.awt.Color;

import javax.swing.JLabel;

import org.jdesktop.application.Application;
import org.jdesktop.application.ApplicationContext;
import org.jdesktop.application.ResourceManager;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;


public class HelloWorld extends SingleFrameApplication {
    JLabel label;
    ResourceMap resource;
    
    @Override
    protected void initialize(String[] args) {
        ApplicationContext ctxt = getContext();  
        ResourceManager mgr = ctxt.getResourceManager();
        resource = mgr.getResourceMap(HelloWorld.class);
    }
    
    @Override
    protected void startup() {
        label = new JLabel();
        String helloText = (String) resource.getObject("helloLabel", String.class);
        // You can optionally use the convenience methods that cast resources
        // to the type indicated by the method names:
        // resource.getString("helloLabel.text");
        // resource.getColor("backgroundcolor");
        // etc.
        Color backgroundColor = resource.getColor("color");
        String title = resource.getString("title");
        label.setBackground(backgroundColor);
        label.setOpaque(true);
        getMainFrame().setTitle(title);
        label.setText(helloText);
        show(label);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(HelloWorld.class, args);
    }
}
