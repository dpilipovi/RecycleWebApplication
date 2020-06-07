package hr.zavrsni.pilipovic.recycle.entities;

import hr.zavrsni.pilipovic.recycle.converter.YearMonthIntegerAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.YearMonth;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecycleDTO {

    private int amount;

    @Convert(converter = YearMonthIntegerAttributeConverter.class)
    private YearMonth yearMonth;

    private String type;

}