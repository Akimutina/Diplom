# **Дипломный проект по профессии «Инженер по тестированию»**

## Тестирование мобильного приложения «Мобильный хоспис»

[Ссылка на задание](https://github.com/netology-code/qamid-diplom)

## Документация

- [План тестирования](https://github.com/Akimutina/Diplom/blob/main/Plan.md)
- [Чек-лист](https://docs.google.com/spreadsheets/d/1OAwDrsqCn4B5xmLJqAaRVzK97G0ZbvViy0AA05xb4J0/edit)
- [Тест-кейсы](https://docs.google.com/spreadsheets/d/1_TXiu_SY3QeXfG9pCYebJSdkwSWFoJyMSyRdfcps4Lo/edit#gid=0)
- [Отчет о тестировании]()

## Запуск приложения и тестов

1. Склонировать репозиторий `https://github.com/Akimutina/Diplom` командой `git clone`
2. Открыть проект в Android Studio;
3. Запустить эмулятор или подключить устройство для тестирования. Язык на устройстве - Русский.
   Данные для входа в приложение: - логин: login2 - пароль: password2

4. Перейти в папку проекта `fmh_android_15_03_24`
5. Запустить тесты через терминал `./gradlew connectedAndroidTest`
6. Подождать пока пройдут все тесты и посмотреть результат.

## Формирование отчета AllureReport (вариант № 1, использовался до обновления приложения)

1. Выгрузить каталог `/data/data/ru.iteco.fmhandroid/files/allure-results` с тестируемого устройства (через Device File Explorer);
2. Выполнить команду `allure serve`, находясь на уровень выше allure-results;
3. Подождать генерации отчета и посмотреть его в открывшемся браузере.

## Формирование отчета AllureReport (вариант № 2, использовался после обновления приложения)

1. Добавить allure.results.useTestStorage=true в allure.properties ресурсы androidTest;
2. Добавить в тестовое приложение зависимость androidTestUtil "androidx.test:orchestrator:1.4.2";
3. Выгрузить каталог `/sdcard/googletest/test_outputfiles/allure-results` с тестируемого устройства (через Device File Explorer);
4. Выполнить команду `allure serve`, находясь на уровень выше allure-results;
5. Подождать генерации отчета и посмотреть его в открывшемся браузере.
