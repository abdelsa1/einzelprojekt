package ch.zhaw.einzelprojekt.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BuchCreateDTO {
    private String isbn;
    private String titel;
    private String autor;
    private String kategorie;
    private String kurzfassung;
}