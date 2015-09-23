/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lanzisun.monocrawler.data;

/**
 *
 * @author 60334
 */
public interface BaseDataFileInterface {
    
    public String getMineType();
    
    public String getFileName();
    
    public int getFileSize();
    
    public String getPath();
    
    public String getExtension();
}
