package custom;

import java.io.Serializable;

public class CreditCard extends CardType implements Serializable {

    @MaskSensitiveData
    private String cvv;

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
