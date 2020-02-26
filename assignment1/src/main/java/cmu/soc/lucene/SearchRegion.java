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
}
