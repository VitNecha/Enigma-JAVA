/*
Authors:
Vitaly Nechayuk 324359926
Maxim Pokidaylo 319475513
Adit Atia 205643802
*/

package Program;
import Parts.*;

public class Program {
    public static void main(String[] args) {
        //Task 5 example decryption//
            Enigma eni = new Enigma();
            eni.setRotors(Rotors.ROTOR2, Rotors.ROTOR5, Rotors.ROTOR4);
            eni.setOffsets(3, 15, 14);
            eni.setSettings('S', 'I', 'X');
            eni.setReflector(Rotors.REFLECTOR);
            eni.setPlugboardPair('Z', 'U');
            eni.setPlugboardPair('C', 'Q');
            eni.setPlugboardPair('H', 'L');
            eni.setPlugboardPair('W', 'M');
            eni.setPlugboardPair('O', 'A');
            eni.setPlugboardPair('P', 'Y');
            eni.setPlugboardPair('E', 'B');
            eni.setPlugboardPair('T', 'R');
            eni.setPlugboardPair('D', 'N');
            eni.setPlugboardPair('V', 'I');
            eni.translateWord("MLD"); // => DOR (4 - 15 - 18)
            eni.setOffsets(4, 15, 18);
            System.out.println("Text input: \n ----------\n" +
                    "UMDPQ CUAQN LVVSP\n" +
                    "IARKC TTRJQ KCFPT OKRGO\n" +
                    "ZXALD RLPUH AUZSO SZFSU\n" +
                    "GWFNF DZCUG VEXUU LQYXO\n" +
                    "TCYRP SYGGZ HQMAG PZDKC\n" +
                    "KGOJM MYYDD H");
            System.out.println("Decrypted text: ");
            eni.translateText("UMDPQ CUAQN LVVSP\n" +
                    "IARKC TTRJQ KCFPT OKRGO\n" +
                    "ZXALD RLPUH AUZSO SZFSU\n" +
                    "GWFNF DZCUG VEXUU LQYXO\n" +
                    "TCYRP SYGGZ HQMAG PZDKC\n" +
                    "KGOJM MYYDD H");
    }

}
