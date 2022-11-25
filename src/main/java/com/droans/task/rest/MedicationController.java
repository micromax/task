package com.droans.task.rest;



import com.droans.task.domain.Drons;
import com.droans.task.domain.Medication;
import com.droans.task.repository.MedicationRepository;
import com.droans.task.service.MedicationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicationController {

    private  final MedicationService medicationService;
    private final MedicationRepository medicationRepository;

    public MedicationController(MedicationService medicationService, MedicationRepository medicationRepository) {
        this.medicationService = medicationService;
        this.medicationRepository = medicationRepository;
    }



    @PostMapping("/medication")
    public ResponseEntity<Medication> create(@RequestBody Medication medication) throws URISyntaxException {


        System.out.println(medication.toString());
        if (medication.getId() != null) {
            throw new RuntimeException("Error massage");
        }
        Medication result = medicationService.save(medication);
        return ResponseEntity
                .created(new URI("/api/app-users/" + result.getId()))

                .body(result);
    }

    @GetMapping("/medication")
    public ResponseEntity<List<Medication>> getAll(@RequestParam(name = "page" , required = false) String pageNum) {



        if(pageNum == null)
        {
            pageNum = "0";
        }
        Pageable pageable = PageRequest.of(Integer.parseInt(pageNum), 10);


        Page<Medication> page = medicationService.findAll(pageable);

        return ResponseEntity.ok().body(page.getContent());
    }



}
