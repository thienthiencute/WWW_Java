package fit.iuh.thanhoangthienthien_tuan07.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;

@Entity
@Table(name = "comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 300)
    private String text;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
