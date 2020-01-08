/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.database;

import java.util.List;

/**
 *
 * @author HardLOLMaster
 */
public interface DataAccess<T> {

    public T getById(Long id);

    public void update(T t);

    public void save(T t);

    public void saveOrUpdate(T t);
    
    public void delete(T t);
    
    public List<T> getByQuery(String query);

}
