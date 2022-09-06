package com.example.decision;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecisionService {

    @Autowired
    DecisionRepository decisionRepository;

    public List<Decision> getAll() {
        List<Decision> decisions = decisionRepository.findAll();
        return decisions;
    }

    public Decision create(Decision decision) {

        // validation
        if (decision.getCreatedBy() == null || decision.getCreatedBy().length() < 1 ) {
            throw new RuntimeException("Decision must have createdBy");
        }

        if (decision.getTitle() == null || decision.getTitle().length() < 1) {
            throw new RuntimeException("Decision must have a title");
        }

        if (decision.getContent() == null || decision.getContent().length() < 1) {
            throw new RuntimeException("Decision must have content");
        }

        if (decision.getType() == null || decision.getType().length() < 1) {
            throw new RuntimeException("Decision must have a type");
        }

        return decisionRepository.save(decision);

    }

    public boolean deleteById(int id) {
        Decision decisionToDelete = decisionRepository.findById(id).orElse(null);

        if (decisionToDelete == null) {
            return false;
        }

        decisionRepository.delete(decisionToDelete);
        return true;
    }

    public Decision updateById(Decision newDecision, int id) {
        Decision decisionToUpdate = decisionRepository.findById(id).orElse(null);

        if (decisionToUpdate == null) {
            throw new RuntimeException("Decision is not there");
        }

        decisionToUpdate.setTitle(newDecision.getTitle());
        decisionToUpdate.setContent(newDecision.getContent());
        decisionToUpdate.setType(newDecision.getType());
        decisionToUpdate.setDateCreated(newDecision.getDateCreated());
        decisionRepository.delete(newDecision);
        return decisionRepository.save(decisionToUpdate);
    }


}