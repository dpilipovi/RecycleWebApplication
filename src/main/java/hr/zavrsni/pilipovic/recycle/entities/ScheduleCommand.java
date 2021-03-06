package hr.zavrsni.pilipovic.recycle.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ScheduleCommand  implements Serializable
{

    @NotNull(message="Id must not be null")
    private long id;
    @NotBlank(message = "Address must not be empty")
    private String address;
    @NotBlank(message = "Type must not be empty")
    private String type;
    @NotNull(message = "Day must not be null")
    private int day;

    public ScheduleCommand(String address, String type, int day)
    {
        this.address = address;
        this.type = type;
        this.day = day;
    }

}