package xyz.durian.read.cleanread.controller.model.query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 请求参数的校验器
 */
@Component
public class RequestParameterValidator {

    private static final Logger logger = LoggerFactory.getLogger(RequestParameterValidator.class);

    public boolean checkUUID(String uuid) {
        if (Objects.isNull(uuid) || uuid.trim().length() != 36) {
            logger.info("id is not a validate uuid.");
            return false;
        }
        return true;
    }

}
