package StructuralsPatterns.Facade.Service;

import GeneratingsPatterns.Role.Role;

public class ClientServiceFacadeImpl implements ClientServiceFacade {
    @SuppressWarnings("unused")
    @Override
    public void moneyTransfer() {
        if(PaymentService.doPayment()){
            Role fromRole = RoleService.getRole();
            Role toRole   = RoleService.getRole();
            TransferService.transfer();
        }
    }
}
