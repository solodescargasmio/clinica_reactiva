package com.springBajo8.springBajo8.web;


import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.domain.medicoDTO;
import com.springBajo8.springBajo8.domain.tratamientosDTO;
import com.springBajo8.springBajo8.service.IcitasReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class citasReactivaResource {

    @Autowired
    private IcitasReactivaService icitasReactivaService;

    @PostMapping("/citasReactivas")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<citasDTOReactiva> save(@RequestBody citasDTOReactiva citasDTOReactiva) {
        System.out.println(citasDTOReactiva.getTratamientos());
        return this.icitasReactivaService.save(citasDTOReactiva);
    }

    @DeleteMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<citasDTOReactiva>> delete(@PathVariable("id") String id) {
        return this.icitasReactivaService.delete(id)
                .flatMap(citasDTOReactiva -> Mono.just(ResponseEntity.ok(citasDTOReactiva)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<citasDTOReactiva>> update(@PathVariable("id") String id, @RequestBody citasDTOReactiva citasDTOReactiva) {
        System.out.println("/citasReactivas/{id}");
        return this.icitasReactivaService.update(id, citasDTOReactiva)
                .flatMap(citasDTOReactiva1 -> Mono.just(ResponseEntity.ok(citasDTOReactiva1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }
    @PutMapping("/citasReactivas/{id}/{}")
    private Mono<ResponseEntity<citasDTOReactiva>> updateCancelado(@PathVariable("id") String id, @RequestBody citasDTOReactiva citasDTOReactiva) {
        System.out.println("/citasReactivas/{id}/{}");
        return this.icitasReactivaService.update(id, citasDTOReactiva)
                .flatMap(citasDTOReactiva1 -> Mono.just(ResponseEntity.ok(citasDTOReactiva1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping("/citasReactivas/{idPaciente}/byidPaciente")
    private Flux<citasDTOReactiva> findAllByidPaciente(@PathVariable("idPaciente") String idPaciente) {
        return this.icitasReactivaService.findByIdPaciente(idPaciente);
    }

    @GetMapping(value = "/citasReactivas")
    private Flux<citasDTOReactiva> findAll() {
        return this.icitasReactivaService.findAll();
    }
    @GetMapping(value = "/cancelado")
    private Flux<citasDTOReactiva> findCancelados() {
        return this.icitasReactivaService.findByEstadoReservaCita();
    }
    @GetMapping("/citasReactivas/fecha/{fecha}")
    private Flux<citasDTOReactiva> findFechaHora(@PathVariable("fecha") String fecha) {
        System.out.println("Dentro de Resource"+fecha);
        return this.icitasReactivaService.findByFechaReservaCita(fecha);
    }
    @GetMapping(value = "/citasReactivas/medico/{idPaciente}")
    private Mono<medicoDTO> findByMedico(@PathVariable("idPaciente") String idPaciente) {
        return this.icitasReactivaService.findByMedico(idPaciente);
    }
    @GetMapping(value = "/citasReactivas/tratamiento/{idPaciente}")
    private Mono<tratamientosDTO> findByTratamiento(@PathVariable("idPaciente") String idPaciente) {
        return this.icitasReactivaService.findByTratamiento(idPaciente);
    }

}
