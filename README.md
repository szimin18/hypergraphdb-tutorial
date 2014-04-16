## hypergraphdb-tutorial

Prosty program wprowadzajacy do używania HypergraphDB przy użyciu języka Clojure


## Instrukcja konfiguracji bazy danych HypergraphDB w języku Clojure (system operacyjny: Windows 7)

Pierwszym krokiem jest instalacja programu Leiningen. Jest to program służący do zarządzania projektami jak i ich uruchamiania. Plik instalacyjny programu dostępny jest pod linkiem: https://raw.github.com/technomancy/leiningen/stable/bin/lein.bat Po pobraniu należy uruchomić skrypt, który zainstaluje nam Leiningena. Należy pamiętac o dodaniu programu do zmiennej środowiskowej PATH.

Kozystając z programu Leiningen używamy kielku poleceń:

lein new <nazwa_projektu> - tworzy w bieżącej lokalizacji nowy katalog o nazwie projektu oraz tworzy w nim wszystkie pliki projektu

lein run {args} - wywoływane z poziomu folderu projektu, uruchamia program z podanymi argumentami

lein deps - dołącza niezbędne składniki projektu wypisane w powiazaniach projektu

lein pom - tworzy plik pom niezbedny do zaimportowania projektu do programu IntelliJ Idea

lein test - uruchamia testy

Kolejnym krokiem jest zaimportowanie projektu do program IntelliJ Idea. Na poczatku pracy z programem należy zainstalować wtyczkę Cursive Clojure (Settings->Plugins). Aby tego dokonać należy dodać do listy repozytoriów adres wybrany ze strony https://cursiveclojure.com/userguide/ (odpowiadający zainstalowanej wersji środowiska IntelliJ), oraz zainstalować wtyczkę. Zalecane jest także, jesli jest włączona,  wyłaczenie opcji "Use structural editing" (Settings->Clojure), gdyż utrudnia to pracę. Zakładka opcji wtyczki do Clojure może być dostępna dopiero po ponownym uruchomieniu środowiska. Po wykonaniu powyższych czynności można zaimprotować utworzony przez Leiningena projekt.

Aby uruchomić projekt używajacy HypergraphDB należy dodać do projekt następujące zależnośc: [org.hypergraphdb/hgdb "1.2"] [org.hypergraphdb/hgbdbje "1.2"] [com.sleepycat/je "5.0.73"]. Niestety powyższe paczki dotyczące hypergraphDB zawierają błędy uniemożliwiajace zdalne ich dodawanie. W tym celu należy dodać je ręcznie. Najpierw należy zainstalować program maven (http://ftp.piotrkosoft.net/pub/mirrors/ftp.apache.org/maven/maven-3/3.2.1/binaries/apache-maven-3.2.1-bin.zip). Należy dodać podfolder bin z wypakowanego folderu do zmiennej środowiskowej Path, tak aby dostępne było polecenie mvn. Kolejnym krokiem jest dodanie NOWEJ zmiennej SYSTEMOWEJ o nazwie "JAVA_HOME", oraz ustawienie jej na lokalizację JDK Javy. Należy także dodać JDK Javy do zmiennej SYSTEMOWEJ PATH. Teraz pora na dodanie paczek org.hypergraph. Najpierw należy je pobrać (http://hypergraphdb.googlecode.com/files/hgdbdist-1.2-final.zip), następnie wypakować i przejść do folderu lib. W tym folderze wywołujemy dwa polecenia:

mvn install:install-file -Dfile=hgdb-1.2.jar -DgroupId=org.hypergraphdb -DartifactId=hgdb -Dversion="1.2" -Dpackaging=jar

oraz

mvn install:install-file -Dfile=hgbdbje-1.2.jar -DgroupId=org.hypergraphdb -DartifactId=hgbdbje -Dversion="1.2" -Dpackaging=jar

Gdy całe środowisko jest już przygotowane nalezy sprawdzić poprawność jego przygotowania poprzez zaimportowanie prostego projektu inicjalizującego bazę danych (http://student.agh.edu.pl/~slabuz/hgdbt.zip). Uruchomienie projektu za pomocą leiningena jest możliwe wyłącznie z poziomu terminala, jadnak środowisko IntelliJ posiada wbudowany terminal. Po otwarciu projektu należy uruchomić terminal (Alt+F12), a następnie spróbować dołączyć powiazania z poziomu terminala komendą 'lein deps'. Po poprawnym wykonaniu powyższego polecenia można już uruchomić program komendą 'lein run'. Rezultatem działania tego prostego programu będzie utworzona baza danych.