package ru.itpark.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "brs_group")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public void update(Group group) {
        group.setName(this.name);
    }
}
