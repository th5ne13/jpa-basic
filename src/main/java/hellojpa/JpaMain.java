package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        // code 작성
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            entity manager를 자바 collection 같은 놈이라고 생각. 객체를 대신저장해줌
            // 비영속 상태
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA101");

//            System.out.println("===Before===");
//            em.persist(member); // 영속 상태
//            System.out.println("===After===");

//            Member findMember = em.find(Member.class, 101L);
//            System.out.println("findMember.getId = " + findMember.getId());
//            System.out.println("findMember.getName = " + findMember.getName());


//            Member member = em.find(Member.class, 150L);
//            member.setName("AAA");  // 150번을 가져와서 1차캐시에 넣을테지만
//            em.detach(member);  // JPA가 관리하는 영속상태에서 분리시켜버리기 때문에 변경감지가 일어나지않음

            System.out.println("========================");
            tx.commit();    // 커밋시점에 영속성 컨텍스트에있는애가, DB에 쿼리로 날라간다
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        em.close();

        emf.close();


    }
}
