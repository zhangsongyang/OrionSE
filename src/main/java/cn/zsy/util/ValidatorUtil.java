package cn.zsy.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 校验工具类
 */
public class ValidatorUtil {

  private static Validator validator;

  static {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  /**
   * @param t 将要校验的对象
   * @throws ValidationException
   */
  public static <T> void validator(T t) throws ValidationException {
    Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
    if (constraintViolations.size() > 0) {
      Map<String, String> errorMessage = new HashMap<>();
      for (ConstraintViolation<T> violation : constraintViolations) {
        errorMessage.put(violation.getPropertyPath().toString(), violation.getMessage());
      }
      throw new ValidationException(errorMessage.toString());
    }
  }

}
