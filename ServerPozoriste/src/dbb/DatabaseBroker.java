/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbb;

import domen.IGeneralObjectDelete;
import domen.IGeneralObjectInsert;
import domen.IGeneralObjectSelect;
import domen.IGeneralObjectUpdate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import konekcija.ConnectionFactory;

/**
 *
 * @author Luka
 */
public class DatabaseBroker {
    
    public IGeneralObjectInsert ubaci(IGeneralObjectInsert generalObject) throws Exception {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(generalObject.getTableName())
                    .append(" (").append(generalObject.getColumnNamesForInsert()).append(")")
                    .append(" VALUES (")
                    .append(generalObject.getInsertValues())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                generalObject.setId(id);
            }
            connection.commit();
            statement.close();
            return generalObject;

        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void ubaciGP(IGeneralObjectInsert generalObject) throws Exception {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(generalObject.getTableName())
                    .append(" (").append(generalObject.getColumnNamesForInsert()).append(")")
                    .append(" VALUES (")
                    .append(generalObject.getInsertValues())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
            

        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public IGeneralObjectUpdate izmeni(IGeneralObjectUpdate generalObject) throws Exception {
        try {
             Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            String[] kolone=generalObject.getColumnNameForUpdate().split(",");
            String[] elementi=generalObject.getUpdateValue().split(",");
            sb.append("UPDATE ")
                    .append(generalObject.getTableName()).append(" SET ");
                    for(int i=0;i<elementi.length;i++){
                        sb.append(kolone[i]).append(" = ").append(elementi[i]);
                        if(i<elementi.length-1)
                            sb.append(",");
                    }
                    sb.append(" WHERE ").append(generalObject.getColumnNameForSet())
                    .append(" = ").append(generalObject.getSetValue());
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            connection.commit();
            statement.close();
            return generalObject;

        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public ResultSet vratiSve(IGeneralObjectSelect generalObject) throws Exception {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ")
                    .append(generalObject.getTableNameG());
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            
            //connection.commit();
            //statement.close();
            return rs;

        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public ResultSet pretrazi(IGeneralObjectSelect generalObject) throws Exception {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ")
                    .append(generalObject.getTableNameG()).append(" WHERE ")
                    .append(generalObject.getCriteriaRowName())
                    .append(" LIKE ")
                    .append(generalObject.getCriteriaValue());
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            
            //connection.commit();
            //statement.close();
            return rs;

        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public ResultSet ucitaj(IGeneralObjectSelect generalObject) throws Exception {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ")
                    .append(generalObject.getTableNameG()).append(" WHERE ")
                    .append(generalObject.getIdRowName())
                    .append(" = ")
                    .append(generalObject.getId());
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            
            //connection.commit();
            //statement.close();
            return rs;

        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public IGeneralObjectDelete obrisi(IGeneralObjectDelete generalObject) throws Exception {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ")
                    .append(generalObject.getTableName()).append(" WHERE ").append(generalObject.getColumnNameForDelete())
                    .append(" = ").append(generalObject.getDeletedValue());
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            connection.commit();
            statement.close();
            return generalObject;

        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
