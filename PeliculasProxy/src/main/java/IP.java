public record IP(int num1, int  num2, int num3, int num4) {
    
    public String getPais(){
        if (this.num1 <= 49){
            return "Argentina";
        } else if (this.num1 <= 99) {
            return "Brasil";
        } else if (this.num1 <= 149) {
            return "Colombia";
        }
        return null;
    }
}