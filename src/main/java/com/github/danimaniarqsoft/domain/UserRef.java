package com.github.danimaniarqsoft.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Lightweight reference object representing essential User details (id & login)
 * for embedding within other domain models like Project.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class UserRef implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String login;
}
