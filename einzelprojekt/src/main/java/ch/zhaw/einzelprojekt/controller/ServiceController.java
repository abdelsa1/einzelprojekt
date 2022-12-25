package ch.zhaw.einzelprojekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.einzelprojekt.model.Buch;
import ch.zhaw.einzelprojekt.model.BuchAssignDTO;
import ch.zhaw.einzelprojekt.model.BuchChangeStateDTO;
import ch.zhaw.einzelprojekt.service.BuchService;

@RestController
@RequestMapping ("/api/service")

public class ServiceController {
    @Autowired
    BuchService buchService;

    @PostMapping("/buchassignment")
    public ResponseEntity<Buch> assignBuch(@RequestBody BuchAssignDTO assignDTO){
         Buch b = buchService.assignBuch(assignDTO.getBuchId(), assignDTO.getStudierendeId());
        return new ResponseEntity<>(b, HttpStatus.OK);
       }

    @PostMapping("/buchAusgeliehen")
    public ResponseEntity<Buch> changeStateToAusgeliehen(@RequestBody BuchChangeStateDTO assignDTO) {
        Buch b = buchService.changeStateToAusgeliehen(assignDTO.getBuchId());
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @PostMapping("/buchVerfuegbar")
    public ResponseEntity<Buch> changeStateToVerfuegbar(@RequestBody BuchChangeStateDTO assignDTO) {
        Buch b = buchService.changeStateToVerfuegbar(assignDTO.getBuchId());
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    }
    

