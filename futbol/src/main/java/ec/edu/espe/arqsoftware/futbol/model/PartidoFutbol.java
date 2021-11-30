package ec.edu.espe.arqsoftware.futbol.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "partido_futbol")

public class PartidoFutbol implements Serializable {

    @Id
    @Column(name = "codigo", nullable = false, length = 10)
    private String codigo;
    
    @Column(name = "equipo_local", nullable = false, length = 40)
    private String equipoLocal;
    
    @Column(name = "equipo_visita", nullable = false, length = 40)
    private String equipoVisita;
    
    @Column(name = "fecha", nullable = false, length = 20)
    private Date fecha;
    
    @Column(name = "lugar", nullable = false, length = 40)
    private String lugar;

}
