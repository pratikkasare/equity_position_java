package com.trafigura.equity_position_java.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trafigura.equity_position_java.entity.EquityTransaction;
import com.trafigura.equity_position_java.service.EquityTransactionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/equity")
public class EquityController {

    private final EquityTransactionService equityService;

    @Autowired
    public EquityController(EquityTransactionService equityService) {
        this.equityService = equityService;
    }

    @GetMapping
    @Operation(
            summary = "Fetch all Equity",
            description = "fetches all equtiies from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public List<EquityTransaction> getAllEquity() {
        return equityService.getAllEquity();
    }

    @GetMapping("/{id}")
    public Optional<EquityTransaction> getEquityById(@PathVariable Long id) {
        return equityService.getEquityById(id);
    }

    @PostMapping
    public EquityTransaction createEquity(@RequestBody EquityTransaction equity) {
        return equityService.saveEquity(equity);
    }

    @PutMapping("/{id}")
    public EquityTransaction updateEquity(@PathVariable Long id, @RequestBody EquityTransaction equity) {
    	equity.setTradeId(id);
        return equityService.saveEquity(equity);
    }

    @DeleteMapping("/{id}")
    public void deleteEquity(@PathVariable Long id) {
        equityService.deleteEquity(id);
    }
    
    @GetMapping("/calPosition")
    @Operation(
            summary = "Calcualte position of all Equity",
            description = "Calcualte position of all Equity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public List<EquityTransaction> getEquityPositions() {
        return equityService.getEquityPositions();
    }
}