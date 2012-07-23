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

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;


public class GreetingApp extends SingleFrameApplication {
    NameEntryPanel namePanel;
    
    @Override
    protected void startup() {
        namePanel = new NameEntryPanel(getContext());
        show(namePanel);
    } 
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(GreetingApp.class, args);
    }
    
    
}
