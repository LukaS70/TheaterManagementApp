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
public interface IGeneralObjectInsert extends Serializable{
    
    public String getTableName();

    public String getColumnNamesForInsert();

    public String getInsertValues();

    public void setId(int id);
    
}
