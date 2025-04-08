public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        char prefix = this.charAt(this.rotorValues.length() - 1);
        String other = this.rotorValues.substring(0, this.rotorValues.length() - 1);
        this.rotorValues = prefix + other;
        return this.charAt(0) == this.startChar;       
    }
    

    public int indexOf(char c){
        return rotorValues.indexOf(c);
    }

    public char charAt(int idx){
        return rotorValues.charAt(idx);
    }
}
    
