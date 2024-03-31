package com.example.skillfactory.part1.controllers;

import com.example.skillfactory.part1.dto.Account;
import com.example.skillfactory.part1.dto.TransferRequest;
import com.example.skillfactory.part1.model.ErrorDetail;
import com.example.skillfactory.part1.services.TransferService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final TransferService transferService;
    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/getBalance")
    public ResponseEntity<?> getBalance(@RequestBody TransferRequest request) {
        try {
            Account account = Account.of(request.getId(), transferService.getBalance(request.getId()));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(account);
        } catch (EmptyResultDataAccessException e) {
            ErrorDetail errorDetail = new ErrorDetail();
            errorDetail.setMessage("You entered the wrong ID");
            return ResponseEntity.badRequest().body(errorDetail);
        }
    }

    @PostMapping("/takeMoney")
    public ResponseEntity<?> takeMoney(@RequestBody TransferRequest request) {
        try {
            if (request.getMoney().signum() <= 0) return ResponseEntity.badRequest().body("You entered the wrong money.");
            if (!transferService.takeMoney(request.getId(), request.getMoney())) {
                ErrorDetail errorDetail = new ErrorDetail();
                errorDetail.setMessage("Not enough money.");
                return ResponseEntity.badRequest().body(errorDetail);
            }
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successful.");
        } catch (EmptyResultDataAccessException e) {
            ErrorDetail errorDetail = new ErrorDetail();
            errorDetail.setMessage("You entered the wrong ID");
            return ResponseEntity.badRequest().body(errorDetail);
        }
    }

    @PostMapping("/putMoney")
    public ResponseEntity<?> putMoney(@RequestBody TransferRequest request) {
        try {
            if (request.getMoney().signum() <= 0) return ResponseEntity.badRequest().body("You entered the wrong money.");
            transferService.putMoney(request.getId(), request.getMoney());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successful.");
        } catch (EmptyResultDataAccessException e) {
            ErrorDetail errorDetail = new ErrorDetail();
            errorDetail.setMessage("You entered the wrong ID");
            return ResponseEntity.badRequest().body(errorDetail);
        }
    }
}
