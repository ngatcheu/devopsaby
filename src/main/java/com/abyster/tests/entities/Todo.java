/**
 * 
 */
package com.abyster.tests.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Todo
 * 
 * @author KONGNUY Victorien on 28-09-2021
 * 
 */
@Entity
@Table(name = "todos")
@NoArgsConstructor
public class Todo implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Getter
  @Setter
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;

  @Getter
  @Setter
  String title;

  @Getter
  @Setter
  Date createdAt;

}