package ch.zhaw.einzelprojekt.service;

import ch.zhaw.einzelprojekt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zhaw.einzelprojekt.repository.BuchRepository;
import ch.zhaw.einzelprojekt.repository.StudierendeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BuchService {
    @Autowired
    BuchRepository buchRepository;

    @Autowired
    StudierendeRepository studierendeRepository;

    public Buch assignBuch(String buchId, String studierendeId) {
        Buch buchToAssign = buchRepository.findById(buchId).get();
        buchToAssign.setStudierendeId(studierendeId);
        BuchState buchState = BuchState.RESERVIERT;
        buchToAssign.setBuchState(buchState);
        buchRepository.save(buchToAssign);
        return buchToAssign;
}

    public Buch changeStateToAusgeliehen(String buchId) {
        Buch buchToChange = buchRepository.findById(buchId).get();
        BuchState buchState = BuchState.AUSGELIEHEN;
        buchToChange.setBuchState(buchState);
        buchRepository.save(buchToChange);
        return buchToChange;
    }

    public Buch changeStateToVerfuegbar(String buchId) {
        Buch buchToChange = buchRepository.findById(buchId).get();
        BuchState buchState = BuchState.VERFUEGBAR;
        buchToChange.setBuchState(buchState);
        buchRepository.save(buchToChange);
        return buchToChange;
    
    }

    public Buch create(BuchCreateDTO bDTO) {
        Buch bDAO = new Buch(bDTO.getIsbn(), bDTO.getTitel(), bDTO.getKurzfassung() ,bDTO.getAutor(), bDTO.getKategorie());
        return buchRepository.save(bDAO);
    }

    public List<Buch> getAllBuch() {
        return buchRepository.findAll();
    }

    public Buch getBuch(String id) {
        Optional<Buch> optBuch = buchRepository.findById(id);
        if (optBuch.isPresent()) {
            return optBuch.get();
        } else {
            return null;
        }
    }

    public List<BuchStateAggregationDTO> getBuchStateAggregation() {
        return buchRepository.getBuchStateAggregation();
    }

    public List<BuchStudierendeAggregationDTO>  getBuchStudierendeAggregation() {
        return buchRepository.getBuchStudierendeAggregation();
    }
}
