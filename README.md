# MockingjayBot

  Данный Vk бот выполнен в рамках тестового задания.
  
## Инструкция по запуску

1. Скопируйте репозиторий MockingjayBot на свой компьютер.
2. Убедитесь, что у вас установлены [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) и [Maven](https://maven.apache.org/download.cgi).
3. Откройте терминал и перейдите в директорию проекта.
4. Выполните команду `mvn clean install` для сборки проекта.
5. Откройте файл `application.properties` в директории `src/main/resources` и заполните необходимые параметры:
    * `vk.api.confirmation_key` - ключ подтверждения вашего сервера для Callback API.
    * `vk.group_id` - идентификатор группы ВКонтакте, для которой будет работать бот.
    * `vk.api.version` - версия API ВКонтакте. По умолчанию, бот использует версию 5.199.
    * `vk.access-token` - ключ доступа с необходимыми правами для работы бота.
6. Сохраните файл `application.properties`.
7. Выполните команду `java -jar target/mockingjaybot-1.0.0.jar` для запуска бота.

## Параметры

Большинство параметром можно найти в настройках группы ВК (Пункт `Управление`)

* `vk.api.confirmation_key` - ключ подтверждения сервера для Callback API.Его можно получить из вкладки `Настройки -> Работа с API -> Callback API`. Необходим для подтверждения сервера со стороны VK. 
Этот ключ будет возвращен на запрос подтверждения.
* `vk.group_id` - идентификатор группы ВКонтакте. Вы можете найти идентификатор группы, перейдя `Настройки -> Работа с API -> Callback API` в данной структуре { "type": "confirmation", "group_id": `номер группы` }.
* `vk.api.version` - версия API ВКонтакте. Подробнее об это можно на официальном сайте [API VK](https://vk.com/dev).
* `vk.access-token` - токен доступа. Вы можете получить токен доступа, создав ключ доступа с правами `Cообщения сообщества` в настройках группы в `Управление -> Настройки -> Работа с API -> Ключи доступа`.

  
