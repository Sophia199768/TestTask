1) Описание решения
    Реализовавна модель данных для хранения информации о файлах. (File в папке Entity)
    Реализован маппер и pojo-объекты. (В папках mapper и requestsAndResponses)
    Потом реализизован контроллер для обработки http-запросов. (Controller в папке Controller).
        Методы:
            public GetFileResponse getFile(@PathVariable Long id); 
            public Long createFile(@RequestBody NewFileRequest newFileRequest); 
            public List<GetFileResponse> getAllFiles;
    Реализован сервис для работы с данными. (FileRepository и Service в папке Service).
    Настроено хранилище данных. 
Реализована трехслойная архитектура.

2) Инструкция по запуску приложения
    1. Docker
       maven: clean
       maven: package
       docker-compose up -d

    2. Не Docker
       cd src/main/resources
       docker-compose up -d
       run TestTaskApplication

3) Примеры тестовых запросов для проверки API-методов.
    Находятся в файлике test.http