package com.example.domain;

import javax.validation.constraints.NotEmpty;
import java.util.Calendar;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/23 18:56
 */
public class Message {
    private Long id;

    @NotEmpty(message = "Text is required.")
    private String text;

    @NotEmpty(message = "Summary is required.")
    private String summary;

    private Calendar created = Calendar.getInstance();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }
}
