package src;

import org.hibernate.Session;
import src.models.Staff;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args){
        insertAll();
        // Criteria API variant
        StaffCriteriaAPI staffCriteriaAPI = new StaffCriteriaAPI();
        printStaffs(staffCriteriaAPI.selectAll());
        printStaffs(staffCriteriaAPI.selectByColumn("position", "middle"));
        System.out.println(staffCriteriaAPI.selectById(1));
        staffCriteriaAPI.updateStaff(1, "salary", 360000);
        System.out.println(staffCriteriaAPI.selectById(1));
        staffCriteriaAPI.deleteStaff(3);
        printStaffs(staffCriteriaAPI.selectAll());
        // HQL
        StaffHQL staffHQL = new StaffHQL();
        printStaffs(staffHQL.selectAll());
        printStaffs(staffHQL.selectByColumn("salary", 60000));
        System.out.println(staffHQL.selectByID(2));
        staffHQL.updateStaff(2, "salary", 230000);
        System.out.println(staffHQL.selectByID(2));
        staffHQL.deleteStaff(2);
        printStaffs(staffHQL.selectAll());
        HibernateUtil.close();
    }

    public static void printStaffs(List<Staff> staffs) {
        for (Staff staff : staffs)
            System.out.println(staff);
    }

    public static void insertAll() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            try {
                session.beginTransaction();
                for(Staff staff : insertAllStaffs())
                    session.save(staff);
                session.getTransaction().commit();
            }
            catch (Exception e) {
                session.getTransaction().rollback();
            }finally {
                session.close();
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }


    }

    public static ArrayList<Staff> insertAllStaffs() {
        ArrayList<Staff> staffs = new ArrayList<Staff>();
        staffs.add(createStaff("Ivanov", "Ivan", "Ivanovich", "CEO", 300000));
        staffs.add(createStaff("Petrov", "Vasiliy", "Sergeevich", "senior", 200000));
        staffs.add(createStaff("Sidorov", "Alex", "Olegovich", "middle", 120000));
        staffs.add(createStaff("Alexandrov", "Sergey", "Alexeevich", "junior", 60000));
        return staffs;
    }

    public static Staff createStaff(String firstName, String secondName, String lastName, String position, Integer salary) {
        Staff staff = new Staff();
        staff.setFirstName(firstName);
        staff.setSecondName(secondName);
        staff.setLastName(lastName);
        staff.setPosition(position);
        staff.setSalary(salary);
        return staff;
    }
}

