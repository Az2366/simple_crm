package sg.edu.ntu.simple_crm;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {
    private CustomerRepository customerRepository;
    // private InteractionRepository interactionRepository;

    public DataLoader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // public DataLoader(InteractionRepository interactionRepository) {
    // this.interactionRepository = interactionRepository;
    // }

    @PostConstruct
    public void loadData() {
        customerRepository.deleteAll();

        // Load data
        customerRepository.save(new Customer("AA", "BB"));
        customerRepository.save(new Customer("CC", "DD"));
        customerRepository.save(new Customer("EE", "FF"));
        customerRepository.save(new Customer("GG", "HH"));
        // interactionRepository.save("hi");
    }
}
