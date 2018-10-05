package com.ms.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.stock.model.Quote;

public interface QuotesRepository extends JpaRepository<Quote, Integer>{
	List<Quote> findByUsername(String username);
}
