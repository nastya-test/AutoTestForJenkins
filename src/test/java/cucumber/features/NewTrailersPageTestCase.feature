# language: ru
@all
Функция: Блок новые трейлеры

  Сценарий: Regex проверки и наличие постера для сниппетов
    Дано открывает главную страницу
    Дано устанавливает страницу "Блок Новые трейлеры", как активную
    И скролит к элементу "Новые трейлеры"
    То проверяет, что текст элементов "Название трейлера" соответствует регулярному выражению "Регулярное выражение для проверки названия фильма"
    И проверяет, что текст элементов "Жанр и год трейлера" соответствует регулярному выражению "Регулярное выражение для проверки жанра и года фильма"
    И проверяет, что ссылка элементов "Название трейлера" соответствует регулярному выражению "Регулярное выражение для проверки ссылки фильма"

  Сценарий: Общие проверки для блока Новые трейлеры
    Дано открывает главную страницу
    Дано устанавливает страницу "Блок Новые трейлеры", как активную
    И скролит к элементу "Новые трейлеры"
    То проверяет, что текст элемента "Заголовок блока Новые трейлеры" соответствует тексту "Новые трейлеры"
    И проверяет, что ссылка элемента "Заголовок блока Новые трейлеры" совпадает с ссылкой "Ссылка на /video"

  Сценарий: Проигрывание трейлеров
    Дано открывает главную страницу
    Дано устанавливает страницу "Блок Новые трейлеры", как активную
    И скролит к элементу "Новые трейлеры"
    То проверяет, что элементы "Оранжевая кнопка проигрывания видео" имеют заливку "Оранжевый для плеера" цвета
    И проверяет, что для всех элементов в "Название трейлера" при нажатии на элемент "Оранжевая кнопка проигрывания видео" отображается элемент "Плеер с трейлером" и закрывается при нажатии на элемент "Закрытие плеера с трейлером"

  Сценарий: Скролл сниппетов
    Дано открывает главную страницу
    Дано устанавливает страницу "Блок Новые трейлеры", как активную
    И скролит к элементу "Новые трейлеры"
    То проверяет, что элемент "Стрелка назад" скрыт
    И нажимает на элемент "Стрелка вперед"
    И проверяет, что элемент "Стрелка назад" отображается
