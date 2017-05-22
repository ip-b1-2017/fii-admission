package fii.admission.statistici;

import fii.admission.users.Email;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cosmin on 5/16/2017.
 */
@RestController
@RequestMapping(value = "/model/statistici")
public class StatisticiController {
    @RequestMapping(value = "/get_statistici_user", method = RequestMethod.POST)
    public ResponseEntity<StatisticiUser> getStatisticiUser(@RequestBody Email email){
        StatisticiUser statistici = new StatisticiUser();
        System.out.println(email.getEmail());
        statistici.setStatusAplicatie(StatisticiService.getStatusAplicatie(email.getEmail()));
        statistici.setNumarAplicanti(StatisticiService.getNumarCandidati(email.getEmail()));
        if(statistici==null){
            return new ResponseEntity<>(statistici, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<StatisticiUser>(statistici, HttpStatus.OK);
        }
    }
    @RequestMapping(value = "/get_statistics_admin", method = RequestMethod.GET)
    public ResponseEntity<AdminStatistics> getStatisticiAdmin(){
        AdminStatistics statistici;
        statistici = StatisticiService.getAdminStatistics();
        System.out.println(statistici.getNrChecked());
        if(statistici==null){
            return new ResponseEntity<>(statistici, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<>(statistici, HttpStatus.OK);
        }
    }
}
