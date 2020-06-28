package hr.zavrsni.pilipovic.recycle.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AnnouncementCommand implements Serializable {

    private int id;

    @NotBlank
    private String message;

    @NotBlank
    private String title;


    public AnnouncementCommand(String title, String message) {
        this.title = title;
        this.message = message;
    }
}
