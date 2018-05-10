# language: ru

@all
Функция: Работа с командной строкой

  Предыстория:
    Допустим в системе существует комнандный интерпритатор CMD

  @correct
  Сценарий: Проверка суммы 1+2
    Если введена команда set /a t=1+2
    То ответом будет 3

  @fail
  Сценарий: Некорректный расчет суммы
    Если введена команда set /a t=2+2
    То ответом будет 3

