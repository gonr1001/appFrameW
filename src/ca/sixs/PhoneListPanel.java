/*
 * PhoneListPanel.java
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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ActionMap;

import org.jdesktop.application.Action;
import org.jdesktop.application.ApplicationContext;
import org.jdesktop.application.ResourceMap;


@SuppressWarnings("serial")
public class PhoneListPanel extends javax.swing.JPanel {
    MapListModel _listModel;
    String _file = "phonelist.xml";
    ApplicationContext _ctxt;
    
    /** Creates new form PhoneListPanel */
    public PhoneListPanel(ApplicationContext ctxt) {
        this._ctxt = ctxt;
        _listModel = new MapListModel();
        initComponents();
        ActionMap map = ctxt.getActionMap(this);

        btnAddEntry.setAction(map.get("addPhoneEntry"));
        btnLoad.setAction(map.get("loadMap"));
        btnClear.setAction(map.get("clearMap"));
        btnSave.setAction(map.get("saveMap"));
        txtPhone.setAction(map.get("addPhoneEntry"));
        txtName.setAction(map.get("addPhoneEntry"));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        btnAddEntry = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtStatus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPhoneEntry = new javax.swing.JList();

        lblName.setText("jLabel1");
        lblName.setName("lblName");

        lblPhone.setText("jLabel2");
        lblPhone.setName("lblPhone");

        btnAddEntry.setText("jButton1");
        btnAddEntry.setName("btnAddEntry");

        btnSave.setText("jButton2");

        btnLoad.setText("jButton3");

        btnClear.setText("jButton4");

        lstPhoneEntry.setModel(_listModel);
        lstPhoneEntry.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstPhoneEntry);

//        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
//        this.setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
//            .add(layout.createSequentialGroup()
//                .addContainerGap()
//                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
//                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
//                    .add(layout.createSequentialGroup()
//                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
//                            .add(lblName)
//                            .add(txtName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
//                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
//                            .add(lblPhone)
//                            .add(txtPhone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 138, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
//                        .add(btnAddEntry))
//                    .add(layout.createSequentialGroup()
//                        .add(btnSave)
//                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
//                        .add(btnLoad)
//                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
//                        .add(btnClear))
//                    .add(txtStatus, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
//                .addContainerGap())
//        );
//
//        layout.linkSize(new java.awt.Component[] {txtName, txtPhone}, org.jdesktop.layout.GroupLayout.HORIZONTAL);
//
//        layout.setVerticalGroup(
//            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
//            .add(layout.createSequentialGroup()
//                .addContainerGap()
//                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
//                    .add(lblName)
//                    .add(lblPhone))
//                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
//                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
//                    .add(txtName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
//                    .add(txtPhone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
//                    .add(btnAddEntry))
//                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
//                .add(jScrollPane1)
//                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
//                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
//                    .add(btnSave)
//                    .add(btnLoad)
//                    .add(btnClear))
//                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
//                .add(txtStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap())
//        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    @Action
    public void addPhoneEntry() {
        String key = txtName.getText().trim();
        String value = txtPhone.getText().trim();        
        _listModel.put(key, value);
    }
    
    
    @Action
    public void clearMap() {
        _listModel.clear();
        txtName.setText("");
        txtPhone.setText("");
    }
    
    @SuppressWarnings("unchecked")
	@Action
    public void loadMap() throws IOException {
        Object map = _ctxt.getLocalStorage().load(_file);
        _listModel.setMap((LinkedHashMap<String, String>)map);
        showFileMessage("loadedFile", _file);
    }
    
    @Action
    public void saveMap() throws IOException {
        LinkedHashMap<String, String> map = _listModel.getMap();
        _ctxt.getLocalStorage().save(map, _file);
        showFileMessage("savedFile", _file);
    }
    
    private void showFileMessage(String messageKey, String file) {
        File dir = _ctxt.getLocalStorage().getDirectory();
        File path = (dir == null) ? new File(file) : new File(dir, file);
        ResourceMap resourceMap = _ctxt.getResourceMap(getClass());
        String message = resourceMap.getString(messageKey, path.toString());
        txtStatus.setText(message);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEntry;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JList lstPhoneEntry;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
        
    /* A ListModel that encapsulates a LinkedHashMap<String, String>
     * The value of each ListModel element is just a string: 
     * "key = value".
     *
     * This MapListModel code was borrowed from the 
     * examples in Swing Application Framework project.
     */
    private static class MapListModel extends AbstractListModel {
	private final LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
	private List<String> keys = null;
	/**
	 * 
	 */
	public MapListModel() {
		// TODO Auto-generated constructor stub
	}
	private List<String> getKeys() {
	    if (keys == null) {
		keys = new ArrayList<String>(map.keySet());
	    }
	    return keys;
	}
	public void put(String key, String value) {
	    int index = -1;
	    if (map.containsKey(key)) {
		index = getKeys().indexOf(key);
	    }
	    else {
		index = map.size();
		keys = null;
	    }
	    map.put(key, value);
	    fireContentsChanged(this, index, index);
	}
	public void clear() {
	    if (map.size() > 0) {
		int lastIndex = map.size() - 1;
		map.clear();
		keys = null;
		fireIntervalRemoved(this, 0, lastIndex);
	    }
	}
	public LinkedHashMap<String, String> getMap() { 
	    return new LinkedHashMap<String, String>(map);
	}
	public void setMap(LinkedHashMap<String, String> newMap) {
	    int oldLastIndex = Math.max(map.size() - 1, 0);
	    map.clear();
	    map.putAll(newMap);
	    int newLastIndex = Math.max(map.size() - 1, 0);
	    fireContentsChanged(this, 0, Math.max(oldLastIndex, newLastIndex));
	}
	public int getSize() {
	    return map.size();
	}
	public Object getElementAt(int index) {
	    String key = getKeys().get(index);
	    return key + " = " + map.get(key);
	}
    }

}
