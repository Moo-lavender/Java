public class pockCard {
    int value;
    String color;
    public pockCard(int value,String color){
        this.value = value;
        this.color = color;
    }
    @Override
    public String toString(){
        return String.format("[%d,%s]",value,color);
    }
    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return  false;
        }
        if(!(obj instanceof pockCard)){
            return  false;
        }
        pockCard other = (pockCard) obj;
        return this.value == other.value && this.color.equals(other.color);
    }
}

