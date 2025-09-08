ClockShopping E-Commerce Web Application / ClockShopping E-Ticaret Web Uygulaması

Bu proje, saat satışı üzerine kurulmuş bir tam özellikli e-ticaret web uygulamasıdır. Kullanıcılar ürünleri görüntüleyebilir, sepet oluşturabilir, sipariş verebilir ve ödeme yapabilir. Ayrıca JWT tabanlı güvenlik sayesinde kullanıcı işlemleri güvenli bir şekilde yönetilir.

This project is a full-featured e-commerce web application focused on selling watches. Users can browse products, add items to their cart, place orders, and make payments. The application uses JWT-based security to ensure safe user operations.

🔹 Özellikler / Features

Ürün Yönetimi / Product Management

Saat ürünleri listeleme, detay görüntüleme / List and view watch products

Ürün stok kontrolü / Product stock control

Kategori ve filtreleme / Category and filter options

Alışveriş Sepeti / Shopping Cart

Ürün ekleme, çıkarma ve güncelleme / Add, remove, and update products in cart

Sepet tutarı ve miktar hesaplama / Cart total and quantity calculation

Sipariş ve Ödeme / Orders & Payment

Sipariş oluşturma ve takibi / Create and track orders

Kullanıcı başına sipariş geçmişi / User-specific order history

Ödeme entegrasyonu için API / API ready for payment integration

Güvenlik / Security

JWT tabanlı kullanıcı doğrulama ve yetkilendirme / JWT-based user authentication & authorization

Rollere göre erişim kontrolü / Role-based access control

Dinamik ve İşletmeye Özel / Dynamic & Business-Oriented

Ürün ve sipariş yönetimi, kullanıcı deneyimi odaklı / Product & order management focused on user experience

API ve frontend entegrasyonu ile esnek kullanım / Flexible usage with API and frontend integration

🔹 Teknolojiler / Technologies

Java 17

Spring Boot 3

Spring Security & JWT

Spring Data JPA

PostgreSQL

Maven

React.js (frontend)

🔹 Kurulum / Setup

Repository’yi klonlayın / Clone the repository:

git clone https://github.com/cakmaak/ClockShopping.git
cd ClockShopping


PostgreSQL bağlantı ayarlarını application.properties dosyasında yapılandırın / Configure PostgreSQL connection in application.properties:

spring.datasource.url=jdbc:postgresql://[HOST]:5432/[DB_NAME]
spring.datasource.username=[USERNAME]
spring.datasource.password=[PASSWORD]
spring.jpa.hibernate.ddl-auto=update


Projeyi Maven ile çalıştırın / Run the project with Maven:

mvn spring-boot:run


Uygulama varsayılan olarak http://localhost:8080 adresinde çalışacaktır / The app will run at http://localhost:8080 by default.

🔹 API Endpoints (Örnekler / Examples)

Ürünler / Products

GET /products - Tüm ürünleri listeleme / List all products

GET /products/{id} - Ürün detayını görüntüleme / View product details

Sepet / Cart

POST /cart - Ürün ekleme / Add product to cart

PUT /cart/{id} - Ürün miktarını güncelleme / Update product quantity

DELETE /cart/{id} - Ürün silme / Remove product from cart

Sipariş / Orders

POST /orders - Sipariş oluşturma / Create order

GET /orders - Kullanıcının siparişlerini listeleme / List user orders

Kullanıcı / User

JWT ile güvenli giriş ve erişim / Secure login and access with JWT

🔹 Kullanım / Usage

Kullanıcı giriş yaptıktan sonra JWT token alır / User receives JWT token after login.

Kullanıcı sadece kendi sepet ve siparişlerini yönetebilir / Users can only manage their own cart and orders.

Yönetici rolleri ürün ekleme ve güncelleme gibi işlemleri yapabilir / Admin roles can perform product management actions.

E-ticaret ve saat satış odaklı dinamik yapı / Dynamic architecture for e-commerce and watch sales.

🔹 Lisans / License

Bu proje MIT lisansı ile lisanslanmıştır / This project is licensed under MIT License.
