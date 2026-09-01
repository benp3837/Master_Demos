package org.fnma.controllers;

import org.fnma.models.Herb;
import org.fnma.models.Loan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(value="loan")
@ResponseBody
public class LoanController {

    @GetMapping
    public ResponseEntity<ArrayList<Loan>> getLoans(){

        //imagine we got these from the DB
        ArrayList<Loan> loans = new ArrayList<>();

        loans.add(new Loan(1, 2000, "Flowers"));
        loans.add(new Loan(2, 5000, "Chocolate"));
        loans.add(new Loan(3, 75000, "Custody Battle"));

        return ResponseEntity.ok(loans);

    }


    @PostMapping
    public ResponseEntity<Loan> insertLoan(@RequestBody Loan loan){

        //Validations before going to the hypothetical Service/DAO
        if(loan.getLoanAmount() <= 0) {
            throw new IllegalArgumentException("Must request a positive number");
        }

        return ResponseEntity.accepted().body(loan);

    }

    //Exception Handlers---------------------------

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArg(Exception e){

        //400 BAD REQUEST with Exception message as the body
        return ResponseEntity.badRequest().body(e.getMessage());
    }



}
