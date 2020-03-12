package cmu.soc.dao.entity;

import cmu.soc.parser.PaperAbstracts;
import lombok.Data;

@Data
public class PubAbs extends PaperAbstracts {
    private Long id;
    private Long pubId;
}
