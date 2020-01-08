/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.database;

import java.util.List;
import localhost.cnp.cnpv2spring.entities.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HardLOLMaster
 */
public class AddressDao implements DataAccess<Address>{

    @Override
    public Address getById(Long id) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Address address = session.get(Address.class, id);
        session.close();
        return address;}

    @Override
    public void update(Address t) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();
    }

    @Override
    public void save(Address t) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Address t) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(t);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Address> getByQuery(String query) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        List<Address> list = session.createQuery(query).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public void saveOrUpdate(Address t) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(t);
        transaction.commit();
        session.close();
    }
    
}
