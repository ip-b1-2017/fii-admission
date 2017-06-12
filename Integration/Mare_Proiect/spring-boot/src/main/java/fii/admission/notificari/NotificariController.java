package fii.admission.notificari;

import fii.admission.DTO.SuccessEntity;
import fii.admission.users.Success;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RequestMapping(value = "/model")
@RestController
public class NotificariController {
    @RequestMapping(value = "/notificari", method = RequestMethod.GET)
    public ResponseEntity<List<Notificari>> getAllNotificari() {
        List<Notificari> result = NotificariService.getAllNotificari();

        if (result == null)
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/notificari/{useremail}", method = RequestMethod.GET)
    public ResponseEntity<List<Notificari>> getNotificari(@PathVariable String useremail) {
        useremail = new String(Base64.getDecoder().decode(useremail));
        List<Notificari> result = NotificariService.getNotificari(useremail);

        if (result == null)
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //Edi: Am scos Update pe notificari fiindca pot fi mai multe notificari pe acelasi user si (inca) nu avem un id.
    //     Raman notificarile fara id, si se iau in grup.
    //     In plus, am modficat GET-ul sa returneze tot o lista, fiindca ^^^
    //     Sincer nu cred ca trebuie schimbat, e okay, oricum astea sunt in bulk si le vezi pe toate odata.

    @RequestMapping(value = "/notificari/{useremail}", method = RequestMethod.DELETE)
    public ResponseEntity<SuccessEntity> deleteNotificari(@PathVariable("useremail") String useremail) {
        useremail = new String(Base64.getDecoder().decode(useremail));

        int result = NotificariService.deleteNotificari(useremail);
        if (result == 0) {
            //Nu-i bug daca incerci sa stergi notificari de la un user care nu are notificari zic eu
            return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/notificari", method = RequestMethod.POST)
    public ResponseEntity<SuccessEntity> insertNotificari(@RequestBody Notificari notificari) {
        int result = NotificariService.insertNotificari(notificari);
        if (result == 0) {
            return new ResponseEntity<>(new SuccessEntity(false), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(new SuccessEntity(true), HttpStatus.OK);
        }
    }
}
