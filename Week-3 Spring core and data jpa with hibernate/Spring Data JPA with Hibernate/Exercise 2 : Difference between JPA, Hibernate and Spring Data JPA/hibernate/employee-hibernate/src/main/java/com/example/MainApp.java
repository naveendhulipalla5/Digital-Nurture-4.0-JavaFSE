package com.example;

import com.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            Employee emp = new Employee();
            emp.setName("John Doe");
            emp.setDepartment("HR");

            session.beginTransaction();
            session.persist(emp);
            session.getTransaction().commit();

            System.out.println("Inserted successfully");
        } finally {
            session.close();
            factory.close();
        }
    }
}
