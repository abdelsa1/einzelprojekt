package ch.zhaw.einzelprojekt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.einzelprojekt.model.Buch;
import ch.zhaw.einzelprojekt.model.BuchStateAggregationDTO;
import ch.zhaw.einzelprojekt.model.BuchStudierendeAggregationDTO;

public interface BuchRepository extends MongoRepository <Buch, String> {
   
    @Aggregation("{$group: {_id: '$buchState',buchIds: {$push: '$_id'},count: {$count: {}}}}")
    List<BuchStateAggregationDTO> getBuchStateAggregation();

    @Aggregation("{$group: {_id: '$studierendeId',buchIds: {$push: '$_id'}}}")
    List<BuchStudierendeAggregationDTO> getBuchStudierendeAggregation();


}
