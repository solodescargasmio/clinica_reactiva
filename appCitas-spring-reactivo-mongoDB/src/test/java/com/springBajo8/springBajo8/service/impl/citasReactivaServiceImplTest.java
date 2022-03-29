package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.domain.tratamientosDTO;
import com.springBajo8.springBajo8.domain.medicoDTO;
import com.springBajo8.springBajo8.repository.IcitasReactivaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class citasReactivaServiceImplTest {
    @Mock
    private IcitasReactivaRepository icitasReactivaRepository;

    @InjectMocks
    private citasReactivaServiceImpl citasReactivaService;

    private citasDTOReactiva citasDTO;
    private tratamientosDTO tratDTO=new tratamientosDTO();
    private medicoDTO medico=new medicoDTO();


    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
        List<String> lista=new ArrayList<>();
        lista.add("Tratamiento contra la calicie");
        lista.add("Tratamiento contra vomitos");
        LocalDate fecha=LocalDate.parse("2022-05-16");
        citasDTO = new citasDTOReactiva();
        citasDTO.setId("456887-6");
        citasDTO.setIdPaciente("15");
        citasDTO.setNombrePaciente("Corolina");
        citasDTO.setApellidosPaciente("Piparo");
        citasDTO.setNombreMedico("Julian");
        citasDTO.setApellidosMedico("Lopez");
        citasDTO.setFechaReservaCita(fecha);
        citasDTO.setHoraReservaCita("03:00 pm");
        citasDTO.setEstadoReservaCita("Cita Activa");
        citasDTO.setTratamientos(lista);
    }

    @Test
    void save() {
        Mockito.when(icitasReactivaRepository.save(any(citasDTOReactiva.class))).thenReturn(Mono.just(citasDTO));
        assertNotNull(icitasReactivaRepository.save(citasDTO));
    }

    @Test
    void findByIdPaciente() {
        Mockito.when(icitasReactivaRepository.findById(citasDTO.getIdPaciente())).thenReturn(Mono.just(citasDTO));
        assertNotNull(citasReactivaService.findById(citasDTO.getIdPaciente()));

    }

    @Test
    void findAll() {
        Mockito.when(icitasReactivaRepository.findAll()).thenReturn(Flux.just(citasDTO));
        assertNotNull(citasReactivaService.findAll());
    }

    @Test
    void findById() {
        Mockito.when(icitasReactivaRepository.findById(citasDTO.getId())).thenReturn(Mono.just(citasDTO));
        assertNotNull(citasReactivaService.findById(citasDTO.getId()));
    }

    @Test
    void findByMedico() {
        Mockito.when(icitasReactivaRepository.findByMedico(citasDTO.getId())).thenReturn(Mono.just(medico));
        assertNotNull(citasReactivaService.findByMedico(citasDTO.getId()));
    }

    @Test
    void findByTratamiento() {
        Mockito.when(icitasReactivaRepository.findByTratamiento(citasDTO.getId())).thenReturn(Mono.just(tratDTO));
        assertNotNull(citasReactivaService.findByTratamiento(citasDTO.getId()));
    }

    @Test
    void findByEstadoReservaCita() {
        Mockito.when(icitasReactivaRepository.findByEstadoReservaCita()).thenReturn(Flux.just(citasDTO));
        assertNotNull(citasReactivaService.findByEstadoReservaCita());
    }

    @Test
    void findByhoraReservaCita() {
        String hora="10:00 am";
        Mockito.when(icitasReactivaRepository.findByhoraReservaCita(hora)).thenReturn(Flux.just(citasDTO));
        assertNotNull(citasReactivaService.findByhoraReservaCita(hora));
    }

    @Test
    void findByFechaReservaCita() {
        LocalDate fecha=LocalDate.parse("2022-05-16");
        Mockito.when(icitasReactivaRepository.findByFechaReservaCita(fecha)).thenReturn(Flux.just(citasDTO));
        assertNotNull(citasReactivaService.findByFechaReservaCita(fecha));
    }

    @Test
    void findByFechaHoraReservaCita() {
        String hora="10:00 am";
        LocalDate fecha=LocalDate.parse("2022-05-16");
        Mockito.when(icitasReactivaRepository.findByFechaHoraReservaCita(fecha,hora)).thenReturn(Flux.just(citasDTO));
        assertNotNull(citasReactivaService.findByFechaHoraReservaCita(fecha,hora));
    }
}