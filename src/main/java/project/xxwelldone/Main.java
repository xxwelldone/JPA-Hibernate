package project.xxwelldone;

import org.hibernate.SQLQuery;
import project.xxwelldone.dominio.Pessoa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos cadastros? ");
        int x = sc.nextInt();

        sc.nextLine();
        for (int i = 0; i < x; i++) {
            System.out.println("Digite nome");
            String name = sc.nextLine();
            System.out.println("Digite email");
            String email = sc.nextLine();
            em.getTransaction().begin();
            Pessoa p = new Pessoa(null, name, email);
            em.persist(p);
            em.getTransaction().commit();

        }


        em.close();
        emf.close();


    }
}