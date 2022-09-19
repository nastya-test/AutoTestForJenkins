# language: ru
@all
Функция: Блок новые трейлеры

  Сценарий: Regex проверки и наличие постера для сниппетов
    Дано открывает главную страницу
    То проверяет, что название корректно. Regex. Трейлеры
    И проверяет, что ссылка корректна. Regex. Трейлеры
    И проверяет, что год и жанр корректный. Regex. Трейлеры

  Сценарий: Общие проверки для блока Новые трейлеры
    Дано открывает главную страницу
    То проверяет, название блока Новые трейлеры
    И проверяет, что ссылка блока video

  Сценарий: Проигрывание трейлеров
    Дано открывает главную страницу
    То проверяет, что  по нажатию на кнопку открывается плеер

  Сценарий: Скролл сниппетов
    Дано открывает главную страницу
    То проверяет, что стрелка назад отсутствует, после нажатия стрелки вперед, стрелка назад появляется