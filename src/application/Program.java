package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===== TEST 1: seller findById =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n===== TEST 2: seller findByDepartment =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);
		
		System.out.println("\n===== TEST 3: seller findAll =====");
		list = sellerDao.findAll();
		list.forEach(System.out::println);
	
		System.out.println("\n===== TEST 4: seller insert =====");
		Seller newSeller = new Seller(null, "Grege", "grag@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
		
		System.out.println("\n===== TEST 5: seller update =====");
		seller = sellerDao.findById(1);
		seller.setName("Maria waine");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n===== TEST 6: seller delete =====");
		System.err.print("Enter id for delete test: ");
		int idTest = sc.nextInt();
		sellerDao.deleteById(idTest);
		System.out.println("Delete completede");
		
		sc.close();
	}

}
