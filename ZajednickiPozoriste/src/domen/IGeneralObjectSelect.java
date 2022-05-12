/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Luka
 */
public interface IGeneralObjectSelect extends Serializable{
    
   public String getTableNameG();
   
   public int getAttNum();
   
   public void setGeneralObject(IGeneralObjectSelect obj);
   
   public String getCriteriaRowName();
   public String getCriteriaValue();
   public String getIdRowName();
   public String getId();
   
}
