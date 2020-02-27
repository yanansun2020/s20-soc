package cmu.soc.dao.entity;

import cmu.soc.parser.PaperDtd;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Publication extends PaperDtd implements Comparable<Publication> {
    private Long authorId;
    List<String> authors;


    @Override
    public int compareTo(Publication p) {
        if(p.getTitle().equals(this.getTitle())){
            return 0;
        }
        if(p.getTitle().compareTo(this.getTitle()) > 0){
            return -1;
        }
        return 1;
    }
}
