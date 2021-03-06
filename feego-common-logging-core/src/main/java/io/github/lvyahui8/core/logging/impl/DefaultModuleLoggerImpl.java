package io.github.lvyahui8.core.logging.impl;

import io.github.lvyahui8.core.logging.LogSchema;
import io.github.lvyahui8.core.logging.ModuleLogger;
import org.slf4j.Logger;

/**
 * @author lvyahui (lvyahui8@gmail.com,lvyahui8@126.com)
 * @since 2020/2/20 22:27
 */
public class DefaultModuleLoggerImpl implements ModuleLogger {
    private Logger logger;

    private String separator;


    public DefaultModuleLoggerImpl(Logger logger, String separator) {
        this.logger = logger;
        this.separator = separator;
    }

    @Override
    public Logger getInnerLogger() {
        return logger;
    }

    @Override
    public void info(LogSchema schema) {
        LogSchema.Detail detail = schema.buildDetail(separator);
        getInnerLogger().info(detail.getPattern(),detail.getArgs());
    }

    @Override
    public void warn(LogSchema schema) {
        LogSchema.Detail detail = schema.buildDetail(separator);
        getInnerLogger().warn(detail.getPattern(),detail.getArgs());
    }

    @Override
    public void warn(LogSchema schema, Throwable t) {
        LogSchema.Detail detail = schema.buildDetail(separator, true);
        detail.getArgs()[detail.getArgs().length - 1] = t;
        getInnerLogger().warn(detail.getPattern(),detail.getArgs());
    }

    @Override
    public void debug(LogSchema schema) {
        LogSchema.Detail detail = schema.buildDetail(separator);
        getInnerLogger().debug(detail.getPattern(),detail.getArgs());
    }

    @Override
    public void trace(LogSchema schema) {
        LogSchema.Detail detail = schema.buildDetail(separator);
        getInnerLogger().trace(detail.getPattern(),detail.getArgs());
    }

    @Override
    public void error(LogSchema schema) {
        LogSchema.Detail detail = schema.buildDetail(separator);
        getInnerLogger().error(detail.getPattern(),detail.getArgs());
    }

    @Override
    public void error(LogSchema schema, Throwable t) {
        LogSchema.Detail detail = schema.buildDetail(separator,true);
        // https://stackoverflow.com/questions/45054154/logger-format-and-throwable-slf4j-arguments/45054272#45054272
        // 关键代码：
        // org.apache.logging.log4j.message.ParameterizedMessage.initThrowable
        //   if (usedParams < argCount && this.throwable == null && params[argCount - 1] instanceof Throwable) {
        detail.getArgs()[detail.getArgs().length - 1] = t;
        getInnerLogger().error(detail.getPattern(),detail.getArgs());
    }
}
