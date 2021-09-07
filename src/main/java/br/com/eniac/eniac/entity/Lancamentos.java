package br.com.eniac.eniac.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lancamentos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data = new Date();
    private int dado;
    private boolean jejum;


    public Long existeID(){
        if(this.id == null){
           return Long.valueOf(0);
        }
        return this.id;
    }
}
