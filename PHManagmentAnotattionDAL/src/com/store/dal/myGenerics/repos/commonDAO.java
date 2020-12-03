
package com.store.dal.myGenerics.repos;

import java.util.List;

/**
 *
 * @author ahmed
 * @param <T>
 */
public interface commonDAO<T> {
       public abstract T add(T t) ;
    

      public  abstract T update(T t);

      public abstract void remove(Object id );

      public abstract T findById(Object id) ;

      public abstract List<T> findList() ;

 
      
}
