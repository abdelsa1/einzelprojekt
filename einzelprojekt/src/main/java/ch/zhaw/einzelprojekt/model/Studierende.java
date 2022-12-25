package ch.zhaw.einzelprojekt.model;

import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document; 

import lombok.NonNull; 
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Getter; 
import lombok.NoArgsConstructor; 


@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Document("Studierende")
public class Studierende {
    @Id
    private String id;
    @NonNull
    private String email;
    @NonNull
    private String immatrikulationsnummer;
    @NonNull
    private String name;
    @NonNull
    private String vorname;
}
