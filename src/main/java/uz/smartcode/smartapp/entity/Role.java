package uz.smartcode.smartapp.entity;

import lombok.*;
import uz.smartcode.smartapp.entity.enums.RoleName;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "name", unique = true)
    private RoleName name;
}
