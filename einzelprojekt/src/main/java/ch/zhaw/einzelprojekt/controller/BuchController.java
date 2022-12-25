package ch.zhaw.einzelprojekt.controller;

import java.util.List;
import ch.zhaw.einzelprojekt.service.BuchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.einzelprojekt.model.Buch;
import ch.zhaw.einzelprojekt.model.BuchCreateDTO;
import ch.zhaw.einzelprojekt.model.BuchStateAggregationDTO;
import ch.zhaw.einzelprojekt.model.BuchStudierendeAggregationDTO;

@RestController
@RequestMapping("/api/buch")
public class BuchController {

    @Autowired
    BuchService buchService;

    @PostMapping("")
    public ResponseEntity<Buch> createBuch(
            @RequestBody BuchCreateDTO bDTO) {
        Buch b = buchService.create(bDTO);
        return new ResponseEntity<>(b, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Buch>> getAllBuch() {
        List<Buch> allBuch = buchService.getAllBuch();
        return new ResponseEntity<>(allBuch, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buch> getBuchById(@PathVariable String id) {
        Buch buch = buchService.getBuch(id);
        if (buch != null) {
            return new ResponseEntity<>(buch, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/bystate")
    public ResponseEntity<List<BuchStateAggregationDTO>> getBuchStateAggregation() {
        return new ResponseEntity<>(buchService.getBuchStateAggregation(), HttpStatus.OK);
    }

    @GetMapping("/byStudierende")
    public ResponseEntity<List<BuchStudierendeAggregationDTO>> getBuchStudierendeAggregation() {
        return new ResponseEntity<>(buchService.getBuchStudierendeAggregation(), HttpStatus.OK);

    }

}