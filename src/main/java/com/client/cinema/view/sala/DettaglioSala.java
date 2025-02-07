package com.client.cinema.view.sala;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class DettaglioSala {
    @Schema(description = "Identificativo univoco", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull
    private Long id;

    @Schema(description = "Nome univoco della sala", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sala Uno")
    @NotNull
    private String nomeSala;

    @Schema(description = "Capacità massima di posti disponibili", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull
    private Integer numeroMassimoPosti;

    @Schema(description = "Numero di posti presenti in ogni fila", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull
    private Integer postiPerFila;

    @Schema(description = "Numero totale di file", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull
    private Integer numeroFile;
}
