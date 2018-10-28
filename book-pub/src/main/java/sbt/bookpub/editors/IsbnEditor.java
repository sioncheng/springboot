package sbt.bookpub.editors;

import org.springframework.util.StringUtils;
import sbt.bookpub.model.Isbn;

import java.beans.PropertyEditorSupport;

public class IsbnEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isEmpty(text)) {
            setValue(null);
        } else {
            setValue(Isbn.parseFrom(text));
        }
    }

    @Override
    public String getAsText() {
        Object isbn = getValue();
        return isbn == null ? "" : isbn.toString();
    }
}
