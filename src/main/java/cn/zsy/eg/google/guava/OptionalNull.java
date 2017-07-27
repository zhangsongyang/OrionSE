package cn.zsy.eg.google.guava;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * Created by zhangsongyang on 5/25/2017.
 */
public class OptionalNull {

    public static void main(String[] args) {
        //Optional
        Integer list = null;
        Optional<Integer> optional = Optional.fromNullable(list);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
//            System.out.println(optional.orNull());
            System.out.println(optional.or(11));
        }
        Optional<Integer> possible = Optional.of(3);
        System.out.println(possible.isPresent());
        System.out.println(possible.get());
        System.out.println(possible.hashCode());
        System.out.println(possible.or(2));

        //Preconditions
        Preconditions.checkArgument(1 >= 0, "Argument was %s but expected nonnegative", 1);
        Integer integer = 98765;
        System.out.println(Preconditions.checkNotNull(integer, "error7758521"));
        Preconditions.checkState(0 == 0);
        Preconditions.checkElementIndex(7, 20);
//        Preconditions.checkPositionIndexes(1, 3, 2);

        //Objects
        System.out.println(Objects.equal(1, 10));
        System.out.println("hashCode: " + Objects.hashCode("asdf", "123"));

    }

}
