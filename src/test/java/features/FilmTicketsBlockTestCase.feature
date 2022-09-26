# language: ru
@all
Функция: Блок Билеты в кино

  Сценарий: Regex проверки и наличие постера для сниппетов
    Дано открывает главную страницу
    То скролит к блоку Билеты в кино
    И проверяет, что название корректно. Regex. Билеты в кино
    И проверяет, что ссылка корректна. Regex. Билеты в кино
    И проверяет, что год и жанр корректный. Билеты в кино
    И проверяет, что рейтинг. Regex. Билеты в кино
    И проверяет, что у сниппета есть постер. Regex. Билеты в кино

  Сценарий: Общие проверки для блока Новые трейлеры
    Дано открывает главную страницу
    То скролит к блоку Билеты в кино
    И проверяет, название блока Билеты в кино
    И проверяет, что ссылка блока afisha

  Сценарий: Скролл сниппетов
    Дано открывает главную страницу
    То скролит к блоку Билеты в кино
    И проверяет, что у блока Билеты в кино стрелка назад отсутствует, после нажатия стрелки вперед, стрелка назад появляется

  Сценарий: Скролл сниппетов
    Дано открывает главную страницу
    То скролит к блоку Билеты в кино
    И проверяет, плашку Билеты в кино