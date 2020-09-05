package es.example.sb.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.example.sb.hibernate.model.EsProductEntity;

public interface EsProductRepository extends JpaRepository<EsProductEntity, Integer>{
}