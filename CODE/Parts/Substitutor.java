package Parts;

public abstract class Substitutor {
    /*
    Letter-Index conversion
     */
    public int letterToIndexConversion(char let){ return (int)(let - 'A'); }

    /*
    Index-Letter conversion
     */
    public char indexToLetterConversion(int n){ return (char)('A' + n); }

    /*
    Circular string shift left
     */
    public String shiftLeft(String inputC){return inputC = inputC.substring(1) + inputC.charAt(0);}

    /*
    Circular string shift right
     */
    public String shiftRight(String inputC){return inputC.charAt(inputC.length() - 1) + inputC.substring(0,inputC.length() - 1);}

    /*
    Abstract forward permutation method
     */
    public abstract char forwardPermutation(char inputC);

    /*
    Abstract reverse permutation method
     */
    public abstract char reversePermutation(char inputC);
}

