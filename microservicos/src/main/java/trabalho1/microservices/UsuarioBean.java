package trabalho1.microservices;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "UserTable")
public class UsuarioBean {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "userId")
  private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  private String username;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  private Integer totalLogins;

  public Integer getTotalLogins() {
    return totalLogins;
  }

  public void setTotalLogins(Integer total_logins) {
    this.totalLogins = total_logins;
  }

  private Integer totalFails;

  public Integer getTotalFails() {
    return totalFails;
  }

  public void setTotalFails(Integer total_falhas) {
    this.totalFails = total_falhas;
  }

  private boolean blocked;

  public boolean isBlocked() {
    return blocked;
  }

  public void setBlocked(boolean blocked) {
    this.blocked = blocked;
  }
}
