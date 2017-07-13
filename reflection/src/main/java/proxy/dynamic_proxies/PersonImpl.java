package proxy.dynamic_proxies;

import basics.*;

public class PersonImpl implements Person{
    private String password;


    @Override
    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }

}
