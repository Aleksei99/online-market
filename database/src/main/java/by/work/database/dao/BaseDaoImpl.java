package by.work.database.dao;

import by.work.database.entity.BaseEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {
//    @Autowired
//    SessionFactory sessionFactory;
//
//    private Class<T> entityClass;
//
//    @Autowired
//    public BaseDaoImpl() {
//        this.entityClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(),BaseDaoImpl.class);
//    }
//
//    @Override
//    public void save(T entity) {
//        sessionFactory.getCurrentSession().save(entity);
//    }
//
//    @Override
//    public List<T> findAll() {
//        return sessionFactory.getCurrentSession()
//                .createQuery("select e from "+entityClass.getSimpleName()+" e",entityClass)
//                .getResultList();
//    }
//    protected SessionFactory getSessionFactory(){
//        return this.sessionFactory;
//    }
}
