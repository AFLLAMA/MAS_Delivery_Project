package mas.delivery;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "Administrator")
public class Administrator extends User {

    public Administrator(@NotBlank String username, @NotBlank String password, @NotBlank String name, @NotBlank String surname, @NotBlank LocalDate hire) {
        super(username,password,name,surname,hire);

    }

}
