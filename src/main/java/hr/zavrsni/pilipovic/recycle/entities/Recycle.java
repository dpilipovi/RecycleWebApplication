package hr.zavrsni.pilipovic.recycle.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.YearMonth;
import java.util.List;
//import javax.persistence.EmbeddedId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="recycle")
public class Recycle {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="amount")
    private int amount;

    @Column(name = "year_month",
            columnDefinition = "mediumint")
    @Convert(
            converter = YearMonthIntegerAttributeConverter.class
    )
    private YearMonth yearMonth;

    @Column(name="type")
    private String type;


   
}