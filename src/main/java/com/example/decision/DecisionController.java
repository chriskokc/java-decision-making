package com.example.decision;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class DecisionController {

    @Autowired
    DecisionService decisionService;

    @GetMapping("/decisions")
    public ResponseEntity<List<Decision>> getDecisions() {
        List<Decision> decisions = decisionService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(decisions);
    }

    @PostMapping("/decision")
    public ResponseEntity<?> createDecision(@RequestBody Decision decision) {
        Decision decisionCreated = decisionService.create(decision);

        try {
            return ResponseEntity.status(HttpStatus.OK).body(decisionCreated + " has been added successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Decision has invalid properties");
        }

    }

    @DeleteMapping("/decision/{id}")
    public ResponseEntity<?> deleteDecision(@PathVariable String id) {
        boolean isDeleted = decisionService.deleteById(Integer.parseInt(id));
        if (isDeleted == false) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Decision not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Decision has been deleted successfully");
    }

    @PutMapping("/decision/{id}")
    public ResponseEntity<?> updateDecision(@RequestBody Decision newDecision, @PathVariable String id) {
        Decision decisionUpdated = decisionService.updateById(newDecision, Integer.parseInt(id));

        try {
            return ResponseEntity.status(HttpStatus.OK).body(decisionUpdated + " has been updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Decision not found");
        }
    }



}