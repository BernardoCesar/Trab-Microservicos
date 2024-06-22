package trabalho1.microservices;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class LoginInvalido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private Date dataHora;

    public LoginInvalido() {}

    public LoginInvalido(String username, Date dataHora) {
        this.username = username;
        this.dataHora = dataHora;
    }
}
