/*
 * Copyright (c) 2021 mafer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package ec.edu.espe.arqsoftware.futbolrest.transform;

import ec.edu.espe.arqsoftware.futbolrest.dto.PartidoFutbolRS;
import ec.edu.espe.arqsoftware.futbolrest.model.PartidoFutbol;

public class PartidoFutbolRSTransform {
    public static PartidoFutbolRS buildPartidoFutbolTransformRS(PartidoFutbol partidoFutbol){
        return PartidoFutbolRS.builder()
                .codigo(partidoFutbol.getCodigo())
                .equipoLocal(partidoFutbol.getEquipoLocal())
                .equipoVisita(partidoFutbol.getEquipoVisita())
                .fecha(partidoFutbol.getFecha())
                .lugar(partidoFutbol.getLugar())
                .build();
    }
}
