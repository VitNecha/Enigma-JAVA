# Enigma Simulator: Java Implementation

**About**

>The Enigma machine is a cipher device developed and used in the early- to mid-20th century to protect commercial, diplomatic, 
>and military communication. It was employed extensively by Nazi Germany during World War II, in all branches of the German military. 
>The Germans believed, erroneously, that use of the Enigma machine enabled them to communicate securely and thus enjoy a huge 
>advantage in World War II. The Enigma machine was considered to be so secure that even the most top–secret messages were enciphered 
>on its electrical circuits.

![alt text](enigma)

In this code Enigma implemented in Java and controlled (I/O) through IDE console.

**Structural description:**

>Class-based hierarchy similar to the one shown in the task example. Substitutor is an abstract parent class to other parts of 
>enigma (including enigma itself).

**Initialization:**

>After creation of Enigma machine (default constructor) we use “sets” to initialize rotors (enums), offsets, settings and 
>plug-board letter pairs separately.
>
>![alt text](1)

**Logical explanation of the algorithm:**

> With each input of letter:
>
>1. Letter “goes through” plug-board and changes according to the plug-board initialization.
>
>2. Plug board output letter “goes through” three rotors (right to left). In each rotor:
>
>	2.1. Rotor converts the current letter according to the offset and setting current state.
>
>	![alt text](2)
>
>	2.2. Then, letter “goes through” forward permutation of the rotor as if no changes done to offset and setting as those being 
>	done previously (arithmetically) in conversion.
>
>	2.3. Then, rotor corrects the previous conversion.
>
>	![alt text](3)
>
>3. Left rotor output letter “reflects” in the reflector (according to the chosen reflector).
>
>4. Reflector output letter “goes through” the rotors again (left to right) and the actions of (2) implemented in reverse (reverse 
>	permutation).
>
>![alt text](4)
>5. Right rotor output “goes through” plug-board in reverse and changes to the final output letter.
>
>
>*The algorithm uses “arithmetic shifts”. It finds the letter that should actually go through standard permutation (as if offset = 1 and* 
>*setting = ‘A’) according to the states of offset and setting (in the rotor) and corrects itself after the permutation accordingly.*
>
>*No actual sequence (in memory) shifts are done (time-saving).*


**Relavant functions of Enigma:**
>forwardPerutation(char) – Encryption/Decryption of single letter.
>
>translateWord(String) – Encryption/Decryption of single word.
>
>translateText(String) – Encryption/Decryption of text (with spaces and enters).