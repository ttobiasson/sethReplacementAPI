import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Transaction {
    @NotNull
    public String electionName;
    public Main.Action action;

}
