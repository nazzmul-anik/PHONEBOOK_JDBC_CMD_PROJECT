package org.anik.main;

import org.anik.connection.ConnectionDB;
import org.anik.dao.ContactDAO;
import org.anik.entity.Contact;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    static ContactDAO contactDAO = new ContactDAO(ConnectionDB.getConnection());

    public static void createContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Phone: ");
        String phone = scanner.next();

        System.out.println(name+" "+phone);

        boolean createdContact = contactDAO.saveContact(new Contact(name, phone));
        if(createdContact){
            System.out.println("Contact Created Successfully.!!");
        }else{
            System.out.println("Contact Creation Failed!!");
        }
    }

    public static void updateContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Contact's ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Phone: ");
        String phone = scanner.next();

        boolean updateContact = contactDAO.editContact(new Contact(id, name, phone));
        if (updateContact){
            System.out.println("Contact Updated Successfully.!!");
        }else{
            System.out.println("Contact Update Failed!!");
        }
    }

    public static void deleteContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Contact's ID: ");
        int id = scanner.nextInt();

        boolean deleteContact = contactDAO.deleteContact(id);
        if(deleteContact){
            System.out.println("Contact Deleted Successfully.!!");
        }else{
            System.out.println("Contact Deletion Failed!!");
        }
    }

    public static void getAllContact(){
        List<Contact> contactList = contactDAO.getAllContact();
        if(contactList.isEmpty()){
            System.out.println("No Contact Found!!");
        }else{
            System.out.println("ID\tName\tPhone");
            for(Contact contact : contactList){
                System.out.println(contact.getId()+"\t"+contact.getName()+"\t"+contact.getPhone());
            }
        }
    }

    public static void main(String[] args) {

        boolean run = true;
        while(run){
            System.out.println("-----------------------------");
            System.out.println("1. Create Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contact");
            System.out.println("5. Exit");
            System.out.println("-------------------------------");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    createContact();
                    break;
                case 2:
                    updateContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    getAllContact();
                    break;
                case 5:
                    System.out.println("Thank you for using Phonebook!");
                    run = false;
                    break;
            }
        }
    }
}
