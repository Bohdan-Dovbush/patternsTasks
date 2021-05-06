package StructuralsPatterns.Adapter.AdvancedPayGate;

import GeneratingsPatterns.Role.Role;
import StructuralsPatterns.Adapter.PaymentGate.PaymentGate;

@SuppressWarnings("ALL")
public class AdvancedPayGateAdapter implements AdvancedPayGate {

    private final PaymentGate paymentGate;
    public AdvancedPayGateAdapter(PaymentGate paymentGate) {
        this.paymentGate = paymentGate;
    }
    public void makePay() {
        Role user = null;
        Role admin = null;
        paymentGate.doPay();
        }
}
