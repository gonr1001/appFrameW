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




import org.jdesktop.application.Application;
import org.jdesktop.application.ApplicationActionMap;
import org.jdesktop.application.ApplicationContext;
import org.jdesktop.application.SingleFrameApplication;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class ActionApp extends SingleFrameApplication {
    ResizeFontPanel panel;
    JMenuBar menuBar;
    JMenu menuFont;
    JMenuItem miIncreaseSize;
    JMenuItem miDecreaseSize;
    
    @Override
    protected void startup() {
        ApplicationContext ctxt = getContext();
        panel = new ResizeFontPanel(ctxt);
        @SuppressWarnings("unused")
		Application app = Application.getInstance(ActionApp.class);
        ApplicationActionMap map = ctxt.getActionMap(panel);
        
        menuBar = new JMenuBar();
        menuFont = new JMenu();
        menuFont.setName("menuFont");

        miIncreaseSize = new JMenuItem(map.get("makeLarger"));
        miDecreaseSize = new JMenuItem(map.get("makeSmaller"));

        menuFont.add(miIncreaseSize);
        menuFont.add(miDecreaseSize);
        menuBar.add(menuFont);

        getMainFrame().setJMenuBar(menuBar);
        
        show(panel);
    }
    
    public static void main(String[] args) {
        Application.launch(ActionApp.class, args);
    }
}




