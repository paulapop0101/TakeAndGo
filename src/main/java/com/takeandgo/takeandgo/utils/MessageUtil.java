package com.takeandgo.takeandgo.utils;

import com.takeandgo.takeandgo.AppConfiguration;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class MessageUtil {
    private static final MessageSource messageSource = new AppConfiguration().messageSource();

    public static String getMessage(final String message, Object[] params) {
        return messageSource.getMessage(message,params, Locale.ENGLISH);
    }
}
