1) Описание решения:
   1. Реализовавна модель данных для хранения информации о файлах. (File в папке Entity)
   2.   Реализован маппер и pojo-объекты. (В папках mapper и requestsAndResponses)
   3.    Потом реализизован контроллер для обработки http-запросов. (Controller в папке Controller).
           Методы:
               public GetFileResponse getFile(@PathVariable Long id); 
               public Long createFile(@RequestBody NewFileRequest newFileRequest); 
               public List<GetFileResponse> getAllFiles;
   4.    Реализован сервис для работы с данными. (FileRepository и Service в папке Service).
   5.    Настроено хранилище данных. 
   Реализована трехслойная архитектура.

2) Инструкция по запуску приложения:
    1. Docker
       1) maven: clean
       2) maven: package
       3) docker-compose up -d

    2. Не Docker
       1) cd src/main/resources
       2) docker-compose up -d
       3) run TestTaskApplication

3) Примеры тестовых запросов для проверки API-методов:
    Находятся в файлике test.http