/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.ContactDAO;
import model.pojo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wonderlabs
 */
@RestController
public class ContactController {
    
    @Autowired
    private ContactDAO contactDao;
    
    @RequestMapping(value = "/contact/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addContact(@RequestBody Contact c) {
        Contact ctc = contactDao.addContact(c);
        return new ResponseEntity<Contact>(ctc, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/contact/{id}/", method = RequestMethod.GET)
    public ResponseEntity getContact(@PathVariable("id") int id) {
        Contact c = contactDao.getContactById(id);
        if(c == null){
            return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Contact>(c, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/contact/edit/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editContact(@RequestBody Contact c) {
        Contact ctc = contactDao.editContact(c);
        return new ResponseEntity<Contact>(ctc, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/contact/list/", method = RequestMethod.GET)
    public ResponseEntity getContactList() {
        List<Contact> clist = contactDao.getContactList();
        return new ResponseEntity<List<Contact>>(clist, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/contact/{id}/delete/", method = RequestMethod.GET)
    public ResponseEntity deleteContact(@PathVariable("id") int id) {
        contactDao.deleteContact(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
}
