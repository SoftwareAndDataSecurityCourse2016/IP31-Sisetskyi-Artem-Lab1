package pairs;

public class StatisticPair {
    private String ch;
    private Float value;
    public StatisticPair(String ch, Float value){
        this.ch = ch;
        this.value = value;
    }
    public String getChar(){ return ch; }
    public Float getValue(){ return value; }
    public void setChar(String ch){ this.ch = ch; }
    public void setValue(Float value){ this.value = value; }
}