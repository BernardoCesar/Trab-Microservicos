package trabalho1.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class KafkaLoginInvalidoConsumer {

    @Autowired
    private LoginInvalidoRepository repository;

    @KafkaListener(topics = "logins-invalidos", groupId = "login-invalido-group")
    public void consume(String username) {
        LoginInvalido novoLoginInvalido = new LoginInvalido(username, new Date());
        repository.save(novoLoginInvalido);
    }
}
