/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Contact;
/**
 *
 * @author wonderlabs
 */
public interface ContactDAO {
    
    public List<Contact> getContactList();
    public Contact getContactById(int id);
    public Contact addContact(Contact c);
    public Contact editContact(Contact c);
    public void deleteContact(int id);
    
}
