package com.client.cinema.controller;

import com.client.cinema.service.SalaService;
import com.client.cinema.view.sala.DettaglioSala;
import com.client.cinema.view.sala.ModificaSala;
import com.client.cinema.view.sala.NuovaSala;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("config/sala")
@Tag(name = "Sale", description = "Gestione delle sale cinematografiche")
@Validated
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @Operation(
            summary = "Creazione di una nuova Sala",
            description = "Censimento di una nuova sala del cinema; il campo numeroMassimoPosti è calcolato in automatico, se non inserito dall'utente. Gli altri campi sono obbligatori"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Nuova sala configurata con successo",
                    content = @Content(schema = @Schema(implementation = DettaglioSala.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dati in formato non valido"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Risorsa non trovata"
            )
    })
    @PostMapping(value = "/add-new")
    public ResponseEntity<DettaglioSala> createNewSala(@RequestBody(description = "Dettagli della nuova sala", required = true)
                                                                        @Valid
                                                                        @org.springframework.web.bind.annotation.RequestBody NuovaSala nuovaSala) {
        return ResponseEntity.status(HttpStatus.CREATED).body(salaService.registraNuovaSala(nuovaSala));
    }

    @Operation(
            summary = "Modifica la configurazione di una Sala",
            description = "Cambia la configurazione strutturale di una Sala, per esempio diminuire il numero di posti massimi disponibili, o cambiarle il nome"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Modifica effettuata con successo",
                    content = @Content(schema = @Schema(implementation = DettaglioSala.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dati in formato non valido"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Risorsa non trovata"
            )
    })
    @PutMapping(value = "/update/{salaId}")
    public ResponseEntity<DettaglioSala> updateExistingSala(@PathVariable Long salaId,
                                                            @RequestBody(description = "Dettagli della Sala da modificare", required = true)
                                                            @Valid
                                                            @org.springframework.web.bind.annotation.RequestBody ModificaSala modificaSala) {
        return ResponseEntity.status(HttpStatus.OK).body(salaService.modificaSalaEsistente(salaId, modificaSala));
    }

    @Operation(
            summary = "Visualizzazione Sala",
            description = "Visualizza la configurazione completa di una Sala"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Oggetto visualizzato con successo",
                    content = @Content(schema = @Schema(implementation = DettaglioSala.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Parametro sbagliato"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Risorsa non trovata"
            )
    })
    @GetMapping("/single-record/{salaId}")
    public ResponseEntity<DettaglioSala> getSingleSalaDetail(@PathVariable Long salaId) {
        return ResponseEntity.status(HttpStatus.OK).body(salaService.visualizzaSingolaSala(salaId));
    }
}
