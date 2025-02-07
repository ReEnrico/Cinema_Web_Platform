package com.client.cinema.service;

import com.client.cinema.model.Sala;
import com.client.cinema.view.sala.DettaglioSala;
import com.client.cinema.view.sala.ModificaSala;
import com.client.cinema.view.sala.NuovaSala;
import jakarta.validation.ConstraintViolationException;

public interface SalaService extends BaseService<Sala, Long>{

    ///  Registra una nuova sala a partire dai dati forniti.
    ///  <p>
    ///  Il metodo esegue le seguenti operazioni:
    ///  <ul>
    ///  <li>Converte l'oggetto {@code NuovaSala} in un'entità {@code Sala} tramite {@code SalaConverter.nuovaSalaToEntity}.</li>
    ///  <li>Salva l'entità utilizzando il metodo {@code createOrUpdate} della classe base.</li>
    ///  <li>Converte l'entità salvata in un oggetto {@code DettaglioSala} tramite {@code SalaConverter.entityToDettaglioSala}.</li>
    ///  </ul>
    ///  </p>
    ///  @param nuovaSala l'istanza di {@code NuovaSala} contenente i dati della sala da registrare
    ///  @return un oggetto {@code DettaglioSala} che rappresenta i dettagli della sala registrata
    ///  @throws RuntimeException se si verifica una {@link ConstraintViolationException} durante il salvataggio,
    ///                            ad esempio in caso di violazione dei vincoli di unicità
    DettaglioSala registraNuovaSala(NuovaSala nuovaSala);

    /**
     * Modifies an existing Sala.
     *
     * <p>This method retrieves a Sala from the database using the provided <code>sala_id</code>. If the Sala exists,
     * its properties are updated with the values supplied in the <code>ModificaSala</code> DTO. Specifically, the
     * following attributes are updated: <code>nomeSala</code>, <code>numeroMassimoPosti</code>, <code>postiPerFila</code>,
     * and <code>numeroFile</code>. After updating, the Sala is saved (using <code>createOrUpdate</code>) and then converted
     * into a <code>DettaglioSala</code> DTO via the <code>SalaConverter</code>, which is returned as the result.</p>
     *
     * @param salaId      the identifier of the Sala to be modified
     * @param modificaSala the DTO containing the new values for the Sala
     * @return a <code>DettaglioSala</code> DTO representing the updated Sala
     * @throws RuntimeException if no Sala is found with the specified <code>sala_id</code>
     */
    DettaglioSala modificaSalaEsistente(Long salaId, ModificaSala modificaSala);

    /**
     * Retrieves and returns the details of a single Sala.
     *
     * <p>This method attempts to fetch a Sala entity from the database using the provided <code>salaId</code>.
     * If the Sala is found, it is converted into a <code>DettaglioSala</code> DTO via the
     * <code>SalaConverter.entityToDettaglioSala</code> method and returned. If the Sala is not found,
     * a <code>RuntimeException</code> is thrown.</p>
     *
     * @param salaId the unique identifier of the Sala to be retrieved
     * @return a <code>DettaglioSala</code> DTO representing the found Sala
     * @throws RuntimeException if no Sala exists with the specified <code>salaId</code>
     */
    DettaglioSala visualizzaSingolaSala(Long salaId);
}
