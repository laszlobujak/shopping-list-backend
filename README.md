# Bevásárlólista
Ez egy olyan webalkalmazás, ahol a családok vagy egyéb különböző csoportok közösen tarthatják nyilván a megvásárolni szükséges termékeket, azokhoz megjegyzéseket fűzhetnek, elletve új listákat hozhatnak létre.
## Követelményanalízis
### Funkcionális követelmények
A program az alábbi funkciókat valósítja meg:
- regisztráció
- bejelentkezés/kijelentkezés
- profil szerkesztése
- bevásárlólisták listázása: egy bejelentkezett felhasználó látja azokat a bevásárlólistákat, amelyekben szerepel
- új lista létrehozása: egy felhasználó létrehozhat egy új bevásárlólistát, ezáltal az adott lista tulajdonosává válik
- lista törlése: a tulajdonos törölheti az általa létrehozott bevásárlólistát
- tagok hozzáadása a listához: új tagokat lehet hozzárendelni egy adott listához, így számukra is láthatóvá és szerkeszthetővé válik az adott bevásárlólista
- tag eltávolítása a listáról
- termék felvétele: új termék hozzáadása a listához a mennyiség, mértékegység és a termék neve megadásával
- termék törlése
- termék státuszának módosítása: ha egy terméket valaki megvásárolt, ezt jelezheti az alkalmazásban
- megjegyzés írása: a listatagoknak lehetőségük van az egyes termékekhez megjegyzéseket fűzni
### Nem funkcionális követelmények
- felhasználóbarát kinézet, könnyű kezelhetőség
- gyors működés
- biztonságos működés: jelszavak biztonságos tárolása, különböző szerepkörök használata
### Szerepkörök
1. Vendég
- eléri a főodalt, ahol lehetősége van regisztrálni vagy bejelentkezni
2. Bejelentkezett felhasználó
- bejelentkezés után láthatja az adatait, azokat szerkesztheti
- új bevásárlólistát hozhat létre, ezáltal tulajdonossá válik
3. Közreműködő
- az adott bevásárlólista megjelenik az adatlapján, azt megtekintheti
- új terméket vehet fel a listára
- törölhet terméket
- módosíthatja egy termék státuszát
- megjegyzéseket fűzhet a termékekhez
- törölheti magát a lista közreműködői közül
4. Listatulajdonos
- új közreműködőket adhat hozzá a listához felhasználónév megadásával
- eltávolíthat tagokat a közreműködők közül
- törölheti a listát

## Tervezés

### Fejlesztői környezet

#### Szerver oldali eszközök

* [NetBeans](https://netbeans.org/) IDE 8.2 használata
* [Java](https://www.java.com/) 1.8 [Spring Boot](https://projects.spring.io/spring-boot/) 2.0.5 technológia használata
* [H2](http://www.h2database.com/) 1.4.197 adatbázis használata
* [MAVEN](https://maven.apache.org/) 3.6.0 a projekt menedzseléséhez és a build folyamat automatizálásához
* [Github](https://github.com/) a projekt közzétételéhez

#### Kliens oldali eszközök

* [Visual Studio Code](https://netbeans.org/) fejlesztőkörnyezet használata
* [HTML5](https://htmlreference.io/) és [CSS3](https://cssreference.io/) a megjelenítéshez
* [Angular](https://angular.io/) keretrendszer használata
* [Node.js](https://nodejs.org/) 10.14.1, [NPM](https://www.npmjs.com/) 6.4.1 használata
* [Mozilla Firefox](https://www.mozilla.org/hu/firefox/) 63.0.3, [Google Chrome](https://www.google.com/chrome/) 71.0.3578.80 webböngészők használata

### Adatbázis-terv

![Adatbázis-terv modellje](db_uml.png)

### Könyvtárstruktúra

- main
    - java
        - hu
            - elte
                - shoppinglist
                    - `ShoppinglistApplication.java`
                    - controllers
                        - `ItemController.java`
                        - `MessageController.java`
                        - `ShoppingListController.java`
                        - `UserController.java`
                    - entities
                        - `Item.java`
                        - `Message.java`
                        - `Shopping.java`
                        - `User.java`
                    - repositories
                        - `ItemRepository.java`
                        - `MessageRepository.java`
                        - `ShoppingRepository.java`
                        - `UserRepository.java`
                    - security
                        - `WebSecurityConfig.java`
    - resources
        - `data.sql`
        - `application.properties`

### Végpontok

#### shoppinglist

- `GET /shoppinglist/` : Az összes bevásárlólista lekérdezése
- `GET /shoppinglist/{id}` : Egy bevásárlólista lekérdezése
- `GET /shoppinglist/{id}/item` : Egy bevásárlólista elemeinek lekérdezése
- `POST /shoppinglist/` : Bevásárlólista létrehozása
- `POST /shoppinglist/{id}/item` : Bevásárlólistához elem hozzáadása
- `PUT /shoppinglist/{id}` : Bevásárlólista módosítása
- `DELETE /shoppinglist/{id}` : Bevásárlólista törlése

#### message

- `GET /message/` : Az összes komment lekérdezése
- `GET /message/{id}` : Egy komment lekérdezése
- `POST /message/` : Komment létrehozása
- `PUT /message/{id}` : Komment módosítása
- `DELETE /message/{id}` : Komment törlése

#### item

- `GET /item/` : Az összes termék lekérdezése
- `GET /item/{id}` : Egy termék lekérdezése
- `GET /item/{id}/message` : Egy termék kommentjeinek lekérdezése
- `POST /item/` : Termék létrehozása
- `POST /item/{id}/message` : Termékhez komment hozzáadása
- `PUT /item/{id}` : Termék módosítása
- `DELETE /item/{id}` : Termék törlése

#### user

- `POST /user/register` : Felhasználó hozzáadása
- `POST /user/login` : Bejelentkezés

### Használati eset diagram

![Használati eset diagram](usecase.png)

### Folyamat leírása

Az alábbi ábrán egy új termék felvételének a folyamatát láthatjuk:
![Folyamat](activity.png)

## Felhasználói dokumentáció

### Rendszerkövetelmények

Az alkalmazásnak nincsenek különleges hardverkövetelményei, valamint bármilyen operációs rendszeren futtatható.
Szükséges szoftverek: [Node.js](https://nodejs.org/en/download/), [Angular](https://angular.io/), bármilyen webböngésző

### Telepítés

- Töltsük le a githubról a forráskódot és csomagoljuk ki egy tetszőleges mappába
- A forráskönyvtárban adjuk ki az `npm i`, majd az `ng serve` parancsot
- Ezután egy általunk választott böngészőben nyissuk meg a [http://localhost:4200](http://localhost:4200) címet

### Használat

- Bejelentkezés: ha még nem regisztrált, akkor a regisztráció gombra kattintva felhasználónév és jelszó megadásával lehet ezt megtenni. Sikeres regisztráció után a megadott felhasználónév-jelszó pár megadásával lehet belépni a rendszerbe.

- Kezdőoldal: itt láthatóak azon listák, amelyekben a felhasználó közreműködőként részt vesz. Lehetőség van új listát létrehozni, illetve szerkeszteni egy meglévőt.

- Lista: egy listát kiválasztva megjelennek a benne lévő termékek. Lehetőség van új terméket hozzáadni a listához, ehhez meg kell adni a nevet, a mennyiséget, a mértékegységet. Egy terméknek meg lehet változtatni az állapotát, ezek a szükséges és a megvásárolt állapotok lehetnek. Emellett lehetőség van megjegyzést fűzni egy termékhez, illetve törölni egy terméket.

- Listaadminisztrátor: ha valaki egy új listát hozott létre, az automatikusan listaadminisztrátorrá válik. Ilyenkor lehetősége van közreműködőket hozzáadni a listához felhasználónév alapján, illetve törölni őket a listáról, valamint magát a listát is lehet törölni.
