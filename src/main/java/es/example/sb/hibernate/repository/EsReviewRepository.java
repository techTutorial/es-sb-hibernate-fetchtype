package es.example.sb.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.example.sb.hibernate.model.EsReviewEntity;

public interface EsReviewRepository extends JpaRepository<EsReviewEntity, Integer>{
}