# LocaledSwingUI
# Библиотека многоязычных компонентов Swing.

В библиотеку входит набор графических компонентов - наследников компонентов Swing. Это позволяет использовать все возможности Swing. Отличием является использование вместо строковых значений текстовых полей компонентов ключей, по которым производится поиск текстовых значений в файлах ресурсов.

Для многоязычных строк применяется тип <code>LocaledString</code>. Он включает в себя ключ строки, массив аргументов строки, путь к пакету с файлами ресурсов, и признак useSubPackage.

Строки размещаются в файлах ресурсов "<em>locale.properties</em>", где locale - язык строк, например, "<em>ru.properties</em>", "<em>en.properties</em>". Файлы представляют из себя набор текстовых пар "<code>ключ = значение</code>". Значение может иметь аргументы {0}, {1} и т.д. Вместо этих символов будут подставлены значения из массива аргументов с соответствующим индексом. Например:
<code>test.string.key = Это тестовое значение {0} строки.</code>
Вместо {0} будет подставлено значение 0-го элемента массива аргументов, при подстановке само значение будет преобразовано в строку через toString().
По умолчанию используется кодировка UTF-8.

Пакет, в котором производится поиск ресурсов, по умолчанию имеет путь "<em>src/main/resources/strings</em>", может быть получен методом <code>LocaleContext.getDefaultStringResourcePackage()</code>, при необходимости его можно изменить <code>LocaleContext.setDefaultStringResourcePackage(String defaultStringResourcePackage)</code>. Если задано использование вложенных пакетов (<code>useSubPackage = true</code>), то пакет, в котором будет производиться поиск ключа, будет определяться конкатенацией используемого пакета и части ключа до первой точки. При этом ключ не обрезается. Например:
- пакет: "<em>src/main/resources/strings</em>"
- ключ: "<em>test.error.message</em>"
Пакет, в котором будет производиться поиск ключа: "<em>src/main/resources/strings/test</em>"
 
Поиск строки по ключу в файле ресурсов производится классом <code>R</code> (сокращение от Resources). При первом обращении к файлу ресурсов он считывается в оперативную память и во время следующих обращений поиск осуществляется в ОЗУ, что позволяет ускорить работу приложения. Если ключ не находится в файле соответствующего языка, поиск производится в ресурсах языка по умолчанию.

В классе <code>LocaleContext</code> задаются параметры: язык пользователя, язык по умолчанию, пакет расположения файлов ресурсов, кодировка файлов ресурсов. При необходимости все значения могут быть изменены. Все методы этого класса доступны из приложения, в котором используется библиотека.

Библиотека включает в себя большинство компонентов библиотеки Swing. Каждый из компонентов имеет метод <code>changeLocale()</code>. Этот метод устанавливает новые значения текстовых полей, имеющихся в компоненте, а затем вызыват этот метод у внутренних компонентов. Таким образом, вызвав метод у компонента верхнего уровня, например главного окна приложения, можно изменить язык у всех внутренних компонентов, не запоминая, где и какие строки используются. Собственно перебор всех внутренних компонентов осуществляется в утилитном  классе <code>LocaleUtils</code>. Т.к. изменение языка при работе приложения происходит нечасто, и поиск значений строк осуществляется в ОЗУ после первого обращения к файлу ресурсов, особого замедления работы приложения не должно быть.