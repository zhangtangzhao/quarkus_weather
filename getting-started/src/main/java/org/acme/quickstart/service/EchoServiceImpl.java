package org.acme.quickstart.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

@ApplicationScoped
@Default
public class EchoServiceImpl implements EchoService{

    @Override
    public String echo(String name) {
        return name;
    }
}
