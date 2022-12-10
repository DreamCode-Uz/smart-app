package uz.smartcode.smartapp.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "attachment_content")
public class AttachmentContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bytes")
    @Lob
    private byte[] bytes;

    @OneToOne(mappedBy = "content")
    private Attachment attachment;
}
