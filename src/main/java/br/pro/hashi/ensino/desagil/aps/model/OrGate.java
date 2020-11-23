package br.pro.hashi.ensino.desagil.aps.model;

public class OrGate extends Gate {
    private final NandGate nand1;
    private final NandGate nand2;
    private final NandGate nand3;

    public OrGate() {
        super("OR", 3);

        nand1 = new NandGate();
        nand2 = new NandGate();
        nand3 = new NandGate();

        nand3.connect(0, nand1);
        nand3.connect(1, nand2);


    }

    @Override
    public boolean read() {
        return nand3.read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex == 0) {
            nand1.connect(0,emitter);
            nand1.connect(1,emitter);
        } else {
            nand2.connect(0,emitter);
            nand2.connect(1,emitter);
        }

    }
}
