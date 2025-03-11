package fred.crm.controllers;

import fred.crm.models.Interaction;
import fred.crm.models.dtos.InteractionDTO;
import fred.crm.models.mappers.CreateInteractionMapper;
import fred.crm.models.mappers.InteractionMapper;
import fred.crm.services.InteractionCRUDService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/interactions")
public class InteractionController {
    private InteractionCRUDService interactionCRUDService;
    private InteractionMapper interactionMapper;
    private CreateInteractionMapper createInteractionMapper;

    public InteractionController(InteractionCRUDService interactionCRUDService, InteractionMapper interactionMapper, CreateInteractionMapper createInteractionMapper) {
        this.interactionCRUDService = interactionCRUDService;
        this.interactionMapper = interactionMapper;
        this.createInteractionMapper = createInteractionMapper;
    }

    @GetMapping
    public ResponseEntity<List<InteractionDTO>> getAllInteractions() {
        List<Interaction> interactions = interactionCRUDService.findAll();
        List<InteractionDTO> interactionDTO = new ArrayList<>();

        for (Interaction interaction : interactions) {
            interactionDTO.add(interactionMapper.interactionToInteractionDTO(interaction));
        }

        return ResponseEntity.ok(interactionDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InteractionDTO> getInteractionById(@RequestParam Long id) {
        Interaction interaction = interactionCRUDService.findById(id);
        return ResponseEntity.ok(interactionMapper.interactionToInteractionDTO(interaction));
    }

    @PostMapping
    public ResponseEntity<InteractionDTO> createInteraction(@RequestBody InteractionDTO interactionDTO) {
        Interaction interaction = interactionCRUDService.save(interactionMapper.interactionDTOToInteraction(interactionDTO));
        return new ResponseEntity(interactionMapper.interactionToInteractionDTO(interaction), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InteractionDTO> updateInteraction(@PathVariable Long id, @RequestBody InteractionDTO interactionDTO) {
        Interaction interaction = interactionMapper.interactionDTOToInteraction(interactionDTO);
        interaction.setId(id);
        return new ResponseEntity<>(interactionMapper.interactionToInteractionDTO(interactionCRUDService.save(interaction)), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteInteractionById(@RequestParam Long id) {
        interactionCRUDService.deleteById(id);
        return new ResponseEntity<>("Interaction deleted", HttpStatus.OK);
    }
}
