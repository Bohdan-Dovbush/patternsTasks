package StructuralsPatterns.Adapter.PaymentGate;

public class PaymentGateImpl implements PaymentGate {
    @Override
    public void doPay() {
        System.out.println("Do payment using Payment Gate");
    }
}
