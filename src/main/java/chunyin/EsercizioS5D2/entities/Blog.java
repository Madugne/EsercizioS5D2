package chunyin.EsercizioS5D2.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Blog {
    private long id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private double tempoDiLettura;
}
