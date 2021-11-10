package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.bean.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("delete from Product p where p.pname = :pname")
	public int deleteProductByName(@Param("pname") String pname);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update Product p set p.price = :price where p.pid = :pid")
	public int updateProductPrice(@Param("pid") int pid, @Param("price") float price);
}
