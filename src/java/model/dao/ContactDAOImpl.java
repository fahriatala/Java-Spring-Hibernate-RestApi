/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Contact;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wonderlabs
 */
public class ContactDAOImpl extends BaseDAO implements ContactDAO {
    
    private SessionFactory sessionFactory;
    
    public ContactDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        super.setSessionFactory(sessionFactory);
    }

    @Override
    @Transactional
    public List<Contact> getContactList() {
        List<Contact> clist = new ArrayList<Contact>();
        clist = findAll(Contact.class);
        return clist;
    }

    @Override
    @Transactional 
    public Contact getContactById(int id) {
        Contact c = null;
        List<Criterion> criterias = new ArrayList<Criterion>();
        Criterion sd = Restrictions.eq("id", id);
        criterias.add(sd);
        c = (Contact) findUniqueByCriteria(Contact.class,criterias);
        return c;
    }

    @Override
    @Transactional 
    public Contact addContact(Contact c) {
        save(c);
        return c;
    }

    @Override
    @Transactional 
    public Contact editContact(Contact c) {
        saveOrUpdate(c);
        return c;
    }
    
    @Override
    @Transactional
    public void deleteContact(int id) {
        Contact c = null;
        List<Criterion> criterias = new ArrayList<Criterion>();
        Criterion aid = Restrictions.eq("id", id);
        criterias.add(aid);
        c = (Contact) findUniqueByCriteria(Contact.class, criterias);
        delete(c);
    }
      
}
