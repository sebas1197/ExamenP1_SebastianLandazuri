/*
 * Copyright (c) 2021 mafer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package ec.edu.espe.arqsoftware.futbol.transform;


import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class PartidoFutbolRSTransform {
    
    public static PartidoFutbolRS buildPartidoFutbolTransformRS(PartidoFutbol partidoFutbol) throws DatatypeConfigurationException {
        XMLGregorianCalendar fechaInicio;
        if (partidoFutbol.getFecha() != null) {
            fechaInicio = DatatypeFactory.newInstance().newXMLGregorianCalendar(partidoFutbol.getFecha().toString());
        } else {
            fechaInicio = null;
        }
        
        return PartidoFutbolRS.builder()
                .codigo(partidoFutbol.getCodigo())
                .equipoLocal(partidoFutbol.getEquipoLocal())
                .equipoVisita(partidoFutbol.getEquipoVisita())
                .fecha(partidoFutbol.getFecha())
                .lugar(partidoFutbol.getLugar())
                .build();
    }
}
