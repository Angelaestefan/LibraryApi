package com.example.library.controller;

import com.example.library.model.Patron;
import com.example.library.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    @Autowired
    private PatronRepository patronRepository;

    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patron> getPatronById(@PathVariable Long id) {
        return patronRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createPatron(@Valid @RequestBody Patron patron) {
        if (patronRepository.existsByEmail(patron.getEmail())) {
            return ResponseEntity.badRequest()
                    .body("Email already exists");
        }
        return ResponseEntity.ok(patronRepository.save(patron));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable Long id, @Valid @RequestBody Patron patronDetails) {
        return patronRepository.findById(id)
                .map(patron -> {
                    patron.setFirstName(patronDetails.getFirstName());
                    patron.setLastName(patronDetails.getLastName());
                    patron.setEmail(patronDetails.getEmail());
                    patron.setPhoneNumber(patronDetails.getPhoneNumber());
                    return ResponseEntity.ok(patronRepository.save(patron));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Long id) {
        return patronRepository.findById(id)
                .map(patron -> {
                    patronRepository.delete(patron);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
