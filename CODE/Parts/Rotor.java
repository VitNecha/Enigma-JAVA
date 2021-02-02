package Parts;

public class Rotor extends Translator{
    private int turnoverNotch;
    public char setting;
    public int offset;

    /*
    Input constructor
     */
    public Rotor(String seq, int offset, char setting, char turnoverNotch){
        super(seq);
        this.turnoverNotch = letterToIndexConversion(turnoverNotch) + 1;
        setOffset(offset);
        setSetting(setting);
    }
    /*
    Setting initialization
     */
    public void setSetting(char setting) {
        this.setting = setting;
    }
    /*
    Offset advancement
     */
    public void advanceOffset(){
        if (this.offset < 26) this.offset++;
        else this.offset = 1;
    }
    /*
    Notch status
     */
    public boolean notch(){
        if (this.offset == turnoverNotch) return true;
        else return false;
    }
    /*
    Pre-permutation letter conversion according to the relative standings of setting and offset
     */
    private char settingConversion(char inputC){
        int tempID = (letterToIndexConversion(inputC)) + this.offset - (letterToIndexConversion(this.setting)); //Index correction according to offset and setting
        if (tempID > 26) tempID = tempID % 26; // Alphabetical adaptation
        if (tempID < 0) tempID = (26 + tempID) % 26; //Alphabetical adaptation
        if (tempID == 0) tempID = 26; //Alphabetical adaptation
        return Rotors.ALPHABET.toString().charAt(tempID - 1);
    }
    /*
    Post-permutation letter correction according to the relative standings of setting and offset
     */
    private char settingCorrection(char inputC) {
        int tempID = - this.offset + 1 + letterToIndexConversion(this.setting);
        if (tempID < 1) tempID = 26 + tempID;
        return Rotors.ALPHABET.toString().charAt(((letterToIndexConversion(inputC) + tempID)%26));
    }
    /*
    Reverse permutation (Asymmetric) for rotor.
    Basically a combination of setting conversion and correction + reverse permutation done in reverse.
    */
    @Override
    public char reversePermutation(char inputC){
        int temp1 = this.offset - 1 - letterToIndexConversion(this.setting);//"Gap" between current letter and the letter we get after setting conversion
        int temp2 = -temp1; // We save the value of the gap (negative opposite) as we use it later
        if (temp1 >= 0) { //Reverse permutation and setting correction according to the sign of the "gap"
            temp1 = this.seq.indexOf((indexToLetterConversion((letterToIndexConversion(inputC) + temp1) % 26)));
            return Rotors.ALPHABET.toString().charAt((temp1 + 26 + temp2) % 26);
        }
        else {
            temp1 = this.seq.indexOf((indexToLetterConversion((letterToIndexConversion(inputC) + 26 + temp1) % 26)));
            return Rotors.ALPHABET.toString().charAt((temp1 + temp2) % 26);
        }
    }
    /*
    Override of parent method <forwardPermutation>
    */
    @Override
    public char forwardPermutation(char inputC){
        return settingCorrection(super.forwardPermutation(settingConversion(inputC))); //The letter goes through several stages
    }
    /*
    Rotor offset settings
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }
}
