/*
 * Copyright (c) 2021 mafer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    mafer - initial API and implementation and/or initial documentation
 */
package ec.edu.espe.arqsoftware.futbolrest.controller;

import ec.edu.espe.arqsoftware.futbolrest.dto.PartidoFutbolRS;
import ec.edu.espe.arqsoftware.futbolrest.dto.PartidoFutbolRQ;
import ec.edu.espe.arqsoftware.futbolrest.dto.Serializador;
import ec.edu.espe.arqsoftware.futbolrest.exception.FoundException;
import ec.edu.espe.arqsoftware.futbolrest.model.PartidoFutbol;
import ec.edu.espe.arqsoftware.futbolrest.service.PartidoFutbolService;
import static ec.edu.espe.arqsoftware.futbolrest.transform.PartidoFutbolRSTransform.buildPartidoFutbolTransformRS;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partidofutbol")
@Slf4j
public class PartidoFutbolController {

    private final PartidoFutbolService service;

    public PartidoFutbolController(PartidoFutbolService service) {
        this.service = service;
    }

    @GetMapping(value = "/partidosfecha")
    public ResponseEntity obtenerPartidosDisponibles() {
        List<PartidoFutbol> partidos = this.service.obtenerPartidosDisponibles();
        try {
            List<PartidoFutbolRS> futbolRSs = new ArrayList<>();
            for (PartidoFutbol c : partidos) {
                PartidoFutbolRS.add(buildPartidoFutbolTransformRS(c));
            }

            return ResponseEntity.ok(PartidoFutbolRS);
        } catch (Exception e) {
            return Serializador.Error(e, "Error, no se encontró ningun partido");
        }
    }
}
