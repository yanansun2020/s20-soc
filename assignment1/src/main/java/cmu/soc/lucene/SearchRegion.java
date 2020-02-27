package cmu.soc.lucene;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchRegion {
    private int yearLow;
    private int monthLow;
    private int yearHigh;
    private int monthHigh;
    //this.getClass().getResource("").getPath()
    public static void main(String[] args){

        System.out.print( System.getProperty("LUCENE_INDEX"));
        System.out.print( System.getenv("LUCENE_INDEX"));
    }
}
