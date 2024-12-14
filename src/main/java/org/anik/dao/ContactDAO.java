package org.anik.dao;

import com.mysql.cj.protocol.Resultset;
import org.anik.entity.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    private Connection connection;
    public ContactDAO(Connection connection){
        this.connection = connection;
    }

    public boolean saveContact(Contact contact){
        boolean isSave = false;

        try{
            String insertQuery = "insert into contact(name, phone) values(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getPhone());

            int update = preparedStatement.executeUpdate();
            if(update == 1){
                isSave = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return isSave;
    }

    public boolean editContact(Contact contact){
        boolean isEdit = false;

        try{
            String updateQuery = "update contact set name=?, phone=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getPhone());
            preparedStatement.setInt(3, contact.getId());

            int update = preparedStatement.executeUpdate();
            if(update == 1){
                isEdit = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return isEdit;
    }

    public boolean deleteContact(int contactID){
        boolean isDeleted = false;

        try{
            String deleteQuery = "delete from contact where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, contactID);

            int update = preparedStatement.executeUpdate();
            if(update == 1){
                isDeleted = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return isDeleted;
    }

    public List<Contact> getAllContact(){
        List<Contact> contactList = new ArrayList<Contact>();
        Contact contact = null;

        try{
            String getQuery = "select *from contact";
            PreparedStatement preparedStatement= connection.prepareStatement(getQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                contact = new Contact();
                contact.setId(resultSet.getInt(1));
                contact.setName(resultSet.getString(2));
                contact.setPhone(resultSet.getString(3));
                contactList.add(contact);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return contactList;
    }

}
