package com.genesisfin.backend.web.schemas.entity;

import com.genesisfin.backend.web.schemas.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
@PresentationSchema(name = "user")
public class User {

    @PresentationField
    @PresentationFormField
    @PresentationColumn(type = ColumnType.LinkShow, width = "50px")
    @PresentationDetailField
    private Long id;

    @PresentationField
    @PresentationFormField(placeholder = "请输入名字", rules = {
            @PresentationRule(required = true, message = "名字是必须的")
    })
    @PresentationColumn(type = ColumnType.LinkUpdate, width = "100px")
    @PresentationDetailField
    @PresentationSearchField
    private String name;

    @PresentationField(type = PropertyType.Map, options = {
            @PresentationOption(label = "msn", value = "tsuijy@msn.com"),
            @PresentationOption(label = "gmail", value = "tsuijy@gmail.com")
    })
    @PresentationColumn(minWidth = "100px")
    @PresentationFormField(type = FormFieldType.Select, placeholder = "邮箱")
    @PresentationDetailField
    @PresentationSearchField
    private String email;

    @PresentationField(type = PropertyType.Password)
    @PresentationFormField(rules = {
            @PresentationRule(required = true, message = "密码是必须的")
    })
    private String password;

    @PresentationField(type = PropertyType.Datetime)
    @PresentationColumn(width = "140px")
    @PresentationDetailField
    private Date createdTime;

    @PresentationField(type = PropertyType.Datetime)
    @PresentationDetailField
    private Date updatedTime;

    @PresentationField(type = PropertyType.Datetime)
    @PresentationFormField(type = FormFieldType.Checkbox, dataUrl = "/roles")
    private int[] roles;
}