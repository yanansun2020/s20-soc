package cmu.soc.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PubAuthor {
    private Long id;
    private Long pubId;
    private Long authorId;

    public PubAuthor(Long pubId, Long authorId) {
        this.pubId = pubId;
        this.authorId = authorId;
    }
}
