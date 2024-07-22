package com.melgo.sysarch.controller;

import com.melgo.sysarch.dto.BangkaRequest;
import com.melgo.sysarch.model.Bangka;
import com.melgo.sysarch.service.BangkaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bangkas")
public class BangkaController {

    @Autowired
    private BangkaService bangkaService;

    @Operation(summary = "Add a new Bangka")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Bangka created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<Bangka> addBangka(@RequestBody BangkaRequest request) {
        try {
            Bangka bangka = bangkaService.addBangka(request);
            return ResponseEntity.status(201).body(bangka);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Operation(summary = "Get all Bangkas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of Bangkas retrieved successfully")
    })
    @GetMapping
    public ResponseEntity<List<Bangka>> getAllBangkas() {
        try {
            List<Bangka> bangkas = bangkaService.getAllBangkas();
            return ResponseEntity.ok(bangkas);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @Operation(summary = "Get Bangka by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bangka retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Bangka not found")
    })
    @GetMapping("/{name}")
    public ResponseEntity<Bangka> getBangkaByName(@PathVariable String name) {
        try {
            Bangka bangka = bangkaService.getBangkaByName(name);
            return ResponseEntity.ok(bangka);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
