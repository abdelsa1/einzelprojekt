package ch.zhaw.einzelprojekt.service;

import ch.zhaw.einzelprojekt.model.Studierende;
import ch.zhaw.einzelprojekt.model.StudierendeCreateDTO;
import ch.zhaw.einzelprojekt.repository.StudierendeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerResponse.Context;

import java.util.List;
import java.util.Optional;

@Service
public class StudierendeService {
    @Autowired
    StudierendeRepository studierendeRepository;

    public Studierende create(StudierendeCreateDTO fDTO) {
        Studierende fDAO = new Studierende(fDTO.getEmail(), fDTO.getImmatrikulationsnummer(),fDTO.getName(),fDTO.getVorname());
        return  studierendeRepository.save(fDAO);
    }

    public List<Studierende> findAll() {
        return studierendeRepository.findAll();
    }

    public Studierende getStudierende(String id) {
        Optional<Studierende> optStudierende = studierendeRepository.findById(id);
        if (optStudierende.isPresent()) {
            return optStudierende.get();
        } else {
            return null;
        }
    }

    public static List<Context> getStudierende() {
        return null;
    }
}
