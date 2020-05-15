package hr.zavrsni.pilipovic.recycle.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="schedule")
public class Schedule
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="address")
    private String address;

    private String type;

    @Column(name="day")
    private String day;
    


}