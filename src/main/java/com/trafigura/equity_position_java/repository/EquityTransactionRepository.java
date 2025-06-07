package com.trafigura.equity_position_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trafigura.equity_position_java.entity.EquityTransaction;

public interface EquityTransactionRepository extends JpaRepository<EquityTransaction, Long> {
	
}