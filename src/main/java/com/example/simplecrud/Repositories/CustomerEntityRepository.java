package com.example.simplecrud.Repositories;

import com.example.simplecrud.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerEntityRepository extends JpaRepository<CustomerEntity,Long> {
    @Override
    List<CustomerEntity> findAll();
}