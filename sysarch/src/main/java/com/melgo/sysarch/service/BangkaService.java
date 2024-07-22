package com.melgo.sysarch.service;

import com.melgo.sysarch.dto.BangkaRequest;
import com.melgo.sysarch.model.Bangka;
import com.melgo.sysarch.repository.BangkaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BangkaService {

    @Autowired
    private BangkaRepository bangkaRepository;

    @Operation(summary = "Add a new Bangka")
    public Bangka addBangka(BangkaRequest request) {
        Bangka bangka = new Bangka();
        bangka.setName(request.getName());
        bangka.setPrice(request.getPrice());
        bangka.setPortArea(request.getPortArea());

        return bangkaRepository.save(bangka);
    }

    @Operation(summary = "Get all Bangkas")
    public List<Bangka> getAllBangkas() {
        return bangkaRepository.findAll();
    }

    @Operation(summary = "Get Bangka by name")
    public Bangka getBangkaByName(String name) throws Exception {
        Optional<Bangka> bangkaOptional = bangkaRepository.findByName(name);
        if (bangkaOptional.isPresent()) {
            return bangkaOptional.get();
        } else {
            throw new Exception("Bangka not found");
        }
    }
}
