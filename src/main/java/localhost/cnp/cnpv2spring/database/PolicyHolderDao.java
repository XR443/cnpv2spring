/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.database;

import java.util.List;
import localhost.cnp.cnpv2spring.entities.PolicyHolder;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HardLOLMaster
 */
public class PolicyHolderDao implements DataAccess<PolicyHolder> {

    @Override
    public PolicyHolder getById(Long id) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        PolicyHolder policyholder = session.get(PolicyHolder.class, id);
        session.close();
        return policyholder;
    }

    @Override
    public void update(PolicyHolder t) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();
    }

    @Override
    public void save(PolicyHolder t) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(PolicyHolder t) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(t);
        transaction.commit();
        session.close();
    }

    @Override
    public List<PolicyHolder> getByQuery(String query) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        List<PolicyHolder> list = session.createQuery(query).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public void saveOrUpdate(PolicyHolder t) {
        Session session = SessionFactoryUtil.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(t);
        transaction.commit();
        session.close();
    }

}
