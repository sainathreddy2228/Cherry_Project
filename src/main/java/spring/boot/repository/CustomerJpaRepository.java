package spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.boot.entity.Customer;
@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {

}
