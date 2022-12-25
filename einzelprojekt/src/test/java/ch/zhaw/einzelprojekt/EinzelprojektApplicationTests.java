package ch.zhaw.einzelprojekt;

import ch.zhaw.einzelprojekt.model.Buch;
import ch.zhaw.einzelprojekt.model.BuchState;
import ch.zhaw.einzelprojekt.service.BuchService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EinzelprojektApplicationTests {

	@Autowired
	BuchService buchService;
	@Test
	void contextLoads() {
	}

	@Test
	void buchChangeState() {
		Buch buch = buchService.changeStateToAusgeliehen("637cda749418802c5cd2f235");
		Assertions.assertEquals(BuchState.AUSGELIEHEN, buch.getBuchState());
	}

}
