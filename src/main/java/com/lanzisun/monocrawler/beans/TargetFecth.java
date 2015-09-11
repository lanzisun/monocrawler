/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lanzisun.monocrawler.beans;

import java.beans.*;
import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author 60334
 */
public class TargetFecth implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String website;
    
    private StringProperty wesiteProperty = new SimpleStringProperty();
    
    private PropertyChangeSupport propertySupport;
    
    public TargetFecth() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getWebsite() {
        return wesiteProperty.getValue();
    }
    
    public void setWebsite(String value) {
        String oldValue = website;
        website = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, website);
    }
    
    
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
}
