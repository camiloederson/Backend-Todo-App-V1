package portfolioJAVA.tareasApp.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tareas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime dueDate;
    private String status;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Usuario usuario;
}
