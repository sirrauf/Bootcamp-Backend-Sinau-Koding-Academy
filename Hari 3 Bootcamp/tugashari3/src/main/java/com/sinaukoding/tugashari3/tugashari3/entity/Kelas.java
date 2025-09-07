package com.sinaukoding.tugashari3.tugashari3.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@EqualsAndHashCode
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_kelas", indexes = {
        @Index(name = "idx_student_created_date", columnList = "createdDate"),
        @Index(name = "idx_student_modified_date", columnList = "modifiedDate")
})
public class Kelas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nama;

    @Column(nullable = false, unique = true)
    private String deskripsi;

    @Column(nullable = false, unique = true)
    private Integer kapasitas;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime modifiedDate;


}
