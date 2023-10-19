package src;

import org.hibernate.Session;
import src.models.Staff;

import javax.persistence.Query;
import java.util.List;

public class StaffHQL {
    private final String tableName = "Staff";
    public List<Staff> selectAll() {
        List<Staff> staffs;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from " + tableName);
            staffs = query.getResultList();
            session.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return staffs;
    }

    public List<Staff> selectByColumn(String column, Object value) {
        List<Staff> staffs;
        try {
          Session session = HibernateUtil.getSessionFactory().openSession();
          session.beginTransaction();
          Query query = session.createQuery("from " + tableName + " WHERE " + column + " = :value" );
          query.setParameter("value", value);
          staffs = query.getResultList();
          session.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return staffs;
    }

    public Staff selectByID(Integer id) {
        List<Staff> staffs = selectByColumn("id", id);
        return (staffs.isEmpty()) ? null : staffs.getFirst();
    }

    public void updateStaff(Integer id, String column, Object value) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            try {
                session.beginTransaction();
                Query query = session.createQuery("UPDATE " + tableName +
                        " SET " + column + " = :value " +
                        "WHERE id = :id");
                query.setParameter("value", value);
                query.setParameter("id", id);
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

    public void deleteStaff(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            try {
                session.beginTransaction();
                Query query = session.createQuery("DELETE FROM " + tableName + " WHERE id = :id");
                query.setParameter("id", id);
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
