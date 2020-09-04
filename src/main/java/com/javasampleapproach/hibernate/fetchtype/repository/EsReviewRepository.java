package com.javasampleapproach.hibernate.fetchtype.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javasampleapproach.hibernate.fetchtype.model.EsReviewEntity;

public interface EsReviewRepository extends JpaRepository<EsReviewEntity, Integer>{
}