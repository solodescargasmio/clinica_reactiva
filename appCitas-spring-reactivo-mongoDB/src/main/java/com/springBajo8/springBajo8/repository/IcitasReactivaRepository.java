package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.domain.medicoDTO;
import com.springBajo8.springBajo8.domain.tratamientosDTO;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IcitasReactivaRepository extends ReactiveMongoRepository<citasDTOReactiva, String> {
    Flux<citasDTOReactiva> findByIdPaciente(String idPaciente);

     @Query("{'estadoReservaCita':'Cancelado'}")
    Flux<citasDTOReactiva> findByEstadoReservaCita();

   /* @Query("{'fechaReservaCita':{$regex:'2021-12-30'}}")
    Flux<citasDTOReactiva> findByfechaReservaCita(String fecha);*/


    @Query("{'horaReservaCita':'10:00 am'}")
    Flux<citasDTOReactiva> findByfechaReservaCita(String fecha);

    @Query(value = "{'id':?0}",fields = "{'nombreMedico':1,'apellidosMedico':1}")
    Mono<medicoDTO> findByMedico(String id);

    @Query(value = "{'id':?0}",fields = "{'tratamientos':1}")
    Mono<tratamientosDTO> findByTratamiento(String id);






}
