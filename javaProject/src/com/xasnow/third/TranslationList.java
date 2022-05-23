package third;

/**
 * @version 1.0
 * @author： wucheng
 * @date： 2022-01-07 16:16
 */


public class TranslationList {
    private Long translationId;
    private String id;
    private String content;


    public TranslationList() {
    }

    public TranslationList(Long translationId, String id, String content) {
        this.translationId = translationId;
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTranslationId() {
        return translationId;
    }

    public void setTranslationId(Long translationId) {
        this.translationId = translationId;
    }
}
