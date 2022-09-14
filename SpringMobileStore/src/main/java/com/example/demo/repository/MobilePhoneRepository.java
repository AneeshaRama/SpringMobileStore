package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.MobilePhone;

@Repository
public interface MobilePhoneRepository extends JpaRepository<MobilePhone, Integer> {
	
	@Query(value = "select * from mobile_phone", nativeQuery = true)
	public List<MobilePhone> getAllMobiles();
	
	@Query(value = "select m from MobilePhone m where m.mobileId = :id ")
	public MobilePhone getMobilePhoneById(@Param(value = "id") int id);
	
	@Query(value = "select m from MobilePhone m where m.brandName = :name")
	public List<MobilePhone> getMobilePhoneByBrandName(@Param(value = "name")String name);
	
	@Query(value = "select m from MobilePhone m where m.modelName = :name")
	public List<MobilePhone> getMobilePhoneByModelName(@Param(value = "name") String name);
	
	@Query(value = "select m from MobilePhone m where m.processor = :name")
	public List<MobilePhone> getByProcessor(@Param(value = "name") String name);
	
	@Query(value = "select m from MobilePhone m where m.color in('black', 'blue')")
	public List<MobilePhone> getByColor();
	
	@Query(value = "select count(distinct m.modelName) from MobilePhone m")
	public int getMobilePhones();
	
	@Query(value = "select count(m.modelName) from MobilePhone m where m.mobilePhoneCost > :cost")
	public int getMobilePhone(@Param(value = "cost") double cost);
	
}
