package es.example.sb.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.example.sb.hibernate.model.EsAccessoriesEntity;

public interface EsAccessoriesRepository extends JpaRepository<EsAccessoriesEntity, Integer>{
}