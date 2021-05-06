package StructuralsPatterns.Facade;

import StructuralsPatterns.Facade.Service.ClientServiceFacade;
import StructuralsPatterns.Facade.Service.ClientServiceFacadeImpl;

public class FacadePatternsMain {
    public static void main(String[] args) {
        ClientServiceFacade serviceFacade = new ClientServiceFacadeImpl();
        serviceFacade.moneyTransfer();
    }
}
