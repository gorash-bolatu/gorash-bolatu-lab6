public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }

    public char decrypt_char(char outer_char) {
        int outer_index = rotors[2].indexOf(outer_char);
        char middle_char = rotors[1].charAt(outer_index);
        outer_index = rotors[2].indexOf(middle_char);
        char inner_char = rotors[0].charAt(outer_index);
        this.rotate();
        return inner_char;
    }

    public String decrypt(String message){        
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            decrypted.append(decrypt_char(ch));
        }
        return decrypted.toString();
    }

    private char encrypt_char(char inner_char) {
        int inner_index = rotors[0].indexOf(inner_char);
        char outer_char = rotors[2].charAt(inner_index);
        int middle_index = rotors[1].indexOf(outer_char);
        outer_char = rotors[2].charAt(middle_index);
        this.rotate();
        return outer_char;
    }
    
    public String encrypt(String message){
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            encrypted.append(encrypt_char(ch));
        }
        return encrypted.toString();
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
