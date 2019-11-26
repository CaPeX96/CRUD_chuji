package com.deepexi.domain.entity;

import lombok.Data;

@Data
public class Message {
    private Integer message_id;
    private int send_id;//Integer默认null，int默认0
    private Integer rec_id;
    private String content;
    private int status;
    private long send_date;
}
