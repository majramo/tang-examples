package configFiles

log4j.appender.stdout = "org.apache.log4j.ConsoleAppender"
log4j.appender."stdout.layout"="org.apache.log4j.PatternLayout"
log4j.rootLogger="error,stdout"
log4j.logger.org.springframework="info,stdout"
log4j.additivity.org.springframework=false


