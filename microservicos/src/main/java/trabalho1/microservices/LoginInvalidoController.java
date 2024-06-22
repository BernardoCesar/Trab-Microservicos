package trabalho1.microservices;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logins-invalidos")
public class LoginInvalidoController {

    @Autowired
    private LoginInvalidoRepository repository;

    @PostMapping
    public ResponseEntity<String> registrarLoginInvalido(@RequestParam String username) {
        LoginInvalido novoLoginInvalido = new LoginInvalido(username, new Date());
        repository.save(novoLoginInvalido);
        return new ResponseEntity<>("Login inválido registrado", HttpStatus.CREATED);
    }
}
