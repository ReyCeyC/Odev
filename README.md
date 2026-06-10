ÖĞRENCİ NOT TAKİP SİSTEMİ 

Bu proje, öğrencilerin ders notlarını dijital ortamda takip edebilmesi, vize ve final notlarına göre ortalama hesaplayabilmesi ve akademik durumlarını görüntüleyebilmesi amacıyla geliştirilmiştir.

Uygulama ayrıca dış bir REST API kullanarak kullanıcıya günlük rastgele motivasyon sözü göstermektedir.

PROJE ÖZELLİKLERİ
Login Sistemi

Uygulamada basit bir giriş sistemi bulunmaktadır. Kullanıcı adı ve şifre kontrolü yapıldıktan sonra ana ekrana yönlendirme sağlanır.

Ana Ekran (MainActivity)

Ana ekranda kullanıcıya aşağıdaki bilgiler sunulur:

Kayıtlı ders notlarının listesi
Her ders için ortalama hesaplama
Genel not ortalaması
Günün sözü (API üzerinden çekilir)
Not Ekleme Ekranı (AddNoteActivity)

Kullanıcı aşağıdaki bilgileri girerek yeni ders notu ekleyebilir:

Ders adı
Vize notu
Final notu

Girilen veriler SQLite veritabanına kaydedilir.

VERİ TABANI (SQLite)

Uygulama yerel veri saklamak için SQLite kullanmaktadır.

Saklanan veriler:
Ders adı
Vize notu
Final notu
İşlemler:
Veri ekleme
Veri listeleme
API ENTEGRASYONU (RETROFIT)

Uygulamada ücretsiz bir REST API kullanılmıştır.

API adresi:
https://api.quotable.io/random

Bu API sayesinde ana ekranda rastgele bir motivasyon sözü gösterilmektedir.

ORTALAMA HESAPLAMA

Her ders için ortalama aşağıdaki formül ile hesaplanır:

Ortalama = (Vize * 0.4) + (Final * 0.6)

Tüm derslerin ortalaması alınarak genel başarı durumu hesaplanır.

KULLANILAN TEKNOLOJİLER
Kotlin
Android Studio
XML Layout
SQLite Database
Retrofit (REST API)
Material Design
PROJE YAPISI
LoginActivity: Kullanıcı giriş ekranı
MainActivity: Ana ekran (listeleme, ortalama, API gösterimi)
AddNoteActivity: Not ekleme ekranı
DatabaseHelper: SQLite veritabanı işlemleri
ApiService: API bağlantısı
QuoteResponse: API veri modeli
FONKSİYON AÇIKLAMALARI
loadData()

SQLite veritabanından ders notlarını çeker, liste halinde ekrana yansıtır ve ortalama hesaplamalarını yapar.

loadQuote()

Retrofit kullanarak API üzerinden rastgele bir motivasyon sözü çeker ve ekranda gösterir.

insertNote()

Kullanıcının girdiği ders notlarını veritabanına kaydeder.

getNotes()

Veritabanında kayıtlı tüm ders notlarını liste olarak döndürür.

PROJENİN AMACI

Bu proje aşağıdaki konuları öğrenmek amacıyla geliştirilmiştir:

Mobil uygulama geliştirme temelleri
SQLite veritabanı kullanımı
REST API entegrasyonu
Activity yapısı
Kullanıcı arayüzü tasarımı
SONUÇ

Bu uygulama sayesinde kullanıcılar:

Ders notlarını takip edebilir
Akademik ortalamalarını hesaplayabilir
Günlük motivasyon sözleri görebilir
