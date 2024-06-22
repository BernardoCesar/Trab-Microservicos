package trabalho1.microservices;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends CrudRepository<UsuarioBean, Integer> {

    UsuarioBean findByUsername(String username);

    Iterable<UsuarioBean> findByUsernameAndPassword(String username, String senha);

     UsuarioBean[] findByBlockedTrue();


}
