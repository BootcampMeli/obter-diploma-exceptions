package com.digitalhouse.obtenerdiploma.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

public class SubjectDTO {

  @NotBlank(message = "Nome da matéria deve ser preenchido.")
  private String subject;

  @Range(min = 0, max = 10, message = "Nota deve ser entre 0 e 10.")
  private Integer note;

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Integer getNote() {
    return note;
  }

  public void setNote(Integer note) {
    this.note = note;
  }

}
