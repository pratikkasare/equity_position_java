package com.trafigura.equity_position_java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trafigura.equity_position_java.entity.EquityTransaction;

public interface EquityTransactionRepository extends JpaRepository<EquityTransaction, Long> {

	 @Query(value = "SELECT tt.* FROM EQUITY_TRANSACTION tt INNER JOIN (SELECT TRADE_ID, MAX(VERSION) AS MaxVersion FROM EQUITY_TRANSACTION GROUP BY TRADE_ID) groupTrade ON tt.TRADE_ID= groupTrade.TRADE_ID AND tt.VERSION= groupTrade.MaxVersion",nativeQuery = true)
	List<EquityTransaction> calcEquityPositions();
	
}