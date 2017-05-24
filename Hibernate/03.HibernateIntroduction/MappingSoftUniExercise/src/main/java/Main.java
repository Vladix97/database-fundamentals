import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by vladix on 5/24/17.
 */
public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

//        Project project = new Project();
//        project.setName("ProjectName");
//        project.setDescription("NothingSpecial");
//        project.setStartDate(new Date());
//
//        Town town = new Town();
//        town.setName("Bourgas");
//
//        Department department = new Department();
//        department.setName("Le Epic Meme");
//        Employee employee = em.find(Employee.class, 5);
//        department.setManager(employee);
//
//        Address address1 = new Address();
//        address1.setAddressText("FirstAddress");
//        address1.setTown(town);
//
//        Address address2 = new Address();
//        address2.setAddressText("SecondAddress");
//        address2.setTown(town);
//
//        Address address3 = new Address();
//        address3.setAddressText("ThirdAddress");
//        address3.setTown(town);
//
//        Employee employee1 = new Employee();
//        employee1.setFirstName("FirstName1");
//        employee1.setLastName("LastName1");
//        employee1.setMiddleName("MiddleName1");
//        employee1.setJobTitle("JobTitle1");
//        employee1.setDepartment(department);
//
//        Employee managerEmployee1 = em.find(Employee.class, 3);
//        employee1.setManager(managerEmployee1);
//        employee1.setHireDate(new Date());
//        employee1.setSalary(new BigDecimal("100000.00"));
//        employee1.setAddress(address1);
//        employee1.setProjects(new ArrayList<>());
//        employee1.getProjects().add(project);
//
//        em.persist(department);
//        em.persist(town);
//        em.persist(address1);
//        em.persist(address2);
//        em.persist(address3);
//        em.persist(project);
//        em.persist(employee1);

        //========================
        //========================
        //========================

//        Query nativeQuery = em.createNativeQuery("SELECT * FROM towns");
//        List<Object[]> towns = nativeQuery.getResultList();
//        for (Object[] town : towns) {
//            int townId = (int) town[0];
//
//            Town townById = em.find(Town.class, townId);
//            if (townById.getName().length() <= 5) {
//                townById.setName(townById.getName().toLowerCase());
//                em.merge(townById);
//            }
//
//        }

        //========================
        //========================
        //========================

//        Scanner in = new Scanner(System.in);
//        String[] employeeName = in.nextLine().split("\\s+");
//        Query nativeQuery = em.createNativeQuery("SELECT * FROM employees AS e WHERE e.first_name = " + "'" + employeeName[0] + "'");
//        System.out.println(nativeQuery.getResultList().isEmpty() ? "No" : "Yes");

        //========================
        //========================
        //========================

        /***
         * When refresh EntityManager changes are lost...
         */

//        Employee employee = em.find(Employee.class, 4);
//        employee.setFirstName(employee.getFirstName().toLowerCase());
////        em.refresh(employee);
//
//        em.persist(employee);

        //========================
        //========================
        //========================

//        Query nativeQuery = em.createNativeQuery("SELECT e.first_name FROM employees AS e WHERE e.salary > 50000");
//        List resultList = nativeQuery.getResultList();
//        for (Object o : resultList) {
//            System.out.println(o);
//        }

        //========================
        //========================
        //========================

//        Query nativeQuery = em.createNativeQuery("SELECT e.first_name, e.last_name, d.name, e.salary FROM employees AS e\n" +
//                "  INNER JOIN departments AS d\n" +
//                " ON e.department_id = d.department_id\n" +
//                "WHERE\n" +
//                "  d.name = 'Engineering'\n" +
//                "ORDER BY e.first_name DESC");
//
//        System.out.println("first_name | last_name | department_name | salary");
//        List<Object[]> resultList = nativeQuery.getResultList();
//        for (Object[] objects : resultList) {
//            System.out.println(String.format("%s %s %s %s",
//                    objects[0], objects[1], objects[2], objects[3]));
//        }

        //========================
        //========================
        //========================

//        Address address = new Address();
//        address.setAddressText("Vitosha 15");

//        Address address = em.find(Address.class, 294);

//        Query query = em.createQuery("SELECT e FROM Employee e WHERE e.lastName = 'Nakov'");
//        Employee nakovEmployee = ((Employee) query.getSingleResult());
//
//        nakovEmployee.setAddress(address);
//        em.persist(address);

//        em.persist(nakovEmployee);

        //========================
        //========================
        //========================

//        Query nativeQuery = em.createNativeQuery("SELECT p.name, p.description, p.start_date, p.end_date FROM projects AS p\n" +
//                "  ORDER BY p.start_date DESC\n" +
//                "LIMIT 10;");
//
//        System.out.println("name | description | start_date | end_date");
//        List<Object[]> resultList = nativeQuery.getResultList();
//        for (Object[] objects : resultList) {
//            System.out.println(
//                    String.format("%s %s %s %s", objects[0], objects[1], objects[2], objects[3]));
//        }

        //========================
        //========================
        //========================


        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
