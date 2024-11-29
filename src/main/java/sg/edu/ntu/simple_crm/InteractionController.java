package sg.edu.ntu.simple_crm;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interaction")
public class InteractionController {
    private InteractionService interactionService;

    public InteractionController(@Qualifier("interactionServiceImpl") InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @PostMapping("")
    public ResponseEntity<Interaction> createInteraction(@RequestBody Interaction interaction) {
        Interaction newInteraction = interactionService.createInteraction(interaction);
        return new ResponseEntity<>(newInteraction, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<Interaction>> getAllInteraction() {
        ArrayList<Interaction> allInteraction = interactionService.getAllInteraction();
        return new ResponseEntity<>(allInteraction, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interaction> getInteraction(@PathVariable Long id) {
        Interaction foundInteraction = interactionService.getInteraction(id);
        return new ResponseEntity<>(foundInteraction, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Interaction> updateInteraction(@PathVariable Long id, @RequestBody Interaction interaction) {
        Interaction updatedInteraction = interactionService.updateInteraction(id, interaction);
        return new ResponseEntity<>(updatedInteraction, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteInteraction(@PathVariable Long id) {
        interactionService.deleteInteraction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
