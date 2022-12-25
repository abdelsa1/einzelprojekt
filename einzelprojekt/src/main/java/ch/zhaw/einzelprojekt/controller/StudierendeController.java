package ch.zhaw.einzelprojekt.controller;

import java.util.List;
import ch.zhaw.einzelprojekt.service.StudierendeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.einzelprojekt.model.Studierende;
import ch.zhaw.einzelprojekt.model.StudierendeCreateDTO;

@RestController
@RequestMapping("/api/studierende")
public class StudierendeController {
    @Autowired
    StudierendeService studierendeService;

    @PostMapping("")
    public ResponseEntity<Studierende> createStudierende(
            @RequestBody StudierendeCreateDTO fDTO) {
        Studierende f = studierendeService.create(fDTO);
        return new ResponseEntity<>(f, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Studierende>> getAllStudierende() {
        List<Studierende> allStudierende = studierendeService.findAll();
        return new ResponseEntity<>(allStudierende, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Studierende> getStudierendeById(@PathVariable String id) {
        Studierende studierende = studierendeService.getStudierende(id);
        if (studierende != null) {
            return new ResponseEntity<>(studierende, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}