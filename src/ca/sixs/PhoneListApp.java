
/*
 * PhoneListApp
 *
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



public class PhoneListApp extends SingleFrameApplication {
    private PhoneListPanel panel;
    
    @Override protected void startup() {
        panel = new PhoneListPanel(getContext());
        panel.setName("phoneListPanel");
        show(panel);
        
    }


    public static void main(String[] args) {
        Application.launch(PhoneListApp.class, args);
    }


}
