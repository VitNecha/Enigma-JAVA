package Parts;
/*
Pre-Identified rotors
 */
public enum Rotors {
    ROTOR1("EKMFLGDQVZNTOWYHXUSPAIBRCJ",'Q'),
    ROTOR2("AJDKSIRUXBLHWTMCQGZNPYFVOE", 'E'),
    ROTOR3("BDFHJLCPRTXVZNYEIWGAKMUSQO",'V'),
    ROTOR4("ESOVPZJAYQUIRHXLNFTGKDCMWB",'J'),
    ROTOR5("VZBRGITYUPSDNHLXAWMJQOFECK",'Z'),
    REFLECTOR("YRUHQSLDPXNGOKMIEBFZCWVJAT",'-'),
    ALPHABET("ABCDEFGHIJKLMNOPQRSTUVWXYZ",'-');
    private final String RotorSequence;
    private final char turnoverNotch;

    /*
    Input constructor
     */
    Rotors(String RotorSeq, char turnN){
        this.RotorSequence = RotorSeq;
        this.turnoverNotch = turnN;
    }
    /*
    toString
    Returns only the rotor letter sequence itself
     */
    public String toString(){return RotorSequence;};

    public char getTurnoverNotch() {
        return turnoverNotch;
    }
}
