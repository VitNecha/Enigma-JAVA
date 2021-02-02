package Parts;

public class Plugboard extends Translator{

    private int numOfPairs; //Current number of pairs

    /*
    Input constructor
     */
    public Plugboard(){
        super((Rotors.ALPHABET).toString()); //Usual alphabet sequence as a default
        this.numOfPairs = 0; //Default number of pairs
    }

    /*
    Letter pairs setting
     */
    public void setPair(char let1, char let2){
        if (numOfPairs <= 10 //Up to 10 pairs (standard maximum)
                && (((this.seq).charAt(letterToIndexConversion(let1))) == let1) //First letter isn't in use already
                && (((this.seq).charAt(letterToIndexConversion(let2))) == let2)){ // Second letter isn't in use already
            char temp[] = this.seq.toCharArray(); //Temporary character array for letter swap (Technical issue)
            char tempC = temp[letterToIndexConversion(let1)];
            temp[letterToIndexConversion(let1)] = temp[letterToIndexConversion(let2)];
            temp[letterToIndexConversion(let2)] = tempC;
            this.seq = new String(temp); // New letter sequence
            numOfPairs++; // Update of number of pairs
        }
    }
    /*
    Plugboard reset
     */
    public void resetPlugboard(){ this.seq = Rotors.ALPHABET.toString(); } //Reset to default
}
