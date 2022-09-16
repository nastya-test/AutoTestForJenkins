# language: ru
@all
Функция: Авторизация

  @success
  Сценарий: Вход в существующий аккаунт
    Дано открывает главную страницу
    И переходит на страницу входа в аккаунт
    И вводит логин
    И нажимает продолжить
    И вводит пароль
    Когда нажимает продолжить
    То пользователь вошел в аккаунт

  @fail
  Структура сценария: Вход c неверным логином
    Дано открывает главную страницу
    И переходит на страницу входа в аккаунт
    И вводит <неверный логин>
    И нажимает продолжить
    То отобразилось сообщение об ошибке

  Примеры:
    |неверный логин|
    |логинРусскимиБуквами|
    |ВторойПримерЛогина|
    |ТретийПримерЛогина|

