package ohtu.verkkokauppa;

/**
 *
 * @author eekuurne
 */
public interface VarastoInterface {

    Tuote haeTuote(int id);

    void otaVarastosta(Tuote t);

    void palautaVarastoon(Tuote t);

    int saldo(int id);
    
}
