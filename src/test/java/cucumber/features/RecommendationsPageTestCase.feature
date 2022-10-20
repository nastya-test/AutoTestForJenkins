# language: ru
@all
Функция: Блок Рекомендации

  Сценарий: Общие проверки для блока Рекомендации
    Дано открывает главную страницу
    И авторизуется
    Дано устанавливает страницу "Блок Рекомендации", как активную
    И скролит к элементу "Рекомендации"
    То проверяет, что текст элемента "Заголовок блока Рекомендации" соответствует тексту "Рекомендации"
    И проверяет, что ссылка элемента "Заголовок блока Рекомендации" совпадает с ссылкой "Ссылка /lists/movies/recommendation"

  Сценарий: Regex проверки и наличие постера для сниппетов
    Дано открывает главную страницу
    Дано устанавливает страницу "Блок Рекомендации", как активную
    И скролит к элементу "Рекомендации"
    То проверяет, что текст элементов "Название фильма в карусели" соответствует регулярному выражению "Регулярное выражение для проверки названия фильма"
    И проверяет, что текст элементов "Жанр и год фильма" соответствует регулярному выражению "Регулярное выражение для проверки жанра и года фильма"
    И проверяет, что ссылка элементов "Ссылка на фильм" соответствует регулярному выражению "Регулярное выражение для проверки ссылки фильма"
    И проверяет, что текст элементов "Рейтинг фильма" соответствует регулярному выражению "Регулярное выражение для проверки рейтинга фильма"
    И проверяет, что элементы "Постер у сниппета фильма" содержат изоображение

  Сценарий: Скролл сниппетов
    Дано открывает главную страницу
    Дано устанавливает страницу "Блок Рекомендации", как активную
    И скролит к элементу "Рекомендации"
    То проверяет, что элемент "Стрелка назад" скрыт
    И нажимает на элемент "Стрелка вперед"
    И проверяет, что элемент "Стрелка назад" отображается