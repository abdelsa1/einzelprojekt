package ch.zhaw.einzelprojekt.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;


    @NoArgsConstructor
    @Getter

    public class BuchStudierendeAggregationDTO {
        private String studierendeId;
        private List<String> buchIds;
    }

