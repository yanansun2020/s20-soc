package cmu.soc.parser;

import org.apache.commons.lang3.StringUtils;

public enum PaperType {
    ARTICLE(1, "article"),
    INPROCEEDINGS(2, "inproceedings");

    private Integer id;
    private String desc;
    PaperType(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static PaperType getByDesc(String nodeName) {
        if(StringUtils.isEmpty(nodeName)){
            return null;
        }
        for (PaperType e : PaperType.values()) {
            if(e.getDesc().equals(nodeName)){
                return e;
            }
        }
        return null;
    }

    public static PaperType getById(Integer pubType) {
        if(pubType == null){
            return null;
        }
        for (PaperType e : PaperType.values()) {
            if(pubType.equals(e.getId())){
                return e;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }
}
