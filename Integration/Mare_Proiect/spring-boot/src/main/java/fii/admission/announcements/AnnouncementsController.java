package fii.admission.announcements;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cosmin on 6/12/2017.
 */
@RestController
@RequestMapping(value="/model")
public class AnnouncementsController {
    @RequestMapping(value = "/announcements", method = RequestMethod.GET)
    public ResponseEntity<List<Announcement>>getAllFollowingUsers(
            @RequestParam(name = "seek", required = false) Integer seek,
            @RequestParam(name = "limit") Integer limit){
        if(limit == null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if(seek == null){
            return new ResponseEntity<List<Announcement>>(AnnouncementsService.getAnnouncements(limit),HttpStatus.OK);
        }
        return new ResponseEntity<List<Announcement>>(AnnouncementsService.getAnnouncements(seek,limit),HttpStatus.OK);
    }

    @RequestMapping(value="/announcements/save",method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Announcement announcement){
      return new ResponseEntity(AnnouncementsService.save(announcement.getTitle(),announcement.getText()));
    }
    @RequestMapping(value="/announcements/update/{id}",method = RequestMethod.POST)
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody Announcement announcement){
        return new ResponseEntity(AnnouncementsService.update(id, announcement.getTitle(),announcement.getText()));
    }
    @RequestMapping(value="/announcements/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity delete(@PathVariable("id") int id){
        return new ResponseEntity(AnnouncementsService.delete(id));
    }

}
