package com.springBajo8.springBajo8.service;


import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.domain.medicoDTO;
import com.springBajo8.springBajo8.domain.tratamientosDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface IcitasReactivaService {
    Mono<citasDTOReactiva> save(citasDTOReactiva citasDTOReactiva);

    Mono<citasDTOReactiva> delete(String id);

    Mono<citasDTOReactiva> update(String id, citasDTOReactiva citasDTOReactiva);

    Flux<citasDTOReactiva> findByIdPaciente(String idPaciente);

    Flux<citasDTOReactiva> findAll();
    Flux<citasDTOReactiva> findByEstadoReservaCita();

    Mono<citasDTOReactiva> findById(String id);

    Mono<medicoDTO> findByMedico(String id);

    Mono<tratamientosDTO> findByTratamiento(String id);
    Flux<citasDTOReactiva> findByFechaReservaCita(LocalDate fecha);
    Flux<citasDTOReactiva> findByFechaHoraReservaCita(LocalDate fecha,String hora);
    Flux<citasDTOReactiva> findByhoraReservaCita(String hora);

}
