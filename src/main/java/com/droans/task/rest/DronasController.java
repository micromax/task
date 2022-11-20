package com.droans.task.rest;

import com.droans.task.domain.Drons;
import com.droans.task.repository.DonsRepository;
import com.droans.task.service.DroansService;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DronasController {

    private  final DroansService droansService;
    private final DonsRepository donsRepository;

    public DronasController(DroansService droansService, DonsRepository donsRepository) {
        this.droansService = droansService;
        this.donsRepository = donsRepository;
    }


    @PostMapping("/droans")
    public ResponseEntity<Drons> createAppUsers(@RequestBody Drons drons) throws URISyntaxException {

        if (drons.getId() != null) {
            throw new RuntimeException("Error massage");
        }
        Drons result = droansService.save(drons);
        return ResponseEntity
                .created(new URI("/api/app-users/" + result.getId()))

                .body(result);
    }


    @GetMapping("/droans")
    public ResponseEntity<List<Drons>> getAllAppUsers(@RequestParam(name = "page") String pageNum) {



        Pageable pageable = PageRequest.of(Integer.parseInt(pageNum), 10);


        Page<Drons> page = droansService.findAll(pageable);

        return ResponseEntity.ok().body(page.getContent());
    }
}
