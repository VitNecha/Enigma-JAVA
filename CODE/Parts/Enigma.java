package Parts;

public class Enigma extends Substitutor {
    private Rotor rightRotor, middleRotor, leftRotor;
    private Plugboard plugboard;
    private Reflector reflector;
    /*
    Default constructor
     */
    public Enigma(){ this.plugboard = new Plugboard(); }

    //SETS//
    public void setRightSetting(char setting){ this.rightRotor.setSetting(setting);}
    public void setMiddleSetting(char setting){ this.middleRotor.setSetting(setting);}
    public void setLeftSetting(char setting){ this.leftRotor.setSetting(setting);}
    public void setRightOffset(int offset){ this.rightRotor.setOffset(offset); }
    public void setMiddleOffset(int offset){ this.middleRotor.setOffset(offset); }
    public void setLeftOffset(int offset){ this.leftRotor.setOffset(offset); }

    public void setRightRotor(Rotors rightRotor){
        this.rightRotor = new Rotor(rightRotor.toString(),1,'A',rightRotor.getTurnoverNotch()); }

    public void setMiddleRotor(Rotors middleRotor) {
        this.middleRotor = new Rotor(middleRotor.toString(),1,'A',middleRotor.getTurnoverNotch()); }

    public void setLeftRotor(Rotors leftRotor) {
        this.leftRotor = new Rotor(leftRotor.toString(),1,'A',leftRotor.getTurnoverNotch()); }

    public void setReflector(Rotors reflector){
        this.reflector = new Reflector(reflector.toString());
    }

    public void setPlugboard(Plugboard plugboard) { this.plugboard = plugboard; }

    public void setPlugboardPair(char let1, char let2){this.plugboard.setPair(let1,let2);}

    public void setOffsets(int leftOffset, int middleOffset, int rightOffset){
        this.rightRotor.setOffset(rightOffset);
        this.middleRotor.setOffset(middleOffset);
        this.leftRotor.setOffset(leftOffset);
    }

    public void setSettings(char leftSetting, char middleSetting, char rightSetting){
        this.rightRotor.setSetting(rightSetting);
        this.middleRotor.setSetting(middleSetting);
        this.leftRotor.setSetting(leftSetting);
    }

    public void setRotors(Rotors leftRotor, Rotors middleRotor, Rotors rightRotor){
        this.rightRotor = new Rotor(rightRotor.toString(),1,'A',rightRotor.getTurnoverNotch());
        this.middleRotor = new Rotor(middleRotor.toString(),1,'A',middleRotor.getTurnoverNotch());
        this.leftRotor = new Rotor(leftRotor.toString(),1,'A',leftRotor.getTurnoverNotch());
    }
    ////////////
    /*
    Override of forwardPermutation method
     */
    @Override
    public char forwardPermutation(char inputC){
        if (this.rightRotor.notch() || this.middleRotor.notch()){
            if (this.middleRotor.notch()) this.leftRotor.advanceOffset(); //Offset advancement
            this.middleRotor.advanceOffset(); //Offset advancement
        }
        this.rightRotor.advanceOffset(); //Offset advancement
        inputC = plugboard.forwardPermutation(inputC); //Letter goes (forward) through plugboard
        inputC = leftRotor.forwardPermutation(middleRotor.forwardPermutation(rightRotor.forwardPermutation(inputC))); //Letter goes (forward) through rotors
        inputC = reflector.forwardPermutation(inputC); //Letter reflects in reflector
        inputC = rightRotor.reversePermutation(middleRotor.reversePermutation(leftRotor.reversePermutation(inputC)));//Letter goes (reverse) through rotors
        inputC = plugboard.reversePermutation(inputC);//Letter goes (reverse) through plugboard
        return inputC;
    }
    /*
    Method translates text (as a String) considering spaces and enters
     */
    public void translateText(String text){
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) != ' ' && text.charAt(i) != '\n') System.out.print(forwardPermutation(text.charAt(i)));
            else System.out.print(text.charAt(i));
        }
    }
    /*
    Method translates one word (or letter sequence)
     */
    public void translateWord(String inputW){
        for (int i = 0; i < inputW.length(); i++) System.out.print(this.forwardPermutation(inputW.charAt(i)));
        System.out.print("\n");
    }

    @Override
    public char reversePermutation(char inputC){ return forwardPermutation(inputC); }
}