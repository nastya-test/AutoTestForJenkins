# language: ru
@all
Функция: Блок новые трейлеры

  Сценарий: Regex проверки и наличие постера для сниппетов
    Дано открывает главную страницу
    То скролит к элементу "Новые трейлеры"
    И проверяет, что текст элемента "Название фильма" соответствует регулярному выражению "Регулярное выражение для проверки названия фильма"
    И проверяет, что текст элемента "Жанр и год фильма" соответствует регулярному выражению "Регулярное выражение для проверки жанра и года фильма"
    И проверяет, что ссылка элемента "Ссылка на фильм" соответствует регулярному выражению "Регулярное выражение для проверки ссылки фильма"

  Сценарий: Общие проверки для блока Новые трейлеры
    Дано открывает главную страницу

    Дано открывает главную страницу
    То скролит к элементу "Новые трейлеры"
    И проверяет, что текст элемента "Заголовок блока Новые трейлеры" соответствует тексту "Новые трейлеры"
    И проверяет, что ссылка элемента "Заголовок блока Новые трейлеры" совпадает с ссылкой "Ссылка на /video"

  Сценарий: Проигрывание трейлеров
    Дано открывает главную страницу
    То скролит к элементу "Новые трейлеры"
    И проверяет, что по нажатию на элемент "" открывается плеер

  Сценарий: Скролл сниппетов
    Дано открывает главную страницу
    То скролит к элементу "Новые трейлеры"
    И проверяет, что у элемента "" стрелка назад отсутствует, после нажатия стрелки вперед, стрелка назад появляется
