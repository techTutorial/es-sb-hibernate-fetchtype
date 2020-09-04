package com.javasampleapproach.hibernate.fetchtype.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javasampleapproach.hibernate.fetchtype.model.EsProductEntity;

public interface CompanyRepository extends JpaRepository<EsProductEntity, Integer>{
}