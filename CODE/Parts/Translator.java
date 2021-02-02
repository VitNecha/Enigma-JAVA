package Parts;

public class Translator extends Substitutor {
    protected String seq; // Translator letter sequence
    /*
    Input constructor
     */
    public Translator(String seq){this.seq = seq;}

    /*
    Forward permutation
     */
    @Override
    public char forwardPermutation(char inputC){ return (this.seq.charAt(this.letterToIndexConversion(inputC)));}

    /*
    Reverse permutation (Automated by forward permutation assuming the permutation is symmetric)
    */
    @Override
    public char reversePermutation(char inputC){ return forwardPermutation(inputC);}
}
