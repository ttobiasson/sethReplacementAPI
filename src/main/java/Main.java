import org.rapidoid.annotation.Valid;
import org.rapidoid.config.ConfigImpl;
import org.rapidoid.jpa.JPA;
import org.rapidoid.setup.App;
import org.rapidoid.setup.AppBootstrap;
import org.rapidoid.setup.On;
import org.rapidoid.config.ConfigImpl;
import sawtooth.sdk.protobuf.BatchList;
import sawtooth.sdk.protobuf.BatchHeader;
import sawtooth.sdk.protobuf.Transaction;
import sawtooth.sdk.signing.PrivateKey;
import sawtooth.sdk.signing.Secp256k1Context;
import sawtooth.sdk.signing.Signer;

public class Main {

    public enum Action{
        AddCandidate,
        getVoteCount,
        Vote
    }

    public static void main(String[] args) {

        App.bootstrap(args);

        Handler handler = new Handler();
        TransactionBuilder transactionBuilder = new TransactionBuilder();

        On.post("/vote").json(() -> (transactionBuilder));
        On.post("/candidate").json(() -> (transactionBuilder));

        On.get("/candidates").json(() ->  handler.getCandidates());
        On.get("/votecount").json(() -> handler.getVoteCount());
        On.get("/totalvotes").json(() -> handler.getTotalVotes());
        On.get("/key").json(() -> handler.getKey());

    }

}