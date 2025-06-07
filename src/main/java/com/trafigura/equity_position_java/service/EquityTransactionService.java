package com.trafigura.equity_position_java.service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.trafigura.equity_position_java.entity.EquityTransaction;
import com.trafigura.equity_position_java.repository.EquityTransactionRepository;

@Service
public class EquityTransactionService {

    private final EquityTransactionRepository equityRepo;

    public EquityTransactionService(EquityTransactionRepository equityRepo) {
        this.equityRepo = equityRepo;
    }

    public List<EquityTransaction> getAllEquity() {
        return equityRepo.findAll();
    }

    public Optional<EquityTransaction> getEquityById(Long id) {
        return equityRepo.findById(id);
    }

    public EquityTransaction saveEquity(EquityTransaction equity) {
        return equityRepo.save(equity);
    }

    public void deleteEquity(Long id) {
     equityRepo.deleteById(id);
    }

	public List<EquityTransaction> getEquityPositions() {
     List<EquityTransaction> allEquities = equityRepo.calcEquityPositions();
     allEquities.stream().forEach(e -> {
         if(e.getCrudeType().equals("CANCEL")) {
        	 e.setQuantity(0L);
         }
     });
     return allEquities;
	}
}