package sg.edu.ntu.simple_crm;

import java.util.ArrayList;

public interface InteractionService {
    Interaction createInteraction(Interaction interaction);

    Interaction getInteraction(Long id);

    public ArrayList<Interaction> getAllInteraction();

    public Interaction updateInteraction(Long id, Interaction interaction);

    public void deleteInteraction(Long id);
}
