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
public interface IGeneralObjectDelete extends Serializable{
    
    public String getTableName();

    public String getColumnNameForDelete();

    public String getDeletedValue();
}
