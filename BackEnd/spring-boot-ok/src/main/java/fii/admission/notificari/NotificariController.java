package fii.admission.notificari;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificariController {
	@RequestMapping(value = "/notificari", method = RequestMethod.GET)
	public ResponseEntity<List<Notificari>> getAllNotificari() {
		List<Notificari> result = NotificariService.getAllNotificari();

		if (result == null)
			return new ResponseEntity<List<Notificari>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Notificari>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/notificari/{userid}", method = RequestMethod.GET)
	public ResponseEntity<Notificari> getNotificari(@PathVariable int userid) {
		Notificari result = NotificariService.getNotificari(userid);

		if (result == null)
			return new ResponseEntity<Notificari>(result, HttpStatus.NOT_FOUND);

		return new ResponseEntity<Notificari>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/notificari/{userid}", method = RequestMethod.POST)
	public ResponseEntity<Integer> updateNotificari(@PathVariable("userid") int userid,
			@RequestBody Notificari notificari) {
		int result = NotificariService.updateNotificari(userid, notificari);
		if (result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/notificari/{userid}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteNotificari(@PathVariable("userid") int userid) {
		int result = NotificariService.deleteNotificari(userid);
		if (result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/notificari", method = RequestMethod.PUT)
	public ResponseEntity<Integer> insertNotificari(@RequestBody Notificari notificari) {
		int result = NotificariService.insertNotificari(notificari);
		if (result == 0)
			return new ResponseEntity<Integer>(result, HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
}
