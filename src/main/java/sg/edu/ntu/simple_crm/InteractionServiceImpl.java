package sg.edu.ntu.simple_crm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class InteractionServiceImpl implements InteractionService {

    private InteractionRepository interactionRepository;

    public InteractionServiceImpl(InteractionRepository interactionRepository) {
        this.interactionRepository = interactionRepository;
    }

    @Override
    public Interaction createInteraction(Interaction interaction) {
        Interaction newInteraction = interactionRepository.save(interaction);
        return newInteraction;
    }

    @Override
    public Interaction getInteraction(Long id) {
        Interaction foundCustomer = interactionRepository.findById(id).get();
        return foundCustomer;
    }

    @Override
    public ArrayList<Interaction> getAllInteraction() {
        ArrayList<Interaction> allInteraction = (ArrayList<Interaction>) interactionRepository.findAll();
        return allInteraction;
    }

    @Override
    public Interaction updateInteraction(Long id, Interaction interaction) {
        Interaction interactionToUpdate = interactionRepository.findById(id).get();
        interactionToUpdate.setRemarks(interaction.getRemarks());
        interactionToUpdate.setInteractionDate(interaction.getInteractionDate());
        return interactionRepository.save(interactionToUpdate);
    }

    @Override
    public void deleteInteraction(Long id) {
        interactionRepository.deleteById(id);
    }
}
