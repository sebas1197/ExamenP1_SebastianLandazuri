/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arqsoftware.futbol.endpoint;

import ec.edu.espe.arqsoftware.futbol.exception.CreateException;
import ec.edu.espe.arqsoftware.futbol.exception.FoundException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author papic
 */
@Endpoint
@Slf4j
public class PartidoFutbolEndpoint {

    private static final String NAMESPACE_URI = "http://espe.edu.ec/arqsoftware/partido/ws";
    private final PartidoFutbolService service;

    @Autowired

    public PartidoFutbolEndpoint(PartidoFutbolService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "obtenerPartidosDisponiblesRequest")
    @ResponsePayload
    public ObtenerTodasResponse obtenerPartidosDisponibles(@RequestPayload ObtenerPartidosDisponiblesRequest request) {
        List<PartidoFutbol> partidos = this.service.obtenerPartidosDisponibles();
        try {
            List<PartidoFutbolRS> partidoFutbolRS = new ArrayList<>();
            for (PartidoFutbol c : partidos) {
                partidoFutbolRS.add(buildTransformRS(c));
            }

            ObtenerPartidosDisponiblesResponse response = new ObtenerPartidosDisponiblesResponse();
            response.setPartidoFutbolRS(partidoFutbolRS);
            return response;
        } catch (Exception e) {
            String exceptionMessage = e.getMessage();
            log.error("Ocurrio un error. {} - retorna badrequest - causado por: {}", e.getMessage(), exceptionMessage);
            throw new FoundException("Error: " + exceptionMessage);
        }
    }

}
