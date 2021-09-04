package br.com.eniac.eniac.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lancamentos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private Date data = new Date();
    private int dado;
    private boolean jejum;
}
