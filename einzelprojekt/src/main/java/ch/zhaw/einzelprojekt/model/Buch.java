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
@Document("Buch")

public class Buch {
    @Id
    private String id;
    @NonNull
    private String isbn;
    @NonNull
    private String titel;
    @NonNull
    private String autor;
    @NonNull
    private String kategorie;
    @NonNull
    private String kurzfassung;
    @NonNull
    private BuchState buchState = BuchState.VERFUEGBAR;
    private String studierendeId;

}
