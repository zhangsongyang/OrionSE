package cn.zsy.eg.lombok;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class UserBean {

    private String name;

    private int old;

    private boolean sex;
}
