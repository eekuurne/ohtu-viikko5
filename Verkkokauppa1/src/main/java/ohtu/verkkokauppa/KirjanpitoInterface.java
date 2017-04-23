package ohtu.verkkokauppa;

import java.util.ArrayList;

/**
 *
 * @author eekuurne
 */
public interface KirjanpitoInterface {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
