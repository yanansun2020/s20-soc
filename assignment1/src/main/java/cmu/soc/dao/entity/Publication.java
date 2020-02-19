package cmu.soc.dao.entity;

import cmu.soc.parser.PaperDtd;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Publication extends PaperDtd {
    private Long authorId;
    List<String> authors;
}
