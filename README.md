### Lab05 - Реализация Lab02 с помощью REST API

### Lab04 - Реализация Lab01 с помощью REST API

### Lab03 - Реализация CRUD с помощью SOAP-сервиса

- [x] Основываясь на информации из раздела 2.8, добавить поддержку обработки ошибок в сервис 
- [x] Возможные ошибки, которые могут происходить при добавлении новых записей
  - [x] неверное значение одного из полей при изменении, удалении
  - [x] попытка изменить или удалить несуществующую запись
- [x] В соответствии с изменениями сервиса необходимо обновить и клиентское приложение

### Lab02 - Реализация CRUD с помощью SOAP-сервиса

- [x] в веб-сервис необходимо добавить методы для создания, изменения и удаления записей из таблицы
- [x] метод создания должен принимать значения полей новой записи
- [x] метод создания должен возвращать идентификатор новой записи
- [x] метод изменения – идентификатор изменяемой записи, а также новые значения полей
- [x] метод удаления – только идентификатор удаляемой записи
- [x] методы обновления или удаления – статус операции
- [x] в данной работе следует вносить изменения только в standalone-реализацию сервиса
- [x] в соответствии с изменениями сервиса необходимо обновить и клиентское приложение

### Lab01 - Поиск с помощью SOAP-сервиса

- [x] требуется создать таблицу в БД, содержащую не менее 5 полей
- [x] реализовать возможность поиска по любым комбинациям полей с помощью SOAP-сервиса
- [x] данные для поиска должны передаваться в метод сервиса в качестве аргументов
- [x] веб-сервис необходимо реализовать в виде standalone-приложения и J2EE-приложения
- [x] при реализации в виде J2EE-приложения следует на стороне сервера приложений настроить источник данных, и
  осуществлять его инъекцию в коде сервиса
- [x] для демонстрации работы разработанных сервисов следует также разработать и клиентское консольное приложение

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


