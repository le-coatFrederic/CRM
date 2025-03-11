package fred.crm.services;

import fred.crm.models.Interaction;
import fred.crm.repositories.InteractionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class InteractionCRUDService {
    @Autowired
    private InteractionRepository interactionRepository;

    public List<Interaction> findAll() { return interactionRepository.findAll(); }
    public Interaction save(Interaction interaction) { return interactionRepository.save(interaction); }
    public Interaction findById(Long id) { return interactionRepository.findById(id).get(); }
    public void delete(Interaction interaction) { interactionRepository.delete(interaction); }
    public void deleteById(Long id) { interactionRepository.deleteById(id); }
}
