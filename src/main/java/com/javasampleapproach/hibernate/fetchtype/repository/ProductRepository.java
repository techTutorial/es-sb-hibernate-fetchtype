package com.javasampleapproach.hibernate.fetchtype.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javasampleapproach.hibernate.fetchtype.model.EsAccessoriesEntity;

public interface ProductRepository extends JpaRepository<EsAccessoriesEntity, Integer>{
}