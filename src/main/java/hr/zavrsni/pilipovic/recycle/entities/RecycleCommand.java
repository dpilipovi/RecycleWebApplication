package hr.zavrsni.pilipovic.recycle.entities;

import hr.zavrsni.pilipovic.recycle.converter.YearMonthIntegerAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.YearMonth;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecycleCommand   implements Serializable {

    private long id;

    @NotNull(message = "Amount must not be null")
    private int amount;

    @NotNull(message = "YearMonth must not be null")
    @Convert(converter = YearMonthIntegerAttributeConverter.class)
    private YearMonth yearMonth;

    @NotBlank(message = "Type must not be empty")
    private String type;


}