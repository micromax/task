package com.droans.task.rest;

import com.droans.task.domain.Drons;
import com.droans.task.domain.enumModels.State;
import com.droans.task.repository.DonsRepository;
import com.droans.task.service.DroansService;
import com.droans.task.utile.ResponseUtil;
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
import java.util.Optional;

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
    public ResponseEntity<Drons> create(@RequestBody Drons drons) throws URISyntaxException {


        System.out.println(drons.toString());
        if (drons.getId() != null) {
            throw new RuntimeException("Error massage");
        }
        Drons result = droansService.save(drons);
        return ResponseEntity
                .created(new URI("/api/app-users/" + result.getId()))

                .body(result);
    }


    @GetMapping("/droans")
    public ResponseEntity<List<Drons>> getAll(@RequestParam(name = "page") String pageNum) {



        Pageable pageable = PageRequest.of(Integer.parseInt(pageNum), 10);


        Page<Drons> page = droansService.findAll(pageable);

        return ResponseEntity.ok().body(page.getContent());
    }



    @GetMapping("/droans-avalible")
    public ResponseEntity<List<Drons>> getAllAvalible(@RequestParam(name = "page") String pageNum) {



        Pageable pageable = PageRequest.of(Integer.parseInt(pageNum), 10);


        Page<Drons> page = droansService.findAllByStatus(State.IDLE,pageable);

        return ResponseEntity.ok().body(page.getContent());
    }



    @GetMapping("/droans/{id}")
    public ResponseEntity<Drons> getDroan(@PathVariable Long id) {

        Optional<Drons> dron = droansService.findOne(id);

        return ResponseUtil.wrapOrNotFound(dron);
    }


    @DeleteMapping("/droans/{id}")
    public ResponseEntity<Void> deleteDroan(@PathVariable Long id) {

        droansService.delete(id);
        return ResponseEntity
              .noContent()
              .build();
    }
}
