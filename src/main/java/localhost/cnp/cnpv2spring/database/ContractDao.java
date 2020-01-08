/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.database;

import java.util.List;
import localhost.cnp.cnpv2spring.entities.Contract;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HardLOLMaster
 */
public class ContractDao implements DataAccess<Contract> {

    @Override
    public Contract getById(Long id) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Contract contract = session.get(Contract.class, id);
        session.close();
        return contract;
    }

    @Override
    public void update(Contract t) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();
    }

    @Override
    public void save(Contract t) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Contract t) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(t);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Contract> getByQuery(String query) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        List<Contract> list = session.createQuery(query).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public void saveOrUpdate(Contract t) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(t);
        transaction.commit();
        session.close();
    }

}
