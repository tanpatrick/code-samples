package incognitos.training.sample;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Address {

    private static final Logger LOGGER = Logger.getLogger(Address.class);
    private String address;
    private String zipCode;

    public Address() {
        LOGGER.info("INIT: Address()");
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
