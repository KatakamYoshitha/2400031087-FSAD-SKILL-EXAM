package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;

public class ClientDemo 
{
    public static void main(String[] args)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // INSERT OPERATION
        Product p = new Product("Laptop", "Gaming Laptop", new Date(), "Available");
        session.save(p);

        tx.commit();
        System.out.println("Product Inserted Successfully");

        // UPDATE OPERATION
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx2 = session2.beginTransaction();

        Product product = session2.get(Product.class, p.getId());
        product.setName("Updated product");
        product.setStatus("1 left");

        session2.update(product);

        tx2.commit();
        System.out.println("Product Updated Successfully");

        session.close();
        session2.close();
    }
}