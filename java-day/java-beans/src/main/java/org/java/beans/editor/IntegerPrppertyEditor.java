package org.java.beans.editor;

import java.beans.PropertyEditorSupport;

public class IntegerPrppertyEditor extends PropertyEditorSupport{
    
    
    public IntegerPrppertyEditor(Object source) {
        if (source == null) {
           throw new NullPointerException();
        }
        setSource(source);
    }
    
    
    @Override
    public void setValue(Object value) {
        
        try {
            super.setValue(Integer.valueOf(String.valueOf(value)));
        } catch (Exception e) {
            throw new java.lang.IllegalArgumentException(String.valueOf(value));
        }
        
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      //  super.setAsText(text);
        setValue(text);
    }

}
