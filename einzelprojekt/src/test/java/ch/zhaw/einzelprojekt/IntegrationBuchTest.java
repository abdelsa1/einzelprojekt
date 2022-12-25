package ch.zhaw.einzelprojekt;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EinzelprojektApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationBuchTest {

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void getBuch() throws JSONException{
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:8080/api/buch/637cda749418802c5cd2f235",
                HttpMethod.GET, entity, String.class);

        String expected = "{\"id\":\"637cda749418802c5cd2f235\",\"isbn\":\"978-3-548-60944-7\",\"titel\":\"Sechseläuten\"," +
                "\"autor\":\"Michael Theurillat\",\"kategorie\":\"Krimi\"" +
                ",\"kurzfassung\":\"Mit dem Sechseläuten treibt man in Zürich den Winter aus. Bei diesem offiziellen Anlass wird eine Mitarbeiterin der FIFA niedergestochen - nur unweit von Kommissar Eschenbach. Neben der Leiche steht zitternd ein kleiner Junge. Hat er etwas gesehen? Was für Eschenbach als spontaner Einsatz beginnt, wird zu einer erschütternden Reise in die Vergangenheit.\"" +
                ",\"buchState\":\"AUSGELIEHEN\",\"studierendeId\":\"637cd9b89418802c5cd2f233\"}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }
}
