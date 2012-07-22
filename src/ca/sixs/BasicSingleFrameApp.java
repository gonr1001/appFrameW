/*
 * BasicSingleFrameApp.java
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
import org.jdesktop.application.SingleFrameApplication;
import java.awt.Font;
import javax.swing.JLabel;


public class BasicSingleFrameApp extends SingleFrameApplication {
    JLabel label;
    
    @Override
    protected void startup() {
        getMainFrame().setTitle("BasicSingleFrameApp");
        label = new JLabel("Hello, world!");
        label.setFont(new Font("SansSerif", Font.PLAIN, 22));
        show(label);
    }
    
    @Override
    protected void shutdown() {
        super.shutdown();
        // remaining tasks for this specific application
        // ...
    }
    
    public static void main(String[] args) {
       Application.launch(BasicSingleFrameApp.class, args);
    }

}
