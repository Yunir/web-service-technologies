# Поиск с помощью SOAP-сервиса

- [x] требуется создать таблицу в БД, содержащую не менее 5 полей
- [x] реализовать возможность поиска по любым комбинациям полей с помощью SOAP-сервиса
- [x] данные для поиска должны передаваться в метод сервиса в качестве аргументов
- [x] Веб-сервис необходимо реализовать в виде standalone-приложения и J2EE-приложения
- [x] При реализации в виде J2EE-приложения следует на стороне сервера приложений настроить источник данных, и
  осуществлять его инъекцию в коде сервиса
- [x] Для демонстрации работы разработанных сервисов следует также разработать и клиентское консольное приложение

### Prerequisites

- Glassfish 5.1.0
- PostgreSQL 9.6
- Java 1.8

### Notes

- Если после добавления в `JDBC Connection Pool` и произведения пинга PostgreSQL из Glassfish вы столкнетесь с проблемой
  связанной с `sun.security.ssl`:

```
java.lang.NoSuchMethodError: sun.security.ssl.SSLSessionImpl.(Lsun/security/ssl/ProtocolVersion;Lsun/security/ssl/CipherSuite;Ljava/util/Collection;Lsun/security/ssl/SessionId;Ljava/lang/String;I)V
```

То, выполните эти инструкции:

```shell
$ pushd glassfish5/glassfish/modules/endorsed
$ zip -d grizzly-npn-bootstrap.jar "sun/*"
$ popd
```


