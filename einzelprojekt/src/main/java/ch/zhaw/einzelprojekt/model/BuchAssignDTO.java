package ch.zhaw.einzelprojekt.model;

import lombok.Getter;

@Getter

public class BuchAssignDTO {
    private String buchId;
    private String studierendeId;
    
    public BuchAssignDTO(String buchId, String studierendeId) {
        this.buchId = buchId;
        this.studierendeId = studierendeId;
    }
    
}
