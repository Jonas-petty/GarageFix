package com.jonas.project.garagefix.entity.repair;

import com.jonas.project.garagefix.entity.IdNotFoundException;
import com.jonas.project.garagefix.repository.ClientRepository;
import com.jonas.project.garagefix.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairManager {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RepairRepository repairRepository;

    public RepairDetailsData create(NewRepairData data) {
        if (!clientRepository.existsById(data.clientId())) {
            throw new IdNotFoundException("Client Id does not exits");
        }

        var client = clientRepository.getReferenceById(data.clientId());
        var repair = new Repair(null, client, data.productKind(), data.problemDescription(), data.price(), true, null);
        repairRepository.save(repair);
        repairRepository.flush();

        return new RepairDetailsData(repair);
    }

    public RepairDetailsData update(UpdateRepairData data) {
        var repair = repairRepository.getReferenceById(data.id());

        if (data.clientId() != null) {
            repair.setClient(clientRepository.getReferenceById(data.clientId()));
        }

        if (data.productKind() != null) {
            repair.setProductKind(data.productKind());
        }

        if (data.problemDescription() != null) {
            repair.setProblemDescription(data.problemDescription());
        }

        if (data.price() != null) {
            repair.setPrice(data.price());
        }

        return new RepairDetailsData(repair);
    }
}
