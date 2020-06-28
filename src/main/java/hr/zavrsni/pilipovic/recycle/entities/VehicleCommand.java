package hr.zavrsni.pilipovic.recycle.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VehicleCommand {

    @NotNull(message="Id must not be null")
    private long id;
    @NotBlank(message = "Brand must not be blank!")
    private String brand;
    @NotNull(message = "Registration must not be null!")
    private int firstRegistrationYear;

    public VehicleCommand(String brand, int firstRegistrationYear)
    {
        this.brand = brand;
        this.firstRegistrationYear = firstRegistrationYear;
    }

}
