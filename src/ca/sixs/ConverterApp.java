/*
 * ConverterApp.java
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
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;

import org.jdesktop.application.Application;
import org.jdesktop.application.ApplicationContext;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;


public class ConverterApp extends SingleFrameApplication {
    
    protected void startup() {
        ApplicationContext ctx = getContext();
        ResourceMap resource = ctx.getResourceMap();
        
        String msg;
        Color color;
        Font font;
        Icon icon;        
        JLabel label;
        
        // Use resource converters to convert text representations
        // of resources into Color and Font objects
        msg = resource.getString("msg");
        color = resource.getColor("color");
        font = resource.getFont("font");
        icon = resource.getIcon("icon");
        
        label = new JLabel(msg);
        label.setOpaque(false);
        label.setForeground(color);
        label.setFont(font);
        label.setIcon(icon);
        
        show(label);
    }
    
    public static void main(String[] args) {
        Application.launch(ConverterApp.class, args);
    }
    
}
