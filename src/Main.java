import logger.LogLevel;
import logger.LoggerFactory;
import logger.formatted.console.ConsoleLoggerFactory;

public class Main {
    private static final String FORMAT_STRING = "%date% %level% [%class%]: %message%";

    public static void main(String[] args) {
        // Этап 1. Логирование в консольку. Уже реализовано
        LoggerFactory.register(LogLevel.DEBUG, new ConsoleLoggerFactory(FORMAT_STRING));


        // Этап 2. Реализуем FileLogger
        //
        // LoggerFactory.register(LogLevel.DEBUG, new FileLoggerFactory("./log.txt", FORMAT_STRING));
        //
        // Для этого сначала создаем package (папку) logger.formatted.file
        // Потом в этой папке 2 файла по аналогии с пакетом logger.formatted.console,
        // но меняем в названиях "Console" -> "File".
        // Note: для FileLogger и FileLoggerFactory мы еще хотим пробросить имя файла куда будем писать лог.
        //
        // Далее реализуем все методы как в ConsoleLogger и ConsoleLoggerFactory.
        // Отличие в том, что в методе writeLog мы пишем в файл, название которого передали при создании фабрики.
        // Писать в файл можно как через Files.write(), так и через OutputStreamWriter, а также и еще многими способами.
        // Самый простой вариант для данного случая это Files.write, посмотрите примеры использования.


        // Этап 3. Реализуем MultiLogger
        // Задача MultiLogger в том, чтобы мы могли писать логи сразу в несколько мест. Например, одновременно в консоль
        // для быстрого доступа к ним во время использования приложения и в файл, чтобы они долго хранились.
        // При этом в местах где мы их будем использовать до сих пор сохранится тот же формат вызова logger.info("Blabla")
        // По сути MultiLogger будет просто оберткой сразу над несколькими Logger, а MultiLoggerFactory будет оберткой
        // над несколькими MultiLoggerFactory, которые мы в него передадим.
        //
        // LoggerFactory.register(LogLevel.DEBUG,
        //         new MultiLoggerFactory(
        //                 new ConsoleLoggerFactory(FORMAT_STRING),
        //                 new FileLoggerFactory("./log.txt", FORMAT_STRING)));
        //
        // Для этого сначала создаем package (папку) logger.multi
        // Потом в этой папке 2 файла по аналогии с пакетом logger.formatted.console,
        // но меняем в названиях "Console" -> "Multi".
        //
        // Note 1: заметьте, что пакет у нас находится не внутри пакета formatted. Сам логгер и фабрика не наследуются
        // от FormattedLogger и FormattedLoggerFactory, так как они сами ничего не форматируют.
        // Правильное объявление классов такое:
        //
        // public class MultiLogger implements Logger {
        //    ...
        // }
        //
        // public class MultiLoggerFactory extends LoggerFactory {
        //    ...
        // }
        //
        // Note 2: MultiLogger внутри должен вызывать метод log() у нескольких логгеров, так что в конструкторе он должен их получать.
        // Также MultiLoggerFactory должен уметь создавать для MultiLogger каждый раз новые логгеры, так что он сам
        // в конструкторе должен получать коллекцию LoggerFactory из которых он и будет создавать коллекцию Logger для MultiLogger.
        // Так как мы хотим иметь удобный синтаксис создания MultiLoggerFactory, мы его конструктор объявляем как
        //    public MultiLoggerFactory(LoggerFactory... factories) {
        //        this.factories = factories;
        //    }
        // Здесь LoggerFactory... factories означает, что мы можем при вызове метода через запятую передать в параметрах
        // произвольное количество объектов LoggerFactory. Работать с ними можно как с массивом с названием factories
        //
        // Далее реализуем все методы как в ConsoleLogger и ConsoleLoggerFactory.
        // Отличие в том, что в методе writeLog мы вызываем методы log() у всех логгеров, которые были переданы при создании MultiLogger.


        ClassA.doSomeWork();
        ClassB.doSomeWork();
    }
}