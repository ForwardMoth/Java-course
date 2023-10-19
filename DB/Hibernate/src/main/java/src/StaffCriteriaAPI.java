package src;

import org.hibernate.Session;
import src.models.Staff;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

public class StaffCriteriaAPI {
    public List<Staff> selectAll(){
        List<Staff> staffs;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Staff> query = cb.createQuery(Staff.class);
            query.select(query.from(Staff.class));
            staffs = session.createQuery(query).getResultList();
            session.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return staffs;
    }

    public List<Staff> selectByColumn(String column, Object value) {
        List<Staff> staffs;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Staff> query = cb.createQuery(Staff.class);
            Root<Staff> root = query.from(Staff.class);
            query.select(root).where(cb.equal(root.get(column), value));
            staffs = session.createQuery(query).getResultList();
            session.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return staffs;
    }

    public Staff selectById(Integer id) {
        List<Staff> staffs = selectByColumn("id", id);
        return staffs.isEmpty() ? null : staffs.getFirst();
    }

    public void updateStaff(Integer id, String column, Object value){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaUpdate<Staff> criteriaUpdate = cb.createCriteriaUpdate(Staff.class);
            Root<Staff> root = criteriaUpdate.from(Staff.class);
            criteriaUpdate.set(root.get(column), value).where(cb.equal(root.get("id"), id));
            Query query = session.createQuery(criteriaUpdate);
            try {
                session.beginTransaction();
                query.executeUpdate();
                session.getTransaction().commit();
            }
            catch (Exception e){
                session.getTransaction().rollback();
            }
            finally {
                session.close();
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStaff(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaDelete<Staff> criteriaDelete = cb.createCriteriaDelete(Staff.class);
            Root<Staff> root = criteriaDelete.from(Staff.class);
            criteriaDelete.where(cb.equal(root.get("id"), id));
            Query query = session.createQuery(criteriaDelete);
            try {
                session.beginTransaction();
                query.executeUpdate();
                session.getTransaction().commit();
            }
            catch (Exception e) {
                session.getTransaction().rollback();
            }
            finally {
                session.close();
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
