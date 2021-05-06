package StructuralsPatterns.Adapter;

import StructuralsPatterns.Adapter.AdvancedPayGate.AdvancedPayGate;
import StructuralsPatterns.Adapter.AdvancedPayGate.AdvancedPayGateAdapter;
import StructuralsPatterns.Adapter.PaymentGate.PaymentGate;
import StructuralsPatterns.Adapter.PaymentGate.PaymentGateImpl;

public class AdapterPatternsMain {
    public static void main(String[] args) {
        PaymentGate paymentGate = new PaymentGateImpl();

        AdvancedPayGate advancedPayGate = new AdvancedPayGateAdapter(paymentGate);
        advancedPayGate.makePay();
    }
}
