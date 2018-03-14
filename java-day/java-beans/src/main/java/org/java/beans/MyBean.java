package org.java.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class MyBean {
	
	
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private final VetoableChangeSupport vcs = new VetoableChangeSupport(this);
	

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }
    
    
    public void addVetoableChangeListener(VetoableChangeListener listener){
    	this.vcs.addVetoableChangeListener(listener);
    }
    
    public void removeVetoableChangeListener(VetoableChangeListener listener){
    	this.vcs.removeVetoableChangeListener(listener);
    }

    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String newValue) {
        String oldValue = this.value;
        this.value = newValue;
        this.pcs.firePropertyChange("value", oldValue, newValue);
    }
    
    public void setValVetoableValue(String newValue) {
        String oldValue = this.value;
        this.value = newValue;
        try {
			this.vcs.fireVetoableChange("value", oldValue, newValue);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
    }
    
    
    
    public static void main(String[] args) {
    	MyBean my  = new MyBean();
    	my.setValue("oldVal");
    	my.addPropertyChangeListener(new ValuePropertyChangeListener());
    	my.setValue("newVal");
    	
	}
    
    //属性修改通知
    static class ValuePropertyChangeListener implements PropertyChangeListener{

		public void propertyChange(PropertyChangeEvent evt) {
			 System.out.println(evt.getPropertyName()+"修改了");
			
		}
    	
    }
    
    
    static class ValVetoableChangeListener implements VetoableChangeListener{

		public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
			
			
		}
    	
    }

}
