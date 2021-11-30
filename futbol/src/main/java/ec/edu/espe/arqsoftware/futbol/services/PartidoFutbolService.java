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
package ec.edu.espe.arqsoftware.futbol.services;

import ec.edu.espe.arqsoftware.futbol.dao.PartidoFutbolRepository;
import ec.edu.espe.arqsoftware.futbol.exception.CreateException;
import ec.edu.espe.arqsoftware.futbol.exception.FoundException;
import ec.edu.espe.arqsoftware.futbol.model.PartidoFutbol;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PartidoFutbolService {

    private final PartidoFutbolRepository partidoFutbolRepo;


    public PartidoFutbolService(PartidoFutbolRepository partidoFutbolRepo) {
        this.partidoFutbolRepo = partidoFutbolRepo;
    }

    public List<PartidoFutbol> obtenerPartidoFutbol() {
        return this.partidoFutbolRepo.findAll();
    }

    
}
