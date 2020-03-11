package cmu.soc.parser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaperDtdAttribute {
    private String key;
    private String mdate;
    private String paperType;
    //private Integer paperTypeInt;

  /*  public Integer getPaperTypeInt() {
        return paperType == null? paperTypeInt : paperType.getId();
    }*/
}
