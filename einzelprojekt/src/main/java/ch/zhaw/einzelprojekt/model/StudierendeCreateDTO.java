package ch.zhaw.einzelprojekt.model;

import lombok.Getter; 
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter


public class StudierendeCreateDTO {
   
    private String email;
    private String immatrikulationsnummer;
    private String name;
    private String vorname;
    

}
