package com.example.demo.entities;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    protected Date CreatedDate;
    protected String CreatedBy;
    protected Date UpdatedDate;
    protected String UpdatedBy;
    protected Boolean IsDelete;
}
