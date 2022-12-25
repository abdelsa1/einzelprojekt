package ch.zhaw.einzelprojekt.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BuchStateAggregationDTO {
    private String id;
    private List<String> buchIds;
    private String count;
}