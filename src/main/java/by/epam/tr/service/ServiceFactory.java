package by.epam.tr.service;

import by.epam.tr.service.impl.ServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceImpl service = new ServiceImpl();

    private ServiceFactory(){
    }
    public static ServiceFactory getInstance(){
        return instance;
    }

    public Service getService() {
        return service;
    }
}
